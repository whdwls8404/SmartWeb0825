DROP TABLE student;
DROP TABLE professor;
DROP TABLE major;

-- 교수
CREATE TABLE professor (
    prof_no     NUMBER(2) PRIMARY KEY,  -- 교수번호
    prof_name   VARCHAR2(20 BYTE),  -- 교수명
    major_no    NUMBER(2)  -- 전공번호
);

-- 전공
CREATE TABLE major (
    major_no    NUMBER(2) PRIMARY KEY,  -- 전공번호
    major_name  VARCHAR2(20 BYTE)  -- 전공명
);

-- 학생
CREATE TABLE student (
    stu_no      NUMBER PRIMARY KEY,  -- 학번
    stu_name    VARCHAR2(20 BYTE),  -- 학생명
    mark        NUMBER(3,2),  -- 성적(1.00 ~ 9.99)
    major_no    NUMBER(2),  -- 전공번호
    prof_no     NUMBER(2)  -- 담당교수번호
);

-- 외래키
ALTER TABLE student ADD CONSTRAINT student_professor_fk
    FOREIGN KEY (prof_no) REFERENCES professor(prof_no)
        ON DELETE CASCADE;

ALTER TABLE student ADD CONSTRAINT student_major_fk
    FOREIGN KEY (major_no) REFERENCES major(major_no)
        ON DELETE CASCADE;


INSERT INTO major (major_no,major_name) VALUES (11,'Java');
INSERT INTO major (major_no,major_name) VALUES (12,'Oracle');
INSERT INTO major (major_no,major_name) VALUES (13,'HTML/CSS');
INSERT INTO major (major_no,major_name) VALUES (14,'JavaScript');
INSERT INTO major (major_no,major_name) VALUES (15,'JSP');
INSERT INTO major (major_no,major_name) VALUES (16,'Spring');

INSERT INTO professor (prof_no,prof_name,major_no) VALUES (51,'다니엘',16);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (52,'제이슨',12);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (53,'캐서린',16);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (54,'소냐',11);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (55,'해럴드',14);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (56,'힐',15);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (57,'제임스',12);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (58,'나타샤',13);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (59,'데이빗',13);
INSERT INTO professor (prof_no,prof_name,major_no) VALUES (60,'프레딕',16);

INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210708,'베를린',0.55,16,55);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210709,'파리',4.5,15,55);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210710,'모스크바',3.25,14,55);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210711,'도쿄',1.85,13,55);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210712,'마닐라',2.25,11,57);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210713,'뉴욕',3.35,12,57);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210714,'시카고',3.5,16,57);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210715,'워싱턴',4.05,13,57);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210716,'토론토',1.95,15,57);
INSERT INTO student (stu_no,stu_name,mark,major_no,prof_no) VALUES (20210717,'마드리드',2.65,12,58);

COMMIT;



-- 1. 학생명, 전공명, 담당교수명을 조회하시오.
SELECT s.stu_name AS 학생명
     , m.major_name AS 전공명
     , p.prof_name AS 담당교수명
  FROM major m, student s, professor p
 WHERE m.major_no = s.major_no  -- 조인1
   AND p.prof_no = s.prof_no;  -- 조인2


-- 2. 담당교수별 학생수를 조회하시오.
-- 담당교수명  학생수
-- 해럴드      4
-- 제임스      5
-- 나타샤      1

SELECT p.prof_name AS 담당교수명
     , COUNT(*) AS 학생수  -- 그룹 함수 사용 (전체 개수 : GROUP BY 없음, 그룹별 개수 : GROUP BY 있음)
  FROM professor p, student s
 WHERE p.prof_no = s.prof_no
 GROUP BY p.prof_name;


-- 3. 전공별 학생들의 점수 평균을 조회하시오.
--    1) 소수점 내림 : FLOOR(AVG(s.mark))
--    2) 소수점 올림 : CEIL(AVG(s.mark))
--    3) 소수점 버림
--        (1) 소수 1자리 남기기 : TRUNC(AVG(s.mark), 1)
--        (2) 소수 2자리 남기기 : TRUNC(AVG(s.mark), 2)
--        (3) 정수 남기기       : TRUNC(AVG(s.mark))
--    4) 반올림
--        (1) 소수 1자리 남기기 : ROUND(AVG(s.mark), 1)
--        (2) 소수 2자리 남기기 : ROUND(AVG(s.mark), 2)
--        (3) 정수 남기기       : ROUND(AVG(s.mark))

SELECT m.major_name AS 전공명
     , CEIL(AVG(s.mark)) AS 평균  -- 평균의 올림 처리
  FROM major m, student s
 WHERE m.major_no = s.major_no
 GROUP BY m.major_name;


-- 4. 프로시저
-- 전공번호(major_no)를 전달하면 해당 전공에 관련된 모든 데이터를 삭제하는 proc 프로시저

-- 메시지 확인을 위해서 한 번 실행
SET SERVEROUTPUT ON;

-- 프로시저 작성
CREATE OR REPLACE PROCEDURE proc(v_major_no IN NUMBER)
IS
BEGIN
    DELETE FROM student WHERE major_no = v_major_no;
    DELETE FROM major WHERE major_no = v_major_no;
    DELETE FROM professor WHERE major_no = v_major_no;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLCODE);  -- 에러코드 출력
        DBMS_OUTPUT.PUT_LINE(SQLERRM);  -- 에러메시지 출력
        ROLLBACK;
END proc;


-- 프로시저 실행
EXECUTE proc(12);

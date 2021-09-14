-- 다중 행 서브쿼리
-- 1. 서브쿼리의 결과가 2행 이상인 쿼리이다.
-- 2. 다중 행 서브쿼리 연산자 : IN, ALL, ANY 등


-- 1. 부서번호가 2인 부서에 존재하는 직급을 가진 모든 사원 정보를 조회하시오.
--    서브쿼리 : 부서번호가 2인 부서에 존재하는 직급 (결과 : '부장', '과장')
SELECT *
  FROM employee
 WHERE position IN (SELECT position
                      FROM employee
                     WHERE depart = 2);

-- 2. '과장'이 근무하고 있는 모든 지역명을 조회하시오.
--    서브쿼리 : '과장'이 근무하는 모든 부서번호 (결과 : 1, 2)
SELECT location
  FROM department
 WHERE dept_no IN (SELECT depart
                     FROM employee
                    WHERE position = '과장');

-- 3. '영업부'와 '인사부'에 근무하는 사원들의 이름을 조회하시오.
--    서브쿼리 : '영업부'와 '인사부'에 근무하는 사원들의 부서번호 (결과 : 1, 2)
SELECT name
  FROM employee
 WHERE depart IN (SELECT dept_no
                    FROM department
                   WHERE dept_name IN ('영업부', '인사부'));


-- 4. 부서번호가 1인 부서에서 근무하는 모든 사원들의 급여보다 더 많은 급여를 받는 사원명과 급여를 조회하시오.
--    서브쿼리 : 부서번호가 1인 부서에서 근무하는 모든 사원들의 급여 (결과 : 5000000, 2500000)

-- 1) 급여가 5000000 그리고 2500000 보다 많은 급여를 찾는 경우
--    서브쿼리의 결과를 모두 만족하는가? ALL 연산자
SELECT name, salary
  FROM employee
 WHERE salary > ALL(SELECT salary
                      FROM employee
                     WHERE depart = 1);

-- 2) 급여가 5000000 또는 2500000 보다 많은 급여를 찾는 경우
--    서브쿼리의 결과 중 하나라도 만족하는가? ANY 연산자
SELECT name, salary
  FROM employee
 WHERE salary > ANY(SELECT salary
                      FROM employee
                     WHERE depart = 1);


-- 5. 부서번호가 1인 부서에서 근무하는 모든 사원들의 급여보다 더 많은 급여를 받는 사원명과 급여를 조회하시오.
--    ALL과 ANY 연산자를 사용하지 않고 해결하시오.

-- 1) 급여가 5000000 그리고 2500000 보다 많은 급여를 찾는 경우
--    (급여가 5000000 보다 많은 급여 = 최대 급여보다 많은 급여)
SELECT name, salary
  FROM employee
 WHERE salary > (SELECT MAX(salary)
                   FROM employee
                  WHERE depart = 1);

-- 2) 급여가 5000000 또는 2500000 보다 많은 급여를 찾는 경우
--    (급여가 2500000 보다 많은 급여 = 최소 급여보다 많은 급여)
SELECT name, salary
  FROM employee
 WHERE salary > (SELECT MIN(salary)
                   FROM employee
                  WHERE depart = 1);



-- 인라인 뷰 (inline view)
-- 1. FROM절에서 사용하는 서브쿼리이다.
-- 2. FROM절에서 사용하는 서브쿼리의 결과는 테이블인 경우가 대부분이다.
-- 3. FROM절에서 사용한 서브쿼리의 SELECT절에 있는 칼럼들만 메인쿼리에서 사용할 수 있다.


SELECT emp_no, name
  FROM (SELECT emp_no, name  -- 서브쿼리에서 emp_no, name만 조회했기 때문에, 메인쿼리도 emp_no, name만 조회할 수 있다.
          FROM employee);

SELECT emp_no, name, position  -- 불가 : position은 서브쿼리에서 조회하지 않았기 때문.
  FROM (SELECT emp_no, name  -- 서브쿼리에서 emp_no, name만 조회했기 때문에, 메인쿼리도 emp_no, name만 조회할 수 있다.
          FROM employee);

SELECT e.emp_no, e.name
  FROM (SELECT emp_no, name
          FROM employee) e;  -- 서브쿼리에 별명을 붙여서 사용한다.



-- 인라인 뷰 확인을 위한 테이블 추가

DROP TABLE BOARD;
DROP TABLE MEMBER;

CREATE TABLE BOARD (
    BOARD_NO NUMBER PRIMARY KEY,  -- 글번호, 기본키
    BOARD_TITLE VARCHAR2(1000) NOT NULL,  -- 제목, 필수
    BOARD_CONTENT VARCHAR2(4000),  -- 내용
    MEMBER_ID VARCHAR2(30),  -- 작성자, 외래키(MEMBER 테이블의 MEMBER_ID 참조)
    CREATED_DATE DATE  -- 작성일자
);

CREATE TABLE MEMBER (
    MEMBER_NO NUMBER PRIMARY KEY,  -- 회원번호, 기본키
    MEMBER_ID VARCHAR2(30) NOT NULL UNIQUE,  -- 회원아이디, 필수, 중복 없음 (UNIQUE 제약조건은 관계 맺을 때 PK처럼 사용)
    MEMBER_PASSWORD VARCHAR2(30) NOT NULL,  -- 회원비밀번호, 필수
    CREATED_DATE TIMESTAMP  -- 가입일자
);

ALTER TABLE BOARD ADD CONSTRAINT BOARD_MEMBER_FK FOREIGN KEY (MEMBER_ID) REFERENCES MEMBER(MEMBER_ID);

DROP SEQUENCE BOARD_SEQ;
DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE BOARD_SEQ NOCACHE;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;

INSERT INTO MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PASSWORD, CREATED_DATE) VALUES (MEMBER_SEQ.NEXTVAL, 'user1', '1234', SYSTIMESTAMP);
INSERT INTO MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PASSWORD, CREATED_DATE) VALUES (MEMBER_SEQ.NEXTVAL, 'user2', '1234', SYSTIMESTAMP);
INSERT INTO MEMBER (MEMBER_NO, MEMBER_ID, MEMBER_PASSWORD, CREATED_DATE) VALUES (MEMBER_SEQ.NEXTVAL, 'user3', '1234', SYSTIMESTAMP);

INSERT INTO BOARD (BOARD_NO, BOARD_TITLE, BOARD_CONTENT, MEMBER_ID, CREATED_DATE) VALUES (BOARD_SEQ.NEXTVAL, '공지사항', '공지', 'user1', SYSDATE);
INSERT INTO BOARD (BOARD_NO, BOARD_TITLE, BOARD_CONTENT, MEMBER_ID, CREATED_DATE) VALUES (BOARD_SEQ.NEXTVAL, '출석', '출', 'user2', SYSDATE);
INSERT INTO BOARD (BOARD_NO, BOARD_TITLE, BOARD_CONTENT, MEMBER_ID, CREATED_DATE) VALUES (BOARD_SEQ.NEXTVAL, '필독', '꼭 읽어야 함', 'user2', SYSDATE);
INSERT INTO BOARD (BOARD_NO, BOARD_TITLE, BOARD_CONTENT, MEMBER_ID, CREATED_DATE) VALUES (BOARD_SEQ.NEXTVAL, '공구안내', '놓치면 후회함', 'user2', SYSDATE);
INSERT INTO BOARD (BOARD_NO, BOARD_TITLE, BOARD_CONTENT, MEMBER_ID, CREATED_DATE) VALUES (BOARD_SEQ.NEXTVAL, '협조', '매일 댓글 달 것', 'user3', SYSDATE);

COMMIT;  -- INSERT에 적용



-- 가상 칼럼
-- 1. 존재한다.
-- 2. 저장되어 있지 않다.
-- 3. 존재하므로 사용할 수 있다.
-- 4. 종류 : ROWID, ROWNUM



-- ROWID  : 해당 행(ROW)의 물리적 저장 위치 정보

SELECT ROWID
     , board_title
  FROM board;

-- 오라클 최고의 조회 속도
-- ROWID를 직접 이용하기
SELECT board_title
  FROM board
 WHERE ROWID = 'AAAE+TAAEAAAAUcAAC';  -- 실제로 사용하지는 못한다.

-- ROWID의 직접 사용은 어렵기 때문에
-- 휴먼들은 인덱스(INDEX)를 사용.



-- ROWNUM : 해당 행(ROW)의 번호

SELECT ROWNUM    -- 페이징 처리에서 사용
     , board_no  -- 항상 순서대로 존재한다고 볼 수 없기 때문에 페이징 처리에서 사용 불가
     , board_title
  FROM board;



-- ROWNUM 칼럼의 사용 방법
-- 1. 1을 포함하는 범위는 조회할 수 있다.
-- 2. 특정 위치를 지정하는 검색은 할 수 없다. (ROWNUM = 2, ROWNUN = 3 등 모두 불가)
-- 3. 1이 아닌 ROWNUM을 사용하려면 ROWNUM 칼럼에 별명(AS)을 주고 그 별명을 사용한다.

SELECT ROWNUM
     , board_title
  FROM board
 WHERE ROWNUM = 1;  -- 가능

SELECT ROWNUM
     , board_title
  FROM board
 WHERE ROWNUM BETWEEN 1 AND 3;  -- 가능

SELECT ROWNUM
     , board_title
  FROM board
 WHERE ROWNUM = 2;  -- 불가능

SELECT ROWNUM
     , board_title
  FROM board
 WHERE ROWNUM BETWEEN 2 AND 4;  -- 불가능


-- ROWNUM 칼럼에 별명 주고 사용
SELECT ROWNUM AS rn
     , board_title
  FROM board
 WHERE rn = 2;  -- 불가. WHERE절에서는 SELECT절에서 만든 별명 rn을 사용할 수 없다.

-- FROM절에서 rn을 만들기 위해서 인라인 뷰를 활용한다.
SELECT inline_view.rn
     , inline_view.board_title
  FROM (SELECT ROWNUM AS rn
             , board_title
          FROM board) inline_view  -- 서브쿼리 별명 inline_view
 WHERE inline_view.rn BETWEEN 2 AND 4;




-- 1. BOARD 테이블의 정렬이 없는 상태에서,
--    3번째 게시글을 조회한다.
SELECT a.*
  FROM (SELECT ROWNUM AS rn
             , board_no
             , board_title
             , board_content
             , created_date
          FROM board) a
 WHERE a.rn = 3;

-- 2. BOARD 테이블의 정렬이 없는 상태에서,
--    2~4번째 게시글을 조회한다.
SELECT a.*
  FROM (SELECT ROWNUM AS rn
             , board_no
             , board_title
             , board_content
             , created_date
          FROM board) a
 WHERE a.rn BETWEEN 2 AND 4;

-- 3. 가장 먼저 작성한 BOARD 테이블의 게시글을 조회한다.
--    작성일자순으로 오름차순 정렬(오래된 작성일자가 먼저 나옴) 후
--    첫 번째 게시글을 조회한다.
--    작업순서 : 정렬 -> ROWNUM
--    정렬한 테이블의 별명 : a
--    정렬한 테이블에 ROWNUM 추가한 테이블의 별명 : b
SELECT b.rn
     , b.board_no
     , b.board_title
     , b.created_date
  FROM (SELECT ROWNUM AS rn
             , a.board_no
             , a.board_title
             , a.created_date
          FROM (SELECT board_no
                     , board_title
                     , created_date
                  FROM board
                 ORDER BY created_date) a) b
 WHERE b.rn = 1;


-- 4. 3번째로 작성한 게시글을 조회하시오.
SELECT b.rn
     , b.board_no
     , b.board_title
     , b.created_date
  FROM (SELECT ROWNUM AS rn
             , a.board_no
             , a.board_title
             , a.created_date
          FROM (SELECT board_no
                     , board_title
                     , created_date
                  FROM board
                 ORDER BY created_date) a) b
 WHERE b.rn = 3;
 

-- 5. 게시글의 제목순으로 오름차순 정렬한 뒤 2~4번째 게시글을 조회하시오.
SELECT b.rn
     , b.board_no
     , b.board_title
     , b.created_date
  FROM (SELECT ROWNUM AS rn
             , a.board_no
             , a.board_title
             , a.created_date
          FROM (SELECT board_no
                     , board_title
                     , created_date
                  FROM board
                 ORDER BY board_title) a) b
 WHERE b.rn BETWEEN 2 AND 4;



-- 테이블 복사
-- 1. CREATE TABLE + 서브쿼리(복사할 테이블 조회)
-- 2. PK, FK와 같은 제약조건은 복사되지 않는다.
-- 3. 구조만 복사하거나, 행을 포함한 전체를 복사할 수 있다.


-- 행을 포함한 전체 복사
CREATE TABLE board2
    AS (SELECT *
          FROM board);


-- board2 테이블의 제약 조건 확인
DESC user_constraints;
SELECT constraint_name FROM user_constraints WHERE table_name = 'BOARD2';  -- PK, FK는 없음을 확인


-- 구조만 복사 (행을 제외)
CREATE TABLE board3
    AS (SELECT *
          FROM board
         WHERE 1 = 2);

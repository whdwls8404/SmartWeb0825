-- 시퀀스
-- 1. 일련번호를 생성하는 객체이다.
-- 2. 기본키(PK)에서 자동으로 증가하는 번호를 사용할 때 활용한다.
--    인공키
-- 3. CREATE SEQUENCE를 통해서 생성한다.


-- 시퀀스 삭제
DROP SEQUENCE department_seq;
DROP SEQUENCE employee_seq;


-- department 테이블에서 사용할 시퀀스 생성
CREATE SEQUENCE department_seq;

-- department 테이블의 모든 데이터 삭제
DELETE FROM department;

-- department 테이블에 데이터 추가
INSERT INTO department VALUES (department_seq.nextval, '영업부', '대구');
INSERT INTO department VALUES (department_seq.nextval, '인사부', '서울');
INSERT INTO department VALUES (department_seq.nextval, '총무부', '대구');
INSERT INTO department VALUES (department_seq.nextval, '기획부', '서울');


-- employee 테이블에서 사용할 시퀀스 생성
CREATE SEQUENCE employee_seq
    START WITH 1001  -- 시작값
    INCREMENT BY 1   -- 1씩 증가
    MINVALUE 1001    -- 최소값( 없는 경우 NOMINVALUE )
    MAXVALUE 9999    -- 최대값( 없는 경우 NOMAXVALUE )
    NOCACHE          -- 메모리 캐쉬 기능( 있는 경우 CACHE, 항상 NOCACHE 사용 권장 )
    NOCYCLE;         -- 번호 순환( 있는 경우 CYCLE, 항상 NOCYCLE 사용 )

-- employee 테이블에 데이터 추가
INSERT INTO employee VALUES (employee_seq.nextval, '구창민', 1, '과장', 'M', '95-05-01', 5000000);
INSERT INTO employee VALUES (employee_seq.nextval, '김민서', 1, '사원', 'M', '17-09-01', 2500000);
INSERT INTO employee VALUES (employee_seq.nextval, '이은영', 2, '부장', 'F', '90-09-01', 5500000);
INSERT INTO employee VALUES (employee_seq.nextval, '한성일', 2, '과장', 'M', '93-04-01', 5000000);


-- 시퀀스 상태 확인하기
-- SELECT 값 FROM 테이블;  테이블에 있는 값을 조회
-- 시퀀스는 테이블에 저장되어 있지 않기 때문에 'FROM 테이블'이 필요하지 않다.
-- 오라클 이외의 DB중에는 SELECT 값; 문법을 지원해서 'FROM 테이블'을 생략할 수 있다.
-- 그러나 오라클은 반드시 'FROM 테이블'이 필요하다.
-- 대신, FROM절의 테이블에 없는 값도 확인할 수 있다.
-- 이 상황을 해결하기 위해서 오라클은 DUAL 테이블을 지원한다.

SELECT department_seq.currval FROM DUAL;  -- 현재 사용한 값
SELECT department_seq.nextval FROM DUAL;  -- 다음에 사용할 값

SELECT employee_seq.currval FROM DUAL;
SELECT employee_seq.nextval FROM DUAL;

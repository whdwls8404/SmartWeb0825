-- 생성자 Oracle SQL Developer Data Modeler 20.4.0.374.0801
--   위치:        2021-09-08 11:49:46 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g


DROP TABLE employee;
DROP TABLE department;


-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE department (
    dept_no    NUMBER NOT NULL,
    dept_name  VARCHAR2(15 BYTE) NOT NULL,
    location   VARCHAR2(15 BYTE) NOT NULL
);

ALTER TABLE department ADD CONSTRAINT department_pk PRIMARY KEY ( dept_no );

CREATE TABLE employee (
    emp_no     NUMBER NOT NULL,
    name       VARCHAR2(20 BYTE) NOT NULL,
    depart     NUMBER,
    position   VARCHAR2(20 BYTE),
    gender     CHAR(2 BYTE),
    hire_date  DATE,
    salary     NUMBER
);

ALTER TABLE employee ADD CONSTRAINT employee_pk PRIMARY KEY ( emp_no );

ALTER TABLE employee
    ADD CONSTRAINT employee_department_fk FOREIGN KEY ( depart )
        REFERENCES department ( dept_no )
            ON DELETE CASCADE;


-- INSERT 방법
-- 1. INSERT INTO VALUES 쿼리문 이용
-- 2. 엑셀 데이터 생성 후 임포트 이용
--    1) 엑셀 데이터 생성(시트마다 테이블 1개)
--    2) 테이블 선택 후 우클릭 - [데이터 임포트]

-- department 행 삽입 (부모이므로 먼저 삽입)
INSERT INTO department VALUES (1, '영업부', '대구');
INSERT INTO department VALUES (2, '인사부', '서울');
INSERT INTO department VALUES (3, '총무부', '대구');
INSERT INTO department VALUES (4, '기획부', '서울');

-- employee 행 삽입 (자식이므로 나중에 삽입)
INSERT INTO employee VALUES (1001, '구창민', 1, '과장', 'M', '95-05-01', 5000000);
INSERT INTO employee VALUES (1002, '김민서', 1, '사원', 'M', '17-09-01', 2500000);
INSERT INTO employee VALUES (1003, '이은영', 2, '부장', 'F', '90-09-01', 5500000);
INSERT INTO employee VALUES (1004, '한성일', 2, '과장', 'M', '93-04-01', 5000000);


-- UPDATE
-- department 행 수정
-- 1. 부서번호가 1인 부서의 위치를 '인천'으로 수정하시오.
UPDATE department SET location = '인천' WHERE dept_no = 1;  -- WHERE절 : 조건

-- 2. 부서번호가 3인 부서의 이름을 '전략부', 위치를 '수원'으로 수정하시오.
UPDATE department SET dept_name = '전략부', location = '수원' WHERE dept_no = 3;

-- 3. 부서번호가 2인 부서의 부서번호를 5로 수정하시오.
--    1) 부서번호를 참조 중인 외래키(EMPLOYEE_DEPARTMENT_FK)를 잠시 중지한다.
--    2) DEPARTMENT, EMPLOYEE 모두 부서번호가 2인 부서의 부서번호를 5로 수정한다.
--    3) 외래키를 다시 시작한다.
ALTER TABLE employee DISABLE CONSTRAINT employee_department_fk;  -- 외래키 중지
UPDATE department SET dept_no = 5 WHERE dept_no = 2;
UPDATE employee SET depart = 5 WHERE depart = 2;
ALTER TABLE employee ENABLE CONSTRAINT employee_department_fk;  -- 외래키 동작 시작

-- employee 행 수정
-- 4. '과장'의 급여를 5% 인상하시오.
-- 새급여 = 기존급여 + 기존급여의 5%
-- 새급여 = 기존급여 * (1 + 5%)
-- 새급여 = 기존급여 * 1.05
UPDATE employee SET salary = salary * 1.05 WHERE position = '과장';

-- WHERE절
-- 1. 비교 연산 : >, >=, <, <=, =, !=(<>)
-- 2. 가능하면 PK를 이용한 조건식을 만든다. (조건 검색의 속도가 빠름)


-- DELETE
-- department 행 삭제
-- 1. 부서번호 3인 부서를 삭제하시오.
DELETE FROM department WHERE DEPT_NO = 3;

-- 2. department 전체를 삭제하시오.
-- ON DELETE CASCADE 옵션에 의해서 department에서 삭제된 dept_no를 가진 employee의 데이터도 함께 삭제
DELETE FROM department;
DELETE FROM employee;  -- 실행하지 않아도 이미 모두 삭제되어 있다.


-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             2
-- CREATE INDEX                             0
-- ALTER TABLE                              3
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

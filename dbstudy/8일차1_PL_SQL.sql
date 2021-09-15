-- HR 계정에 있는 employees 테이블을 SCOTT 계정으로 복사하기
-- CREATE TABLE 테이블명 AS (서브쿼리);
CREATE TABLE employees
    AS (SELECT *
          FROM HR.employees);


-- 복사된 employees 테이블에는 PK가 없으므로 PK 추가
ALTER TABLE employees ADD CONSTRAINT employees_pk PRIMARY KEY(employee_id);


/**************************************************************************/

-- 접속마다 1번 수행해야 하는 작업
-- 출력 결과를 화면에 띄울 수 있도록 세팅
-- 디폴트 : SET SERVEROUTPUT OFF
SET SERVEROUTPUT ON;


-- 기본구성
/*
    DECLARE
        변수 선언
    BEGIN
        작업
    END;
*/

-- 1. 화면 출력하기
-- DBMS_OUTPUT.PUT_LINE(출력대상)
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello Oracle PL/SQL');
END;


-- 2. 변수 선언하기 (스칼라 변수)
DECLARE
    my_name VARCHAR2(20 BYTE);
    my_age  NUMBER(3);
BEGIN
    my_name := '민경태';
    my_age := 44;
    DBMS_OUTPUT.PUT_LINE('내 이름은 ' || my_name || '입니다.');
    DBMS_OUTPUT.PUT_LINE('내 나이는 ' || my_age || '살입니다.');
END;


-- 3. 변수 선언하기 (참조 변수)
--    테이블.칼럼%TYPE
DECLARE
    v_employee_id employees.employee_id%TYPE;
    v_first_name  employees.first_name%TYPE;
    v_last_name   employees.last_name%TYPE;
BEGIN
    -- 테이블의 칼럼 데이터 가져오기
    -- SELECT 칼럼 INTO 변수 FROM 테이블
    SELECT employee_id,   first_name,   last_name
      INTO v_employee_id, v_first_name, v_last_name
      FROM employees
     WHERE employee_id = 100;
    DBMS_OUTPUT.PUT_LINE('사원번호: ' || v_employee_id);
    DBMS_OUTPUT.PUT_LINE('이름: ' || v_first_name);
    DBMS_OUTPUT.PUT_LINE('성: ' || v_last_name);
END;


-- 4. 변수 선언 (레코드 변수)
--    레코드(행, ROW) 전체를 저장할 수 있는 변수
DECLARE

    -- 레코드 타입명 : type_employee
    -- 레코드 타입 정의
    TYPE type_employee IS RECORD(
        v_employee_id employees.employee_id%TYPE,
        v_first_name  employees.first_name%TYPE,
        v_salary      employees.salary%TYPE
    );
    -- 레코드 타입 type_employee, 변수 v_record 선언
    v_record type_employee;
 
BEGIN

    -- employee_id가 100인 사원의 employee_id, first_name, salary 가져오기
    SELECT employee_id, first_name, salary
      INTO v_record
      FROM employees
     WHERE employee_id = 100;

    DBMS_OUTPUT.PUT_LINE('사원번호: ' || v_record.v_employee_id);
    DBMS_OUTPUT.PUT_LINE('이름: ' || v_record.v_first_name);
    DBMS_OUTPUT.PUT_LINE('연봉: ' || v_record.v_salary);

END;


-- 5. IF문
DECLARE
    score NUMBER(3);
    grade CHAR(1);
BEGIN
    score := 75;
    IF score >= 90 THEN
        grade := 'A';
    ELSIF score >= 80 THEN
        grade := 'B';
    ELSIF score >= 70 THEN
        grade := 'C';
    ELSIF score >= 60 THEN
        grade := 'D';
    ELSE
        grade := 'F';
    END IF;
    DBMS_OUTPUT.PUT_LINE('점수는 ' || score || '점이고, 학점은 ' || grade || '이다.');
END;


-- 연습문제. employee_id가 200인 사원의 salary가 5000 이상이면 '고액연봉' 아니면 공백을 출력하시오.
DECLARE
    v_salary employees.salary%TYPE;
    v_result VARCHAR2(20 BYTE);
BEGIN
    SELECT salary INTO v_salary
      FROM employees
     WHERE employee_id = 200;
    IF v_salary >= 5000 THEN
        v_result := '고액연봉';
    ELSE
        v_result := '';
    END IF;
    DBMS_OUTPUT.PUT_LINE('연봉: ' || v_salary || ', 결과: ' || v_result);
END;


-- 6. CASE문
DECLARE
    age    NUMBER(3);
    result VARCHAR2(20 BYTE);
BEGIN
    age := 44;
    CASE
        WHEN age > 100 OR age < 0 THEN
            result := '불가능';
        WHEN age <= 7 THEN
            result := '미취학아동';
        WHEN age <= 13 THEN
            result := '초등학생';
        WHEN age <= 16 THEN
            result := '중학생';
        WHEN age <= 19 THEN
            result := '고등학생';
        ELSE
            result := '성인';
    END CASE;
    DBMS_OUTPUT.PUT_LINE('나이는 ' || age || '살이고, ' || result || '입니다.');
END;


-- 7. WHILE문
DECLARE
    i NUMBER;
BEGIN
    i := 0;
    WHILE i < 5 LOOP
        DBMS_OUTPUT.PUT_LINE(i + 1 || '번째 Hello');
        i := i + 1;
    END LOOP;
END;


-- 연습문제. 1 ~ 100 사이 정수를 모두 더한 결과를 출력하시오. (정답은 5050)
DECLARE
    num   NUMBER(3);
    total NUMBER(4);
BEGIN
    num := 1;
    total := 0;
    WHILE num <= 100 LOOP
        total := total + num;
        num := num + 1;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('1 ~ 100 사이 모든 정수의 합은 ' || total || '입니다.');
END;


-- 8. FOR문
DECLARE
    i NUMBER;
BEGIN
    FOR i IN 0..4 LOOP
        DBMS_OUTPUT.PUT_LINE(i + 1 || '번째 Hello');
    END LOOP;
END;


-- 연습문제. 모든 사원들의 salary 합을 구하시오.
-- employee_id : 100 ~ 206
DECLARE
    v_id     employees.employee_id%TYPE;
    v_salary employees.salary%TYPE;
    total    NUMBER;
BEGIN
    total := 0;
    FOR v_id IN 100..206 LOOP
        SELECT salary INTO v_salary
          FROM employees
         WHERE employee_id = v_id;
        total := total + v_salary;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('전체 사원의 급여 총액은 ' || total || '원입니다.');
END;


-- 9. EXIT문
DECLARE
    i NUMBER;
BEGIN
    i := 0;
    WHILE TRUE LOOP  -- 무한루프
        IF i >= 5 THEN
            EXIT;    -- 무한루프 종료
        END IF;
        DBMS_OUTPUT.PUT_LINE(i + 1 || '번째 Hello');
        i := i + 1;
    END LOOP;
END;


-- 10. CONTINUE문
-- 1, 3, 5, 7, 9, ... 99 출력하기
DECLARE
    i NUMBER;
BEGIN
    i := 0;
    WHILE i < 100 LOOP
        i := i + 1;
        IF MOD(i, 2) = 0 THEN  -- 짝수는
            CONTINUE;          -- 올려보낸다.
        END IF;
        DBMS_OUTPUT.PUT_LINE(i || ', ');
    END LOOP;
END;


-- 11. 변수 선언 (레코드 타입)
-- 특정 테이블의 레코드 전체 타입이 자동 세팅
DECLARE

    -- 레코드 타입의 변수 v_row 선언
    v_row employees%ROWTYPE;

BEGIN
    SELECT * INTO v_row
      FROM employees
     WHERE employee_id = 100;
    DBMS_OUTPUT.PUT_LINE('사원번호: ' || v_row.employee_id);
    DBMS_OUTPUT.PUT_LINE('이름: ' || v_row.first_name);
END;


-- 연습문제. department_id가 50인 사원들의 정보를 이용하여 dept50 테이블을 생성하시오.
CREATE TABLE dept50
    AS (SELECT *
          FROM employees
         WHERE 1 = 2);

DECLARE
    v_row employees%ROWTYPE;
BEGIN
    FOR v_row IN (SELECT * FROM employees WHERE department_id = 50) LOOP
        INSERT INTO dept50 VALUES v_row;
    END LOOP;
END;


-- 12. 변수 선언 (테이블 타입)
-- 특정 칼럼의 데이터들은 배열처럼 여러 데이터를 저장하는 구조를 사용
DECLARE
    
    -- email 칼럼 값을 모두 저장할 수 있는 타입 type_email 선언
    TYPE type_email IS TABLE OF employees.email%TYPE INDEX BY BINARY_INTEGER;
    
    -- email을 저장할 변수(배열) emails
    emails type_email;
    
    -- 인덱스
    i BINARY_INTEGER;
    j BINARY_INTEGER;
    
    -- employees 테이블의 레코드 타입
    v_row employees%ROWTYPE;
    
BEGIN

    i := 0;

    FOR v_row IN (SELECT * FROM employees) LOOP
        emails(i) := v_row.email;
        i := i + 1;
    END LOOP;
    
    FOR j IN 0..106 LOOP
        DBMS_OUTPUT.PUT_LINE(emails(j));
    END LOOP;

END;


-- 13. 예외 처리
DECLARE
    
    v_email employees.email%TYPE;
    
BEGIN

    SELECT email
      INTO v_email
      FROM employees
     WHERE employee_id = 100;

    DBMS_OUTPUT.PUT_LINE('이메일: ' || v_email);

EXCEPTION
    
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('검색 결과가 없다.');

    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('검색 결과가 너무 많다.');

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('문제가 있다.');

END;

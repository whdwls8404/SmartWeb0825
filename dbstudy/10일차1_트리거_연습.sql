-- 트리거

-- 문제. employees 테이블에서 삭제된 데이터는 퇴사자 (retire) 테이블에 자동으로 저장되도록 트리거를 작성하시오.

-- 1. 퇴사자 (retire) 테이블 생성
CREATE TABLE RETIRE (
    RETIRE_ID NUMBER PRIMARY KEY,  -- 시퀀스를 활용할 순번
    EMPLOYEE_ID NUMBER(6),
    FIRST_NAME VARCHAR2(20 BYTE),
    LAST_NAME VARCHAR2(25 BYTE),
    EMAIL VARCHAR2(25 BYTE),
    HIRE_DATE DATE,
    RETIRE_DATE DATE  -- 퇴사일자
);

-- 2. 시퀀스 생성
CREATE SEQUENCE RETIRE_SEQ NOCACHE;

/*
            INSERT      UPDATE     DELETE
    :OLD    NULL        수정 전    삭제한 값
    :NEW    삽입한 값   수정 후    NULL
*/
/*
    삭제할 데이터  ->  100, Steven, King, SKING, 03/06/17
    
    삭제 후에는 (AFTER DELETE)
    :OLD 테이블에 삭제된 정보(100, Steven, King, SKING, 03/06/17)가 저장되어 있다.
*/

-- 3. 트리거 생성
CREATE OR REPLACE TRIGGER RETIRE_TRIG

    AFTER
    DELETE
    ON EMPLOYEES
    FOR EACH ROW
    
BEGIN

    INSERT INTO RETIRE(RETIRE_ID, EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, HIRE_DATE, RETIRE_DATE)
        VALUES (RETIRE_SEQ.NEXTVAL
              , :OLD.EMPLOYEE_ID
              , :OLD.FIRST_NAME
              , :OLD.LAST_NAME
              , :OLD.EMAIL
              , :OLD.HIRE_DATE
              , SYSDATE);

END RETIRE_TRIG;


-- 4. 트리거 동작 확인

DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;
SELECT * FROM RETIRE;

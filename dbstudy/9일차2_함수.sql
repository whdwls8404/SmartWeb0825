-- 함수
-- FUNCTION
-- 1. 반환 값이 있다. RETURN이 존재한다.
-- 2. 쿼리문에서 함수를 호출해서 사용한다.



-- FUNC1 함수 정의
CREATE OR REPLACE FUNCTION FUNC1(SCORE NUMBER)  -- 매개변수 SCORE
RETURN CHAR  -- 반환 타입
IS
    GRADE CHAR(1);
BEGIN
    IF SCORE >= 90 THEN
        GRADE := 'A';
    ELSIF SCORE >= 80 THEN
        GRADE := 'B';
    ELSIF SCORE >= 70 THEN
        GRADE := 'C';
    ELSIF SCORE >= 60 THEN
        GRADE := 'D';
    ELSE
        GRADE := 'F';
    END IF;
    RETURN GRADE;  -- 반환 처리
END FUNC1;


-- FUNC1 함수 확인
SELECT FUNC1(70) FROM DUAL;



-- FUNC2 함수 확인
CREATE OR REPLACE FUNCTION FUNC2(N1 NUMBER, N2 NUMBER)
RETURN NUMBER
IS
    TOTAL NUMBER;
    I     NUMBER;
BEGIN
    TOTAL := 0;
    FOR I IN N1..N2 LOOP
        TOTAL := TOTAL + I;
    END LOOP;
    RETURN TOTAL;
END FUNC2;


-- FUNC2 함수 확인
SELECT FUNC2(1, 100) FROM DUAL;  -- 5050 (1부터 100사이 모든 정수의 합)

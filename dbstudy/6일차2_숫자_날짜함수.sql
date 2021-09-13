-- 숫자 관련 함수

-- 1. 제곱
--    POWER(A, B) : A의 B제곱
SELECT POWER(2, 10)
  FROM DUAL;

-- 2. 나머지
--    MOD(A, B) : A를 B로 나눈 나머지
SELECT MOD(11, 4)
  FROM DUAL;

-- 3. 절대값
--    ABS(A) : A의 절대값
SELECT ABS(-5)
  FROM DUAL;

-- 4. 제곱근
--    SQRT(A) : A의 제곱근 (루트 A)
SELECT SQRT(25)
  FROM DUAL;

-- 5. 부호 판별
--    SIGN(5)  : 양수이면 1
--    SIGN(-5) : 음수이면 -1
--    SIGN(0)  : 0이면 0
SELECT SIGN(0)
  FROM DUAL;

-- 6. 올림
--    CEIL(A) : 실수 A의 정수 올림값
SELECT CEIL(1.1)
  FROM DUAL;

-- 7. 내림
--    FLOOR(A) : 실수 A의 정수 내림값
SELECT FLOOR(1.9)
  FROM DUAL;

-- 8. 절사
--    TRUNCATE TABLE : 테이블 삭제, 테이블의 구조는 남기고 행만 모두 삭제(잘라 버린다.)
--    TRUNC(A)     : 실수 A의 정수 절사값 (소수 아래 잘라 버린다.)
--    TRUNC(A, 1)  : 실수 A의 소수 1자리로 절사값
--    TRUNC(A, 2)  : 실수 A의 소수 2자리로 절사값
--    TRUNC(A, -1) : 실수 A의 일의 자리 절사값
--    TRUNC(A, -2) : 실수 A의 십의 자리 절사값
SELECT TRUNC(1.9), TRUNC(1.99, 1), TRUNC(1.999, 2), TRUNC(999.999, -1), TRUNC(999.999, -2)
  FROM DUAL;

-- 9. 반올림
--    ROUND(A)     : 실수 A의 정수 반올림값
--    ROUND(A, 1)  : 실수 A의 소수 1자리로 반올림값
--    ROUND(A, -1) : 실수 A의 일의 자리 반올림값
SELECT ROUND(1.4), ROUND(1.5), ROUND(1.44, 1), ROUND(1.55, 1), ROUND(344, -1), ROUND(555, -1)
  FROM DUAL;

-- 문제. 1.11을 소수 1자리 올림 처리하여 1.2를 구하시오.
SELECT CEIL(1.11 * 10) / 10     -- 10 : 10의 1제곱
  FROM DUAL;

-- 문제. 1.111을 소수 2자리 올림 처리하여 1.12를 구하시오.
SELECT CEIL(1.111 * 100) / 100  -- 100 : 10의 2제곱
  FROM DUAL;

-- 문제. 111을 일의 자리 올림 처리하여 120을 구하시오.
SELECT CEIL(111 * 0.1) / 0.1    -- 0.1 : 10의 -1제곱
  FROM DUAL;

-- 문제. 111을 십의 자리 올림 처리하여 200을 구하시오.
SELECT CEIL(111 * 0.01) / 0.01  -- 0.01 : 10의 -2제곱
  FROM DUAL;

-- 문제. A를 N자리 올림 처리하시오.
SELECT CEIL(A * POWER(10, N)) / POWER(10, N)
  FROM DUAL;



-- 날짜 관련 함수

-- 1. 현재 날짜
--    1) DATE 타입인 경우      : SYSDATE
--    2) TIMESTAMP 타입인 경우 : SYSTIMESTAMP
SELECT SYSDATE, SYSTIMESTAMP
  FROM DUAL;

-- 2. 년/월/일/시/분/초 추출
--    EXTRACT(단위 FROM 날짜)
SELECT EXTRACT(YEAR FROM hire_date)
     , EXTRACT(MONTH FROM hire_date)
     , EXTRACT(DAY FROM hire_date)
  FROM employee;

SELECT EXTRACT(HOUR FROM SYSTIMESTAMP)
     , EXTRACT(MINUTE FROM SYSTIMESTAMP)
     , EXTRACT(SECOND FROM SYSTIMESTAMP)
  FROM DUAL;

-- 3. 날짜 연산
--    1) '날짜 + 1'은 1일 후를 의미한다.
--    2) '날짜 - 1'은 1일 전을 의미한다.
--    3) '날짜 + 0.5'는 12시간 후를 의미한다.
--    4) '날짜 - 0.5'는 12시간 전을 의미한다.
SELECT SYSDATE + 1 AS 내일
     , SYSDATE - 1 AS 어제
     , SYSDATE + 0.5 AS "12시간후"
     , SYSDATE - 0.5 AS "12시간전"
     , SYSTIMESTAMP + 0.5 AS "12시간후"
     , TO_CHAR(SYSDATE + 0.5, 'YYYY/MM/DD HH:MI:SS') AS "12시간후"
     , TO_CHAR(SYSTIMESTAMP + 0.5, 'YYYY/MM/DD HH:MI:SS') AS "12시간후"
  FROM DUAL;

-- 4. N개월 후(전) 날짜 반환
--    ADD_MONTHS(날짜, N)
SELECT ADD_MONTHS(hire_date, 3) AS "3개월후"
     , ADD_MONTHS(hire_date, -3) AS "3개월전"
  FROM employee;

-- 5. 경과한 개월 수 반환
--    MONTHS_BETWEEN(날짜1, 날짜2) : 날짜1 - 날짜2
SELECT name AS 사원명
     , MONTHS_BETWEEN(SYSDATE, hire_date) AS 근무개월수
     , FLOOR(MONTHS_BETWEEN(SYSDATE, hire_date)) AS 근무개월수
  FROM employee;

-- BUILT-IN FUNCTION


-- 1. 대소문자 변환 함수
--    1) UPPER : 전부 대문자로 변환
--    2) LOWER : 전부 소문자로 변환
--    3) INITCAP : 첫 글자를 대문자로 변환, 나머지 글자를 소문자로 변환
SELECT UPPER(first_name) FROM employees;
SELECT LOWER(first_name) FROM employees;
SELECT INITCAP(email) FROM employees;


-- 2. 문자열의 일부 반환
--    SUBSTR('문자열', begin, count)
SELECT SUBSTR(first_name, 1, 3) FROM employees;  -- first_name의 1번째 글자부터 3글자 (시작이 1이다.)


-- 3. 문자열의 길이 반환
SELECT first_name, LENGTH(first_name) FROM employees;


-- 4. 특정 문자열의 위치 반환
--    INSTR('문자열', '찾을문자열')
SELECT first_name, INSTR(first_name, 'a') FROM employees;


-- 5. 좌우의 공백 제거 (중간 공백은 안 됨)
SELECT LTRIM('  ORACLE') FROM dual;
SELECT RTRIM('ORACLE  ') FROM dual;
SELECT TRIM('  ORACLE  ') FROM dual;


-- 6. 문자열 연결
--    1) || : 오라클에서는 OR이 아니라 연결(+) 연산자이다.
--    2) CONCAT('문자열1', '문자열2') : CONCATENATE, 인수는 오직 2개만 가능하다.
SELECT first_name || ' ' || last_name FROM employees;
SELECT CONCAT(first_name, CONCAT(' ', last_name)) FROM employees;


-- 7. 문자열 채우기
--    1) LPAD('문자열', 전체필드폭, '채울문자')
SELECT LPAD(first_name, 10, '*') FROM employees;  -- '*****Ellen'
SELECT LPAD(first_name, 10, ' ') FROM employees;  -- '     Ellen'
--    2) RPAD('문자열', 전체필드폭, '채울문자')
SELECT RPAD(first_name, 10, '*') FROM employees;  -- 'Ellen*****'
SELECT RPAD(first_name, 10, ' ') || last_name FROM employees;

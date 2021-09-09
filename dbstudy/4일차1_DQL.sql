-- DQL

-- 1. employees 테이블에서 first_name, last_name을 조회하시오.
SELECT first_name, last_name 
  FROM employees;

SELECT first_name
     , last_name 
  FROM employees;

SELECT 
       first_name
     , last_name 
  FROM 
       employees;


-- 2. employees 테이블에서 salary가 20000 이상인 사원들의 last_name, salary를 조회하시오.
SELECT last_name, salary
  FROM employees
 WHERE salary >= 20000;


-- 3. employees 테이블에서 employee_id가 150인 사원의 employee_id, first_name, last_name을 조회하시오.

-- 1) employee_id 칼럼의 타입이 NUMBER

SELECT employee_id, first_name, last_name
  FROM employees
 WHERE employee_id = 150;  -- 문제 없음.

SELECT employee_id, first_name, last_name
  FROM employees
 WHERE employee_id = '150';  -- WHERE employee_id = TO_NUMBER('150') 으로 처리된다. 문제 없음.


-- 2) employee_id 칼럼의 타입이 VARCHAR2, CHAR

SELECT employee_id, first_name, last_name
  FROM employees
 WHERE employee_id = 150;  -- WHERE TO_NUMBER(employee_id) = 150; 으로 처리된다. 문제가 발생함!!!
                           -- employee_id는 PK이다. PK로 사용되는 칼럼을 함수로 처리하면 속도가 떨어진다.

SELECT employee_id, first_name, last_name
  FROM employees
 WHERE employee_id = '150';  -- 문제 없음.


-- 4. employees 테이블에서 commission_pct가 없는 사원들의 employee_id, commission_pct를 조회하시오.
SELECT employee_id, commission_pct
  FROM employees
 WHERE commission_pct IS NULL;

SELECT employee_id, commission_pct
  FROM employees
 WHERE NVL(commission_pct, 0) = 0;


-- 5. employees 테이블에서 commission_pct가 있는 사원들의 employee_id, commission_pct를 조회하시오.
SELECT employee_id, commission_pct
  FROM employees
 WHERE commission_pct IS NOT NULL;

SELECT employee_id, commission_pct
  FROM employees
 WHERE NVL(commission_pct, 0) != 0;


-- 6. employees 테이블에서 모든 사원들의 employee_id와 커미션(salary * commission_pct)을 조회하시오.
--    커미션이 없는 경우 0으로 조회하시오.
SELECT 
       employee_id
     , salary * NVL(commission_pct, 0) AS commission
  FROM
       employees;


-- 7. employees 테이블에서 모든 사원들의 employee_id와 commission_pct를 10% 인상시킨 결과를 조회하시오.
--    commission_pct가 없는 경우에는 인상시키지 않도록 처리하시오.
SELECT
       employee_id
     , NVL(commission_pct * 1.1, 0) AS new_commission_pct
     , NVL2(commission_pct, commission_pct * 1.1, 0) AS new_commission_pct
  FROM
       employees;


-- 8. employees 테이블에서 모든 사원들을 salary 기준으로 오름차순 정렬하여 조회하시오.
SELECT *
  FROM employees
 ORDER BY salary ASC;  -- ASC : Ascending (오름차순)

SELECT *
  FROM employees
 ORDER BY salary;  -- ASC 정렬은 생략 가능.


-- 9. employees 테이블에서 모든 사원들을 salary 기준으로 내림차순 정렬하여 조회하시오.
SELECT *
  FROM employees
 ORDER BY salary DESC;  -- DESC : Descending (내림차순 정렬)


-- 10. employees 테이블에서 같은 department_id를 가진 사원끼리 모아서 조회하되, 높은 salary를 가진 사원을 먼저 조회하시오.
--     (부서별로 정렬하되, 급여가 높은 사원을 먼저 조회하시오.)
SELECT *
  FROM employees
 ORDER BY department_id ASC
        , salary DESC;  -- 1차 department_id 정렬 결과가 같은 레코드에만 2차 salary 정렬이 반영


-- SELECT * FROM employees ORDER BY employee_id, salary DESC;  employee_id는 ASC 생략으로 오름차순이다.


-- 11. employees 테이블에서 commission_pct가 없는 사원들을 높은 salary 순으로 조회하시오.
SELECT *
  FROM employees
 WHERE commission_pct IS NULL
 ORDER BY salary DESC;



-- 조인 preview

-- 1. 모든 사원들의 first_name, last_name, department_id, department_name 칼럼을 조회하시오.
--    1) employees 테이블   : first_name, last_name
--    2) departments 테이블 : department_name
--    3) 관계 : departments(department_id) - employees(department_id)
SELECT
       employees.first_name
     , employees.last_name
     , employees.department_id
     , departments.department_name
  FROM
       departments, employees
 WHERE
       departments.department_id = employees.department_id;  -- 조인 조건


-- 2. salary가 10000 이상인 사원들의 first_name, last_name, department_id, department_name 칼럼을 조회하시오.
SELECT emp.first_name
     , emp.last_name
     , emp.department_id
     , dept.department_name
  FROM departments dept, employees emp
 WHERE dept.department_id = emp.department_id
   AND emp.salary >= 10000;

SELECT emp.first_name
     , emp.last_name
     , emp.department_id
     , dept.department_name
  FROM departments dept, employees emp
 WHERE 1 = 1
   AND dept.department_id = emp.department_id
   AND emp.salary >= 10000;



-- 서브쿼리 preview
-- 하위쿼리 : 쿼리 내부에 포함된 쿼리(SELECT 안에 SELECT)

-- 1. 평균 급여 이상 받는 사원들의 first_name, last_name, salary를 조회하시오.

SELECT first_name, last_name, salary
  FROM employees
 WHERE salary >= (SELECT AVG(salary) FROM employees);

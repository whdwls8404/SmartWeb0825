-- 1. 내부조인
--SELECT 조회할 칼럼
--  FROM 테이블1, 테이블2
-- WHERE 테이블1.칼럼 = 테이블2.칼럼  :  테이블1.PK = 테이블2.FK
--   AND 일반조건;

--SELECT 조회할 칼럼
--  FROM 테이블1 INNER JOIN 테이블2
--    ON 테이블1.칼럼 = 테이블2.칼럼  :  테이블1.PK = 테이블2.FK
-- WHERE 일반조건;


-- 1. 부서 위치(location_id)가 1700인 사원들의 employee_id, first_name, department_id를 조회하시오.

SELECT e.employee_id, e.first_name, d.department_id
  FROM departments d INNER JOIN employees e
    ON d.department_id = e.department_id
 WHERE d.location_id = 1700;

SELECT e.employee_id, e.first_name, d.department_id
  FROM departments d, employees e
 WHERE d.department_id = e.department_id
   AND d.location_id = 1700;


-- 2. 부서명이 'Executive'인 부서에 근무하는 모든 사원들의 employee_id, last_name, department_name을 조회하시오.
SELECT e.employee_id, e.last_name, d.department_name
  FROM departments d, employees e
 WHERE d.department_id = e.department_id
   AND d.department_name = 'Executive';

SELECT e.employee_id, e.last_name, d.department_name
  FROM departments d INNER JOIN employees e
    ON d.department_id = e.department_id
 WHERE d.department_name = 'Executive';


-- 3. job_id가 변하지 않은 사원들의 employee_id, last_name, job_id를 조회하시오.
--    현재 job_id(employees)와 과거 job_id(job_history)가 일치하는 사원을 조회하시오.
SELECT e.employee_id, e.last_name, jh.job_id
  FROM employees e, job_history jh
 WHERE e.employee_id = jh.employee_id
   AND e.job_id = jh.job_id;

SELECT e.employee_id, e.last_name, jh.job_id
  FROM employees e INNER JOIN job_history jh
    ON e.employee_id = jh.employee_id
 WHERE e.job_id = jh.job_id;


-- 4. 각 부서별 사원수와 평균연봉을 department_name과 함께 조회하시오.
--    사원수의 오름차순 정렬하시오.
SELECT d.department_name, COUNT(*) AS 사원수, AVG(e.salary) AS 평균연봉
  FROM departments d, employees e
 WHERE d.department_id = e.department_id
 GROUP BY d.department_name
 ORDER BY 사원수;

SELECT d.department_name, COUNT(*) AS 사원수, AVG(e.salary) AS 평균연봉
  FROM departments d INNER JOIN employees e
    ON d.department_id = e.department_id
 GROUP BY d.department_name
 ORDER BY 사원수;


-- 5. city가 'S'로 시작하는 지역에 근무하는 사원들의 employee_id, first_name, department_name, city를 조회하시오.
/*
    locations           departments         employees
    location_id(PK)  -  location_id(FK)
                        department_id(PK) - department_id(FK)
*/
SELECT e.employee_id, e.first_name, d.department_name, l.city
  FROM locations l, departments d, employees e
 WHERE l.location_id = d.location_id
   AND d.department_id = e.department_id
   AND l.city LIKE 'S%';

SELECT e.employee_id, e.first_name, d.department_name, l.city
  FROM locations l INNER JOIN departments d
    ON l.location_id = d.location_id INNER JOIN employees e
    ON d.department_id = e.department_id
 WHERE l.city LIKE 'S%';
    

-- 6. 모든 사원들의 employee_id, first_name, department_name, city, country_name을 조회하시오.
SELECT e.employee_id, e.first_name, d.department_name, l.city, c.country_name
  FROM countries c, locations l, departments d, employees e
 WHERE c.country_id = l.country_id
   AND l.location_id = d.location_id
   AND d.department_id = e.department_id;

SELECT e.employee_id, e.first_name, d.department_name, l.city, c.country_name
  FROM countries c INNER JOIN locations l
    ON c.country_id = l.country_id INNER JOIN departments d
    ON l.location_id = d.location_id INNER JOIN employees e
    ON d.department_id = e.department_id;


-- 7. manager보다 먼저 입사한 사원들의 employee_id, first_name, hire_date과 manager의 hire_date를 조회하시오.
--    사원의 hire_date가 manager의 hire_date보다 작은 사원을 조회하시오.
-- 사원 테이블    : employees e
-- manager 테이블 : employees m
SELECT e.employee_id AS 사원번호
     , e.first_name AS 사원명
     , e.hire_date AS 입사일
     , m.hire_date AS 상사입사일
  FROM employees m, employees e
 WHERE m.employee_id = e.manager_id  -- manager의 employee_id = 사원의 manager_id
   AND TO_DATE(m.hire_date) > TO_DATE(e.hire_date);

SELECT e.employee_id AS 사원번호
     , e.first_name AS 사원명
     , e.hire_date AS 입사일
     , m.hire_date AS 상사입사일
  FROM employees m INNER JOIN employees e
    ON m.employee_id = e.manager_id  -- manager의 employee_id = 사원의 manager_id
 WHERE TO_DATE(m.hire_date) > TO_DATE(e.hire_date);


-- 8. 같은 부서의 사원들 중에서 나보다 늦게 입사하였으나 연봉을 더 많이 받는 사원이 있는 사원들의
--    department_id, first_name, salary, hire_date와 높은 연봉을 받는 사원의 first_name, salary, hire_date를 조회하시오.
-- 나의 정보 : employees me
-- 너의 정보 : employees you
-- 조인 조건 : 같은 부서인가?
SELECT me.department_id AS 부서명
     , me.first_name AS 내이름
     , me.salary AS 내급여
     , me.hire_date AS 내입사일
     , you.first_name AS 나보다연봉많은사원명
     , you.salary AS 그사원의급여
     , you.hire_date AS 그사원의입사일
  FROM employees me, employees you
 WHERE me.department_id = you.department_id
   AND TO_DATE(me.hire_date) < TO_DATE(you.hire_date)
   AND me.salary < you.salary;



-- 외부 조인
-- 한 테이블의 정보는 일치하면 조회, 다른 테이블의 정보는 일치하지 않아도 모두 조회하는 경우에 사용
-- 모든 정보를 조회할 테이블이 왼쪽에 있으면 왼쪽 조인, 오른쪽에 있으면 오른쪽 조인

-- 9. 모든 사원들의 employee_id, first_name, department_name을 조회하시오.
--    employee_id순으로 오름차순 정렬하시오.
--    모든 사원 : 부서가 없는 사원도 조회하시오.
SELECT e.employee_id, e.first_name, NVL(d.department_name, '부서없음')
  FROM departments d, employees e  -- 왼쪽 department, 오른쪽 employees
 WHERE d.department_id(+) = e.department_id  -- employees 테이블의 모든 정보는 조회되도록 오른쪽 조인으로 설정
 ORDER BY e.employee_id;

SELECT e.employee_id, e.first_name, NVL(d.department_name, '부서없음')
  FROM departments d RIGHT JOIN employees e  -- 왼쪽 department, 오른쪽 employees
    ON d.department_id = e.department_id  -- employees 테이블의 모든 정보는 조회되도록 오른쪽 조인으로 설정
 ORDER BY e.employee_id;


-- 10. 부서별 근무하는 사원수를 조회하시오.
--     단, 근무하는 사원이 없으면 0으로 조회하시오.
SELECT d.department_name, COUNT(e.employee_id)
  FROM departments d, employees e
 WHERE d.department_id = e.department_id(+)  -- departments 테이블의 모든 정보를 조회하도록 왼쪽 조인으로 설정
 GROUP BY d.department_name;

SELECT d.department_name, COUNT(e.employee_id)
  FROM departments d LEFT JOIN employees e
    ON d.department_id = e.department_id  -- departments 테이블의 모든 정보를 조회하도록 왼쪽 조인으로 설정
 GROUP BY d.department_name;

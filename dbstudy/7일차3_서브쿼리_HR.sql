-- 서브쿼리


-- 1. department_id가 20인 사원중에서 전체 평균 연봉(salary) 이상을 받는 사원의
--    employee_id, first_name, department_id, salary를 조회하시오.

SELECT employee_id, first_name, department_id, salary
  FROM employees
 WHERE department_id = 20
   AND salary >= (SELECT AVG(salary)
                    FROM employees);

-- 2. job_id가 'IT_PROG'인 사원의 최대 연봉(salary)보다 더 많은 연봉을 받는 사원의
--    employee_id, first_name, job_id, salary를 조회하시오.

SELECT employee_id, first_name, job_id, salary
  FROM employees
 WHERE salary > (SELECT MAX(salary)
                   FROM employees
                  WHERE job_id = 'IT_PROG');


-- 3. employee_id가 115인 사원과 같은 job_id, department_id를 가진 사원의
--    employee_id, first_name, job_id, department_id를 조회하시오.

SELECT employee_id, first_name, job_id, department_id
  FROM employees
 WHERE (job_id, department_id) = (SELECT job_id, department_id
                                  FROM employees
                                 WHERE employee_id = 115);


-- 4. location_id가 1000~1900인 국가들의 country_id, country_name을 조회하시오.
SELECT country_id, country_name
  FROM countries c
 WHERE country_id IN (SELECT country_id
                        FROM locations
                       WHERE location_id IN (1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900));

SELECT country_id, country_name
  FROM countries c
 WHERE country_id IN (SELECT country_id
                        FROM locations
                       WHERE location_id BETWEEN 1000 AND 1900);


-- 5. manager가 아닌 사원들의 employee_id, first_name을 조회하시오.
--    서브쿼리 결과는 null을 포함하면 안 된다.

-- manager
SELECT employee_id, first_name
  FROM employees
 WHERE employee_id IN (SELECT DISTINCT manager_id
                         FROM employees
                        WHERE manager_id IS NOT NULL);

-- manager 아님
SELECT employee_id, first_name
  FROM employees
 WHERE employee_id NOT IN (SELECT DISTINCT manager_id
                             FROM employees
                            WHERE manager_id IS NOT NULL);


-- 6. city가 'Southlake'인 사원들의 employee_id, first_name를 조회하시오.

SELECT employee_id, first_name
  FROM employees
 WHERE department_id IN (SELECT department_id
                           FROM departments
                          WHERE location_id IN (SELECT location_id
                                                  FROM locations
                                                 WHERE city = 'Southlake'));


-- 7. 가장 많은 사원이 근무 중인 부서의 department_id, 근무 인원 수를 조회하시오.
SELECT department_id, COUNT(*) AS 사원수
  FROM employees
 GROUP BY department_id
HAVING COUNT(*) = (SELECT MAX(COUNT(*))
                     FROM employees
                    GROUP BY department_id);


-- 8. department_name의 오름차순 정렬 기준으로 사원의
--    employee_id, first_name, department_id를 조회하시오.
SELECT e.employee_id, e.first_name, e.department_id
  FROM employees e
 ORDER BY (SELECT d.department_name
             FROM departments d
            WHERE d.department_id = e.department_id);


-- 9. 최대 연봉 사원의 employee_id, first_name, salary를 조회하시오.
--    ROWNUM 활용
--    1) 높은 연봉이 가장 위로 오도록 정렬한다. (연봉 내림차순 정렬)
--    2) 정렬 결과에서 ROWNUM이 1인 데이터를 조회한다.

SELECT a.employee_id, a.first_name, a.salary
  FROM (SELECT employee_id, first_name, salary
          FROM employees
         ORDER BY salary DESC) a
 WHERE ROWNUM = 1;


-- 10. 연봉 TOP 11 ~ 20 사원의 employee_id, first_name, salary를 조회하시오.
--    ROWNUM 활용
--    1) 높은 연봉이 가장 위로 오도록 정렬한다. (연봉 내림차순 정렬)
--    2) 정렬 결과에 ROWNUM 칼럼을 추가한다. 반드시 ROWNUM 칼럼에 별명을 부여한다.
--    3) 부여된 ROWNUM의 별명으로 11 ~ 20 사이를 조회한다.
SELECT b.employee_id, b.first_name, b.salary
  FROM (SELECT ROWNUM AS rn, a.employee_id, a.first_name, a.salary
          FROM (SELECT employee_id, first_name, salary
                  FROM employees
                 ORDER BY salary DESC) a) b
 WHERE b.rn BETWEEN 11 AND 20;


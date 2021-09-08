ALTER TABLE employee
    ADD CONSTRAINT employee_department_fk FOREIGN KEY ( depart )
        REFERENCES department ( dept_no )
            ON DELETE CASCADE;
/* table */
DROP TABLE emp;
CREATE TABLE emp
(
	num NUMBER,
	name VARCHAR2(20),
	hire DATE,
	PRIMARY KEY(num)
);

/* sequence */
DROP SEQUENCE emp_seq;
CREATE SEQUENCE emp_seq INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

/* insert */
INSERT INTO emp VALUES (emp_seq.nextval, '이정재', SYSDATE);
COMMIT










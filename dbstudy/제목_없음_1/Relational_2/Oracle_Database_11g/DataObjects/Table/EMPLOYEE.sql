CREATE TABLE employee (
    emp_no     NUMBER NOT NULL,
    name       VARCHAR2(20 BYTE) NOT NULL,
    depart     NUMBER,
    position   VARCHAR2(20 BYTE),
    gender     CHAR(2 BYTE),
    hire_date  DATE,
    salary     NUMBER
);
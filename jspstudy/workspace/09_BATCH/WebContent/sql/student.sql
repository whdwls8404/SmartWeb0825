DROP TABLE student;
CREATE TABLE student
(
	sno		VARCHAR2(5)	PRIMARY KEY,
	name	VARCHAR2(20),
	kor		NUMBER(3)	CHECK(kor BETWEEN 0 AND 100),
	eng		NUMBER(3)	CHECK(eng >= 0 AND eng <= 100),
	mat		NUMBER(3)	CHECK(mat BETWEEN 0 AND 100),
	ave		NUMBER(5,2),
	grade	CHAR(1)
);
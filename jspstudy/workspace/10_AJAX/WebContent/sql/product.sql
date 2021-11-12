DROP TABLE product;
CREATE TABLE product
(
	pno		NUMBER	PRIMARY KEY,
	name	VARCHAR2(20),
	price	NUMBER,
	made	DATE
);

DROP SEQUENCE product_seq;
CREATE SEQUENCE product_seq NOCACHE;
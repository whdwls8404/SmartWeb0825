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

INSERT INTO product VALUES (product_seq.nextval, '맛동산', 2500, SYSDATE);
COMMIT





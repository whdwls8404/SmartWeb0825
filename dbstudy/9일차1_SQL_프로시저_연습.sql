-- 외래키를 가진 자식 테이블 먼저 삭제
DROP TABLE ORDERS;

-- 외래키가 없는 부모 테이블 나중에 삭제
DROP TABLE CUSTOMERS;
DROP TABLE BOOKS;


-- BOOKS 테이블
CREATE TABLE BOOKS (
    BOOK_ID   NUMBER(11),
    BOOK_NAME VARCHAR2(100 BYTE) NOT NULL,
    PUBLISHER VARCHAR2(50 BYTE),
    PRICE     NUMBER(6)
);

-- CUSTOMERS 테이블
CREATE TABLE CUSTOMERS (
    CUSTOMER_ID   NUMBER(11),
    CUSTOMER_NAME VARCHAR2(20 BYTE) NOT NULL,
    PHONE         VARCHAR2(15 BYTE)
);

-- ORDERS 테이블
CREATE TABLE ORDERS (
    ORDER_ID    NUMBER(11),
    CUSTOMER_ID NUMBER(11) NOT NULL,
    BOOK_ID     NUMBER(11),
    SALES_PRICE NUMBER(6),
    ORDER_DATE  DATE
);


-- 기본키
ALTER TABLE BOOKS ADD CONSTRAINT BOOKS_PK PRIMARY KEY(BOOK_ID);
ALTER TABLE CUSTOMERS ADD CONSTRAINT CUSTOMERS_PK PRIMARY KEY(CUSTOMER_ID);
ALTER TABLE ORDERS ADD CONSTRAINT ORDERS_PK PRIMARY KEY(ORDER_ID);

-- 외래키
ALTER TABLE ORDERS ADD CONSTRAINT ORDERS_CUSTOMERS_FK FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID);
ALTER TABLE ORDERS ADD CONSTRAINT ORDERS_BOOKS_FK FOREIGN KEY(BOOK_ID) REFERENCES BOOKS(BOOK_ID);


-- 시퀀스
DROP SEQUENCE BOOKS_SEQ;
DROP SEQUENCE CUSTOMERS_SEQ;
DROP SEQUENCE ORDERS_SEQ;

CREATE SEQUENCE BOOKS_SEQ     START WITH 1000     INCREMENT BY 1 NOMAXVALUE NOMINVALUE NOCYCLE NOCACHE;
CREATE SEQUENCE CUSTOMERS_SEQ START WITH 10000000 INCREMENT BY 1 NOMAXVALUE NOMINVALUE NOCYCLE NOCACHE;
CREATE SEQUENCE ORDERS_SEQ    START WITH 100000   INCREMENT BY 1 NOMAXVALUE NOMINVALUE NOCYCLE NOCACHE;


-- INSERT
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '축구의역사', '굿스포츠', 7000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '골때리는그녀', '나이스스포츠', 10000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '축구의정석', '대한출판사', 15000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '피겨교본', '굿스포츠', 6000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '피겨의추억', '굿스포츠', 20000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '야구의역사', '대한출판사', 20000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '야구잘아는남자', '이상미디어', 13000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '배구를부탁해', '굿스포츠', 25000);
INSERT INTO BOOKS(BOOK_ID, BOOK_NAME, PUBLISHER, PRICE) VALUES(BOOKS_SEQ.NEXTVAL, '강스파이크', '이상미디어', 8000);


INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PHONE) VALUES(CUSTOMERS_SEQ.NEXTVAL, '손흥민', '010-1111-1111');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PHONE) VALUES(CUSTOMERS_SEQ.NEXTVAL, '김연아', '010-2222-2222');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PHONE) VALUES(CUSTOMERS_SEQ.NEXTVAL, '추신수', '010-3333-3333');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PHONE) VALUES(CUSTOMERS_SEQ.NEXTVAL, '김연경', '010-4444-4444');
INSERT INTO CUSTOMERS(CUSTOMER_ID, CUSTOMER_NAME, PHONE) VALUES(CUSTOMERS_SEQ.NEXTVAL, '서장훈', '010-5555-5555');


INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000000, 1000, 6000, '21/09/04');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000000, 1001, 9000, '21/09/05');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000000, 1002, 13000, '21/09/05');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000001, 1003, 5000, '21/09/07');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000001, 1004, 18000, '21/09/09');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000002, 1005, 18000, '21/09/10');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000002, 1006, 12000, '21/09/13');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000003, 1007, 20000, '21/09/15');
INSERT INTO ORDERS(ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, ORDER_DATE) VALUES (ORDERS_SEQ.NEXTVAL, 10000003, 1008, 7000, '21/09/16');

-- 커밋
COMMIT;


-- SELECT
-- 1. '21/09/04'~'21/09/10' 사이에 주문한 도서들의
--    order_id, customer_name, book_name, sales_price, order_date를 조회하시오.
SELECT o.order_id, c.customer_name, b.book_name, o.sales_price, o.order_date
  FROM customers c, orders o, books b
 WHERE c.customer_id = o.customer_id
   AND o.book_id = b.book_id
   AND o.order_date BETWEEN TO_DATE('21/09/04', 'YY/MM/DD') AND TO_DATE('21/09/10', 'YY/MM/DD');


-- 2. '손흥민'의 총 구매액을 조회하시오.
-- 1) 조인
SELECT c.customer_name, SUM(o.sales_price) AS 총구매액
  FROM customers c, orders o
 WHERE c.customer_id = o.customer_id
   AND c.customer_name = '손흥민'
 GROUP BY c.customer_id, c.customer_name;

-- 2) 서브쿼리 (인라인 뷰 : FROM절의 서브쿼리)
SELECT a.customer_name, SUM(a.sales_price) AS 총구매액
  FROM (SELECT c.customer_id, c.customer_name, o.sales_price
          FROM customers c, orders o
         WHERE c.customer_id = o.customer_id
           AND c.customer_name = '손흥민') a
 GROUP BY a.customer_id, a.customer_name;

-- 3) 서브쿼리 (스칼라 서브쿼리 : SELECT절의 서브쿼리)
SELECT c.customer_name
     , (SELECT SUM(o.sales_price)
          FROM orders o
         WHERE c.customer_id = o.customer_id) AS 총구매액
  FROM customers c
 WHERE c.customer_name = '손흥민';


-- 3. '김연아'가 구매한 도서의 개수를 조회하시오.
SELECT c.customer_name, COUNT(o.order_id) AS 구매도서수
  FROM customers c, orders o
 WHERE c.customer_id = o.customer_id
   AND c.customer_name = '김연아'
 GROUP BY c.customer_id, c.customer_name;


-- 4. '추신수'가 구매한 도서들의 출판사수를 조회하시오.
SELECT c.customer_name, COUNT(DISTINCT b.publisher)
  FROM customers c, orders o, books b
 WHERE c.customer_id = o.customer_id
   AND o.book_id = b.book_id
   AND c.customer_name = '추신수'
 GROUP BY c.customer_id, c.customer_name;


-- 5. 고객별 총 구매액을 조회하시오.
--    customer_id, customer_name, 총 구매액을 조회하시오.
--    구매한 이력이 있는 고객만 조회하시오. (내부조인)
SELECT c.customer_id, c.customer_name, SUM(o.sales_price) AS 총구매액
  FROM customers c, orders o
 WHERE c.customer_id = o.customer_id
 GROUP BY c.customer_id, c.customer_name;
 
 
-- 6. 주문한 이력이 없는 고객의 customer_name을 조회하시오.
SELECT customer_name
  FROM customers
 WHERE customer_id NOT IN(SELECT customer_id
                            FROM orders);


-- 7. 고객별 총 구매횟수를 조회하시오.
--    customer_id, customer_name, 총 구매횟수를 조회하시오.
--    구매한 적이 없으면 0으로 조회하시오. (모든 고객은 포함하는 외부 조인)
SELECT c.customer_id, c.customer_name, COUNT(o.order_id) AS 구매횟수
  FROM customers c, orders o
 WHERE c.customer_id = o.customer_id(+)
 GROUP BY c.customer_id, c.customer_name;

SELECT c.customer_id, c.customer_name, COUNT(o.order_id) AS 구매횟수
  FROM customers c LEFT JOIN orders o
    ON c.customer_id = o.customer_id
 GROUP BY c.customer_id, c.customer_name;


-- ALTER

-- 1. BOOKS 테이블에 재고(STOCK) 칼럼을 추가하고 기존의 모든 책의 재고를 10개로 세팅하시오.
ALTER TABLE BOOKS ADD STOCK NUMBER;
UPDATE BOOKS SET STOCK = 10;

-- 2. CUSTOMERS 테이블에 포인트(POINT) 칼럼을 추가하고 기존의 모든 고객의 포인트를 1000포인트로 세팅하시오.
ALTER TABLE CUSTOMERS ADD POINT NUMBER;
UPDATE CUSTOMERS SET POINT = 1000;

-- 3. ORDERS 테이블에 구매수량(AMOUNT) 칼럼을 추가하고 기존의 모든 구매 내역의 구매수량을 1로 세팅하시오.
ALTER TABLE ORDERS ADD AMOUNT NUMBER;
UPDATE ORDERS SET AMOUNT = 1;



-- 프로시저
-- 실행할 쿼리문이 여러 개인 경우 작성

-- 주문 프로시저
-- 1. ORDER_PROC(10000000, 1000, 2) : CUSTOMER_ID = 10000000, BOOK_ID = 1000, AMOUNT = 2
-- 2. ORDERS 테이블에 해당 정보를 INSERT 한다. 주문일자는 현재 날짜로 한다.
-- 3. CUSTOMERS 테이블에 POINT를 UPDATE 한다. (총주문액(SALES_PRICE * AMOUNT)의 10% 적립)
-- 4. BOOKS 테이블의 STOCK를 UPDATE 한다. (주문수량만큼 감소)
-- 5. 모두 성공하면 COMMIT, 중간에 실패하면 ROLLBACK한다.

CREATE OR REPLACE PROCEDURE ORDER_PROC(V_CUSTOMER_ID IN NUMBER, V_BOOK_ID IN NUMBER, V_AMOUNT IN NUMBER)
IS

BEGIN

    INSERT INTO ORDERS (ORDER_ID, CUSTOMER_ID, BOOK_ID, SALES_PRICE, AMOUNT, ORDER_DATE)
    VALUES (ORDERS_SEQ.NEXTVAL
          , V_CUSTOMER_ID
          , V_BOOK_ID
          , (SELECT TRUNC(PRICE * 0.9) FROM BOOKS WHERE BOOK_ID = V_BOOK_ID)
          , V_AMOUNT
          , SYSDATE);

    UPDATE CUSTOMERS 
       SET POINT = POINT + (SELECT TRUNC(SALES_PRICE * AMOUNT * 0.1) 
                              FROM orders 
                             WHERE ORDER_ID = (SELECT MAX(ORDER_ID)
                                                 FROM ORDERS))
     WHERE CUSTOMER_ID = V_CUSTOMER_ID;

    UPDATE BOOKS
       SET STOCK = STOCK - V_AMOUNT

     WHERE BOOK_ID = V_BOOK_ID;

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('에러메시지: ' || SQLERRM);
        ROLLBACK;
    
END ORDER_PROC;


-- 프로시저 실행
EXECUTE ORDER_PROC(10000000, 1000, 2);

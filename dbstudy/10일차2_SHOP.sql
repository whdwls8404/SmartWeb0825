-- 생성자 Oracle SQL Developer Data Modeler 20.4.0.374.0801
--   위치:        2021-09-17 14:31:19 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g


-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE


-- DROP SEQUENCE
DROP SEQUENCE REVIEW_SEQ;
DROP SEQUENCE ORDERS_SEQ;
DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE PRODUCT_SEQ;
DROP SEQUENCE SELLER_SEQ;
DROP SEQUENCE DELIVERY_SEQ;

-- CREATE SEQUENCE
CREATE SEQUENCE REVIEW_SEQ NOCACHE;
CREATE SEQUENCE ORDERS_SEQ NOCACHE;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;
CREATE SEQUENCE PRODUCT_SEQ NOCACHE;
CREATE SEQUENCE SELLER_SEQ NOCACHE;
CREATE SEQUENCE DELIVERY_SEQ NOCACHE;


-- DROP TABLE
DROP TABLE MEMBER_LOG;
DROP TABLE MEMBER_ADDRESS;
DROP TABLE MEMBER_COUPON;
DROP TABLE REVIEW;
DROP TABLE ORDERS;
DROP TABLE MEMBER;
DROP TABLE PRODUCT_IMG;
DROP TABLE PRODUCT;
DROP TABLE SELLER;
DROP TABLE DELIVERY;


-- CREATE TABLE
CREATE TABLE delivery (
    delivery_no     NUMBER NOT NULL,
    delivery_name   VARCHAR2(50 BYTE),
    delivery_price  NUMBER
);

ALTER TABLE delivery ADD CONSTRAINT delivery_pk PRIMARY KEY ( delivery_no );

CREATE TABLE member (
    member_no      NUMBER NOT NULL,
    id             VARCHAR2(32 BYTE) NOT NULL,
    password       VARCHAR2(32 BYTE) NOT NULL,
    name           VARCHAR2(50 BYTE),
    nickname       VARCHAR2(50 BYTE),
    gender         CHAR(1 BYTE),
    tel            VARCHAR2(15 BYTE),
    email          VARCHAR2(100 BYTE),
    grade          VARCHAR2(6 BYTE),
    point          NUMBER,
    birthday       DATE,
    registed_date  DATE
);

ALTER TABLE member ADD CONSTRAINT member_pk PRIMARY KEY ( member_no );

ALTER TABLE member ADD CONSTRAINT member_id_un UNIQUE ( id );

ALTER TABLE member ADD CONSTRAINT member_nick_un UNIQUE ( nickname );

CREATE TABLE member_address (
    id          VARCHAR2(32 BYTE) NOT NULL,
    address_no  NUMBER,
    address     VARCHAR2(100 BYTE)
);

CREATE TABLE member_coupon (
    id             VARCHAR2(32 BYTE) NOT NULL,
    kind           NUMBER,
    discount_rate  NUMBER(2, 2),
    expiry_date    DATE,
    used           NUMBER(1)
);

CREATE TABLE member_log (
    id          VARCHAR2(32 BYTE) NOT NULL,
    login_date  DATE
);

CREATE TABLE orders (
    order_no          NUMBER NOT NULL,
    id                VARCHAR2(32 BYTE) NOT NULL,
    product_no        NUMBER NOT NULL,
    order_date        DATE,
    amount            NUMBER,
    delivery_address  VARCHAR2(100 BYTE),
    delivery_state    NUMBER(1),
    pay_method        NUMBER,
    delivery_send_no  NUMBER,
    finish            NUMBER
);

ALTER TABLE orders ADD CONSTRAINT orders_pk PRIMARY KEY ( order_no );

CREATE TABLE product (
    product_no    NUMBER NOT NULL,
    product_name  VARCHAR2(100 BYTE),
    category      VARCHAR2(15 BYTE),
    stock         NUMBER,
    price         NUMBER,
    seller_id     VARCHAR2(32 BYTE) NOT NULL,
    delivery_no   NUMBER NOT NULL
);

ALTER TABLE product ADD CONSTRAINT product_pk PRIMARY KEY ( product_no );

CREATE TABLE product_img (
    product_no  NUMBER NOT NULL,
    kind        NUMBER(1),
    url         VARCHAR2(300 BYTE)
);

CREATE TABLE review (
    review_no     NUMBER NOT NULL,
    title         VARCHAR2(300 BYTE) NOT NULL,
    content       VARCHAR2(4000 BYTE),
    star          NUMBER(1),
    id            VARCHAR2(32 BYTE) NOT NULL,
    product_no    NUMBER NOT NULL,
    hit           NUMBER,
    created_date  DATE,
    state         NUMBER(1)
);

ALTER TABLE review ADD CONSTRAINT review_pk PRIMARY KEY ( review_no );

CREATE TABLE seller (
    seller_no    NUMBER NOT NULL,
    seller_id    VARCHAR2(32 BYTE) NOT NULL,
    password     VARCHAR2(32 BYTE) NOT NULL,
    brand        VARCHAR2(50 BYTE),
    tel          VARCHAR2(15 BYTE),
    address      VARCHAR2(100 BYTE),
    business_no  CHAR(12 BYTE)
);

ALTER TABLE seller ADD CONSTRAINT seller_pk PRIMARY KEY ( seller_no );

ALTER TABLE seller ADD CONSTRAINT seller_id_un UNIQUE ( seller_id );

ALTER TABLE member_address
    ADD CONSTRAINT member_address_member_fk FOREIGN KEY ( id )
        REFERENCES member ( id )
            ON DELETE CASCADE;

ALTER TABLE member_coupon
    ADD CONSTRAINT member_coupon_member_fk FOREIGN KEY ( id )
        REFERENCES member ( id )
            ON DELETE CASCADE;

ALTER TABLE member_log
    ADD CONSTRAINT member_log_member_fk FOREIGN KEY ( id )
        REFERENCES member ( id )
            ON DELETE CASCADE;

ALTER TABLE orders
    ADD CONSTRAINT orders_member_fk FOREIGN KEY ( id )
        REFERENCES member ( id )
            ON DELETE CASCADE;

ALTER TABLE orders
    ADD CONSTRAINT orders_product_fk FOREIGN KEY ( product_no )
        REFERENCES product ( product_no )
            ON DELETE CASCADE;

ALTER TABLE product
    ADD CONSTRAINT product_delivery_fk FOREIGN KEY ( delivery_no )
        REFERENCES delivery ( delivery_no )
            ON DELETE CASCADE;

ALTER TABLE product_img
    ADD CONSTRAINT product_img_product_fk FOREIGN KEY ( product_no )
        REFERENCES product ( product_no )
            ON DELETE CASCADE;

ALTER TABLE product
    ADD CONSTRAINT product_seller_fk FOREIGN KEY ( seller_id )
        REFERENCES seller ( seller_id )
            ON DELETE CASCADE;

ALTER TABLE review
    ADD CONSTRAINT review_member_fk FOREIGN KEY ( id )
        REFERENCES member ( id )
            ON DELETE CASCADE;

ALTER TABLE review
    ADD CONSTRAINT review_product_fk FOREIGN KEY ( product_no )
        REFERENCES product ( product_no )
            ON DELETE CASCADE;


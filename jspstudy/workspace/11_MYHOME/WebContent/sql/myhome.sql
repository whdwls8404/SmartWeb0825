/*
	댓글형 게시판
	1. 공지사항 : notice
	2. 댓글 : reply
*/
DROP TABLE REPLY;
DROP TABLE NOTICE;

CREATE TABLE NOTICE
(
	/* 게시글번호 */	NNO				NUMBER,
	/* 작성자 */		WRITER			VARCHAR2(50),
	/* 제목 */			TITLE			VARCHAR2(2000),
	/* 내용 */			CONTENT			VARCHAR2(4000),
	/* 조회수 */		HIT				NUMBER,
	/* 작성자IP */		IP				VARCHAR2(32),
	/* 작성일 */		NDATE			DATE,
	/* 최종수정일 */	NLASTMODIFIED	DATE
);
CREATE TABLE REPLY
(
	/* 댓글번호 */		RNO		NUMBER,
	/* 작성자 */		WRITER	VARCHAR2(50),
	/* 댓글내용 */		CONTENT	VARCHAR2(2000),
	/* 작성자IP */		IP		VARCHAR2(32),
	/* 게시글번호 */	NNO		NUMBER,
	/* 댓글작성일 */	RDATE	DATE
);

ALTER TABLE NOTICE ADD CONSTRAINT NOTICE_PK PRIMARY KEY(NNO);
ALTER TABLE REPLY ADD CONSTRAINT REPLY_PK PRIMARY KEY(RNO);

ALTER TABLE REPLY ADD CONSTRAINT REPLY_NOTICE_FK FOREIGN KEY(NNO) REFERENCES NOTICE(NNO) ON DELETE CASCADE;

DROP SEQUENCE NOTICE_SEQ;
DROP SEQUENCE REPLY_SEQ;
CREATE SEQUENCE NOTICE_SEQ NOCACHE;
CREATE SEQUENCE REPLY_SEQ NOCACHE;

INSERT INTO NOTICE 
VALUES (NOTICE_SEQ.NEXTVAL, '관리자', '이용 시 주의사항', '바른말 사용하기', 0, '0:0:0:0:0:0:0:1', SYSDATE, SYSDATE);
COMMIT

/*
	회원
	1. 회원 : member
	2. 기록 : member_log
*/
DROP TABLE MEMBER_LOG;
DROP TABLE MEMBER;
CREATE TABLE MEMBER
(
	/* 회원번호 */	MNO		NUMBER,
	/* 아이디 */	ID		VARCHAR2(32) NOT NULL UNIQUE,
	/* 비밀번호 */	PW		VARCHAR2(32) NOT NULL,
	/* 이름 */		NAME	VARCHAR2(50),
	/* 메일 */		EMAIL	VARCHAR2(200),
	/* 가입일 */	MDATE	DATE
);
CREATE TABLE MEMBER_LOG
(
	/* 기록번호 */	LNO		NUMBER,
	/* 아이디 */	ID		VARCHAR2(32),
	/* 로그인일시 */LOGIN	DATE
);

ALTER TABLE MEMBER ADD CONSTRAINT MEMBER_PK PRIMARY KEY(MNO);
ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBER_LOG_PK PRIMARY KEY(LNO);

ALTER TABLE MEMBER_LOG ADD CONSTRAINT MEMBER_LOG_MEMBER_FK
	FOREIGN KEY(ID) REFERENCES MEMBER(ID) ON DELETE CASCADE;

DROP SEQUENCE MEMBER_SEQ;
DROP SEQUENCE MEMBER_LOG_SEQ;
CREATE SEQUENCE MEMBER_SEQ NOCACHE;
CREATE SEQUENCE MEMBER_LOG_SEQ NOCACHE;

INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'admin', '1111', '관리자', 'admin@myhome.com', SYSDATE);
INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, 'scott', '1111', '스콧', 'scott@myhome.com', SYSDATE);
COMMIT














-- 생성자 Oracle SQL Developer Data Modeler 20.4.0.374.0801
--   위치:        2021-09-08 10:18:43 KST
--   사이트:      Oracle Database 11g
--   유형:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE


DROP TABLE schedule;
DROP TABLE player;
DROP TABLE event;
DROP TABLE nation;


CREATE TABLE event (
    e_code        NUMBER NOT NULL,
    e_name        VARCHAR2(30 BYTE) NOT NULL,
    e_first_year  NUMBER(4),
    e_info        VARCHAR2(100 BYTE)
);

ALTER TABLE event ADD CONSTRAINT event_pk PRIMARY KEY ( e_code );

CREATE TABLE nation (
    n_code          NUMBER(3) NOT NULL,
    n_name          VARCHAR2(30 BYTE) NOT NULL,
    n_parti_person  NUMBER,
    n_parti_event   NUMBER,
    n_prev_rank     NUMBER,
    n_curr_rank     NUMBER
);

ALTER TABLE nation ADD CONSTRAINT nation_pk PRIMARY KEY ( n_code );

CREATE TABLE player (
    p_code  NUMBER(3) NOT NULL,
    p_name  VARCHAR2(30 BYTE) NOT NULL,
    n_code  NUMBER(3) NOT NULL,
    e_code  NUMBER NOT NULL,
    p_rank  NUMBER,
    p_age   NUMBER(3)
);

ALTER TABLE player ADD CONSTRAINT player_pk PRIMARY KEY ( p_code );

ALTER TABLE player
    ADD CONSTRAINT player_event_fk FOREIGN KEY ( e_code )
        REFERENCES event ( e_code )
            ON DELETE CASCADE;

ALTER TABLE player
    ADD CONSTRAINT player_nation_fk FOREIGN KEY ( n_code )
        REFERENCES nation ( n_code )
            ON DELETE CASCADE;

CREATE TABLE schedule (
    n_code        NUMBER(3) NOT NULL,
    e_code        NUMBER NOT NULL,
    s_start_date  DATE,
    s_end_date    DATE,
    s_info        VARCHAR2(100 BYTE)
);

-- 2개 칼럼을 기본키로 사용
ALTER TABLE schedule ADD CONSTRAINT schedule_pk PRIMARY KEY(n_code, e_code);

ALTER TABLE schedule
    ADD CONSTRAINT schedule_nation_fk FOREIGN KEY(n_code)
        REFERENCES nation(n_code);
        
ALTER TABLE schedule
    ADD CONSTRAINT schedule_event_fk FOREIGN KEY(e_code)
        REFERENCES event(e_code);


-- Oracle SQL Developer Data Modeler 요약 보고서: 
-- 
-- CREATE TABLE                             3
-- CREATE INDEX                             0
-- ALTER TABLE                              5
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

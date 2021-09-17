-- 사용자 추가
CREATE USER administrator IDENTIFIED BY 1111;

-- 사용자 제거
DROP USER administrator;  -- 테이블과 같은 객체가 없을 때
DROP USER administrator CASCADE;  -- 객체가 있을 때

-- 권한 부여
GRANT CONNECT, RESOURCE TO administrator;  -- 접속, 테이블 활용
GRANT DBA TO administrator;  -- 관리자

-- 권한 해제
REVOKE CONNECT, RESOURCE FROM administrator;
REVOKE DBA FROM administrator;

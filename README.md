# 스프링부트 블로그 만들기 프로젝트

## 프로젝트 개요

## 사용기술


<details>
<summary>SpringEaglesSuperAdminQuery</summary>

-- 형석님
-- 트랜잭션 시작
START TRANSACTION;

-- 유저를 global_users 테이블에 등록
INSERT INTO global_users (user_name, user_password, user_email)
VALUES ('ppuding', 'ppuding', 'acdongedb@naver.com');

-- 마지막 삽입된 유저의 ID를 가져옴
SET @userId = LAST_INSERT_ID();

-- 유저에게 권한을 부여
INSERT INTO global_user_roles (user_id, user_roles)
VALUES (@userId, 'ROLE_KHS');

-- 트랜잭션 커밋
COMMIT;

-- 나
-- 트랜잭션 시작
START TRANSACTION;

-- 유저를 global_users 테이블에 등록
INSERT INTO global_users (user_name, user_password, user_email)
VALUES ('stjoo0925', 'stjoo0925', 'stjoo0925@gmail.com');

-- 마지막 삽입된 유저의 ID를 가져옴
SET @userId = LAST_INSERT_ID();

-- 유저에게 권한을 부여
INSERT INTO global_user_roles (user_id, user_roles)
VALUES (@userId, 'ROLE_JST');

-- 트랜잭션 커밋
COMMIT;

-- 서현님
-- 트랜잭션 시작
START TRANSACTION;

-- 유저를 global_users 테이블에 등록
INSERT INTO global_users (user_name, user_password, user_email)
VALUES ('seohyun', 'seohyun', 'seohyun@naver.com');

-- 마지막 삽입된 유저의 ID를 가져옴
SET @userId = LAST_INSERT_ID();

-- 유저에게 권한을 부여
INSERT INTO global_user_roles (user_id, user_roles)
VALUES (@userId, 'ROLE_LSH');

-- 트랜잭션 커밋
COMMIT;

-- 은진님
-- 트랜잭션 시작
START TRANSACTION;

</details>

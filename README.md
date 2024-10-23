
drop table users;

CREATE TABLE users (
    id NVARCHAR2(30) primary key,  -- 사용자의 고유 ID
    pw NVARCHAR2(30),              -- 사용자의 비밀번호
    -- nickname NVARCHAR2(30),     -- 사용자의 닉네임
    name NVARCHAR2(30),            -- 사용자의 이름
    gender NVARCHAR2(30),          -- 사용자의 성별
    birthday DATE,                 -- 사용자의 생년월일
    email NVARCHAR2(30),           -- 사용자의 이메일
    phoneNumber NVARCHAR2(30),     -- 사용자의 전화번호
    address NVARCHAR2(30)          -- 사용자의 주소
);
desc users;

insert into users(id, pw, name, gender, birthday, email, phoneNumber, address) values('a', '1234', '김철수', '남성', to_date('2005:05:05', 'YYYY:MM:DD'), 'a@naver.com', '010-1234-4321', '인천');
insert into users values('b', '1234', '나유리', '여성', to_date('2000:10:15', 'YYYY:MM:DD'), 'b@gmail.com', '010-2345-5432', '서울');
insert into users values('c', '1234', '박맹구', '남성', to_date('1995:12:04', 'YYYY:MM:DD'), 'c@daum.net', '010-3456-6543', '부산');
insert into users values('admin', '1234', '관리자', '남성', to_date('1990:10:02', 'YYYY:MM:DD'), 'admin@naver.com', '010-4567-7654', '미국');
insert into users values('zzx5678', '1234', '김정호', '남성', to_date('1995:12:04', 'YYYY:MM:DD'), 'zzx5678@naver.com', '010-5652-2318', '인천');
// to_date('2000:10:15 12:25:10', 'YYYY:MM:DD HH24:MI:SS')
commit;

select * from users;

select id, pw from users;
select id, pw, name, gender, birthday, email, phoneNumber, address from users where id='a';

drop table shops;

CREATE TABLE shops (
    img_address NVARCHAR2(150),      -- 상품 이미지의 주소
    code NVARCHAR2(30) primary key,  -- 상품의 고유 코드
    name NVARCHAR2(30),              -- 상품의 이름
    price NUMBER(10),                -- 상품의 가격
    product_Text CLOB,               -- 상품의 상세 설명
    manufacturer NVARCHAR2(30),      -- 제조사
    classify NVARCHAR2(30),          -- 상품의 분류
    stock NUMBER(4,0),               -- 재고 수량
    quality NVARCHAR2(20)            -- 상품의 품질
);
desc shops;

--img_address, code, name, price, product_Text, manufacturer, classify, stock, quality
insert into shops(img_address, code, name, price, product_Text, manufacturer, classify, stock, quality) values('https://cdn-icons-png.flaticon.com/512/5220/5220564.png', 'p1001', '자바 프로그래밍',	30000, '1',	'a제조사', '강의', 10, '신규 제품');
insert into shops values('https://www.ikea.com/kr/ko/images/products/paerup-2-seat-sofa-kelinge-rust__1213901_pe911374_s5.jpg?f=xxs',                                 'p1002', '오라클 데이터베이스', 50000, '2', 'a제조사', '강의', 20, '신규 제품');
insert into shops values('https://www.ikea.com/kr/ko/images/products/malm-bed-frame-high-w-2-storage-boxes-white-stained-oak-veneer-luroey__1154400_pe886048_s5.jpg', 'p1003', 'html css javascript', 70000, '3', 'b제조사', '강의',	30,	'신규 제품');
insert into shops values('https://i.namu.wiki/i/kkST1cIDQY9VOatN3mND88mqS7i8exV90QHBnxNJS7B2dOQEfPDnkZ2s7f2ZZsis1SvTN_LIKuJITC6_Gg-cKA.webp',                         'p1004', 'jsp', 90000, '4', 'c제조사',	'강의', 40, '신규 제품');

select * from shops;

--SELECT * FROM v$version;
--오라클 버전 확인

select * from shops order by code;


drop table cart;

CREATE TABLE cart (
    cart_id NVARCHAR2(36) primary key,          -- 장바구니 항목의 고유 ID
    session_id NVARCHAR2(36),                   -- 비회원의 세션 ID
    user_id NVARCHAR2(30),                      -- 사용자의 ID
    product_code NVARCHAR2(30) NOT NULL,        -- 상품의 코드 (shops 테이블의 code)
    quantity NUMBER(4,0) DEFAULT 1 NOT NULL,    -- 상품의 수량
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,        -- users 테이블과의 외래 키 관계
    FOREIGN KEY (product_code) REFERENCES shops(code) ON DELETE CASCADE, -- shops 테이블과의 외래 키 관계
    CONSTRAINT chk_user_or_session CHECK (user_id IS NOT NULL OR session_id IS NOT NULL)
    -- session_id 또는 user_id 중 하나는 반드시 값이 있어야 한다는 조건을 설정하는 제약 조건입니다.
);
desc cart;
select * from cart;

--cart_id, session_id, user_id, product_code, quantity, added_date

drop table orders;

CREATE TABLE orders (
    order_id NVARCHAR2(36) PRIMARY KEY,     -- 주문의 고유 ID
    session_id NVARCHAR2(36),               -- 비회원의 세션 ID
    user_id NVARCHAR2(30),                  -- 사용자의 ID
    order_name NVARCHAR2(30),               -- 주문자의 이름
    order_day NVARCHAR2(30),                -- 주문일
    order_address NVARCHAR2(30),            -- 주문자의 주소
    order_email NVARCHAR2(30),              -- 주문자의 이메일
    order_phoneNumber NVARCHAR2(30),        -- 주문자의 전화번호
    order_password NVARCHAR2(30)            -- 주문자의 비밀번호
);
desc orders;
select * from orders;

-- order_id, session_id, user_id, order_name, order_day, order_address, order_email, order_phoneNumber

drop table authorities;
CREATE TABLE authorities (
    id NVARCHAR2(30) NOT NULL, -- 사용자의 ID를 저장하는 열, null 값을 허용하지 않음
    authority NVARCHAR2(50) NOT NULL, -- 사용자의 권한(예: ROLE_USER, ROLE_ADMIN)을 저장하는 열, null 값을 허용하지 않음
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE -- id 열은 users 테이블의 id 열을 참조하는 외래 키, users 테이블의 해당 id가 삭제될 경우 이 테이블의 연관된 데이터도 삭제됨
);
insert into authorities values('a','ROLE_MEMBER');
insert into authorities values('b','ROLE_MEMBER');
insert into authorities values('c','ROLE_MEMBER');
insert into authorities values('admin','ROLE_ADMIN');
insert into authorities values('zzx5678','ROLE_MEMBER');
commit;
select * from authorities;
SELECT id, authority FROM authorities WHERE id = 'a';

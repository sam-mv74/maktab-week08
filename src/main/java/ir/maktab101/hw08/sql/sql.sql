CREATE TABLE IF NOT EXISTS user_tbl
(
    id SERIAL PRIMARY KEY ,
    full_name VARCHAR(50),
    username VARCHAR(50) UNIQUE ,
    password VARCHAR(50),
    email VARCHAR(50) UNIQUE
    );

CREATE TABLE IF NOT EXISTS category_tbl
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE,
    description VARCHAR(50) UNIQUE
    );

CREATE TABLE IF NOT EXISTS brand_tbl
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50) UNIQUE ,
    website VARCHAR(50),
    description VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS shareholder_tbl
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50),
    phone_number VARCHAR(50),
    national_code VARCHAR(50) UNIQUE
    );

CREATE TABLE IF NOT EXISTS product_tbl
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50),
    create_date VARCHAR(50),
    category_id INT,
    brand_id INT,
    FOREIGN KEY (category_id) references category_tbl(id),
    FOREIGN KEY (brand_id) references brand_tbl(id)
    );

CREATE TABLE IF NOT EXISTS shareholder_brand
(
    shareholder_id INT REFERENCES shareholder_tbl(id) ,
    brand_id INT REFERENCES brand_tbl(id) ,
    PRIMARY KEY (shareholder_id, brand_id)
    );
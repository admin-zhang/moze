
create database moze;
use moze;
CREATE TABLE wechat_bill (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             transaction_time DATETIME NOT NULL,
                             transaction_type VARCHAR(50),
                             counterpart VARCHAR(100),
                             product VARCHAR(100),
                             income_expense ENUM('收入', '支出') NOT NULL,
                             amount DECIMAL(10, 2) NOT NULL,
                             payment_method VARCHAR(50),
                             current_status VARCHAR(50),
                             transaction_number VARCHAR(100),
                             merchant_number VARCHAR(100),
                             remarks TEXT
);

CREATE TABLE alipay_bill (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             transaction_time DATETIME NOT NULL,
                             transaction_category VARCHAR(50),
                             counterpart VARCHAR(100),
                             counterpart_account VARCHAR(100),
                             product_description VARCHAR(100),
                             income_expense ENUM('收入', '支出') NOT NULL,
                             amount DECIMAL(10, 2) NOT NULL,
                             payment_method VARCHAR(50),
                             transaction_status VARCHAR(50),
                             transaction_order_number VARCHAR(100),
                             merchant_order_number VARCHAR(100),
                             remarks TEXT
);
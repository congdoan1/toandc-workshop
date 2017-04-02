CREATE TABLE user (
  id          INT PRIMARY KEY AUTO_INCREMENT,
  full_name   TEXT            DEFAULT NULL,
  address     TEXT            DEFAULT NULL,
  phone       TEXT            DEFAULT NULL,
  note        TEXT            DEFAULT NULL,
  modify_date DATETIME        DEFAULT NOW() ON UPDATE NOW(),
  create_date DATETIME        DEFAULT NOW()
);
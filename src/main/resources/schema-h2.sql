--CREATE DATABASE IF NOT EXISTS homedepot_test ;
--USE homedepot_test ;
DROP ALL OBJECTS;

--
-- Table structure for table customer 
--
DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  login_name varchar(255) NOT NULL,
 PRIMARY KEY ( id )
);

--
-- Table structure for table product 
--
DROP TABLE IF EXISTS product ;
CREATE TABLE product (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
 PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table customer_comment 
--
DROP TABLE IF EXISTS customer_comment ;
CREATE TABLE customer_comment (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  customer_id  int(11) unsigned DEFAULT NULL,
  comment varchar(1999) DEFAULT NULL,
 PRIMARY KEY ( id ),
 CONSTRAINT fk_customer_customent_customer FOREIGN KEY ( customer_id ) REFERENCES customer ( id ) ON DELETE CASCADE ON UPDATE CASCADE
);

--
-- Table structure for table product_review 
--
DROP TABLE IF EXISTS product_review ;
CREATE TABLE product_review (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  customer_comment_id int(11) unsigned DEFAULT NULL,
  product_id  int(11) unsigned DEFAULT NULL,
  rating int(1) DEFAULT 0,
 PRIMARY KEY ( id ),
 CONSTRAINT fk_product_review_customer_comment FOREIGN KEY ( customer_comment_id ) REFERENCES customer_comment ( id ) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT fk_product_review_product FOREIGN KEY ( product_id ) REFERENCES product ( id ) ON DELETE CASCADE ON UPDATE CASCADE
);

--
--  Table structure for table curse_words
--
DROP TABLE IF EXISTS curse_word ;
CREATE TABLE curse_word (
  id int(11) unsigned NOT NULL AUTO_INCREMENT,
  word varchar(256) NOT NULL,
 PRIMARY KEY ( id )
 );

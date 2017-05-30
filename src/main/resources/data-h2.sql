-- customer
--'id' int(11)
--'name' varchar(255)
--'login_name' varchar(255)

INSERT INTO customer (id, name, login_name) VALUES
(1, 'customer_1', 'customer1'),
(2, 'customer_2', 'customer2');


-- product
--'id' int(11) 
--'description' varchar(255)
INSERT INTO product(id, description) VALUES
(1, 'product 1'),
(2, 'product 2'),
(3, 'product 3'),
(4, 'product 4');

-- customer_comment
--'id' int(11)
--'customer_id'  int(11)
--'comment' varchar(1999)
INSERT INTO customer_comment(id, customer_id, comment) VALUES
(1 , 1, 'customer_1. 1:comment#1 on product # 1'),
(2 , 1, 'customer_1. 2:comment#2 on product # 1'),
(3 , 1, 'customer_1. 3:comment#1 on product # 2'),
(4 , 1, 'customer_1. 4:comment#2 on product # 2'),
(5 , 1, 'customer_1. 5:comment#1 on product # 3'),
(6 , 1, 'customer_1. 6:comment#2 on product # 3'),
(7 , 1, 'customer_1. 7:comment#1 on product # 4'),
(8 , 1, 'customer_1. 8:comment#2 on product # 4'),
(9 , 2, 'customer_2. 9:comment#1 on product # 1'),
(10, 2, 'customer_2. 10:comment#1 on product # 2'),
(11, 2, 'customer_2. 11:comment#1 on product # 3');

-- product_review
--'id' int(11)
--'customer_comment_id' int(11)
--'product_id'  int(11)
--'rating' int(1)
INSERT INTO product_review(id, customer_comment_id, product_id, rating) VALUES
(1 , 1 , 1, 1),
(2 , 2 , 1, 9),
(3 , 3 , 2, 2),
(4 , 4 , 2, 1),
(5 , 5 , 3, 1),
(6 , 6 , 3, 9),
(7 , 7 , 4, 9),
(8 , 8 , 4, 5),
(9 , 9 , 1, 6),
(10, 10, 2, 0),
(11, 11, 3, 2);

INSERT INTO curse_word (id, word)VALUES 
(1 , 'shit'),	
(2 , 'fuck'),
(3 , 'damn'),
(4 , 'bitch'),
(5 , 'crap'),
(6 , 'piss'),
(7 , 'dick'),
(8 , 'darn'),
(9 , 'pussy'),
(10, 'cock'),
(11, 'fag'),
(12, 'asshole'),	
(13, 'bastard'),	
(14, 'slut'),	
(15, 'douche');



INSERT INTO`truyum`.`menu_item`(`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`,`me_image_url`) VALUES('Sandwich', 199.00,'yes', '2017-03-05', 'Main Course', 'yes','hqqq');
INSERT INTO`truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`,`me_image_url`) VALUES('Pizza', 125.00, 'yes', '2017-12-03','Main Course', 'no','hqqq');
INSERT INTO`truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`,`me_image_url`) VALUES('Chocolate Brownie', 113.00,'yes', '2017-08-19','Main Course', 'yes','hqqq');
INSERT INTO`truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`,`me_image_url`) VALUES( 'French Fries', 42.00, 'no', '2017-07-07','Starters', 'yes','hqqq');
INSERT INTO`truyum`.`menu_item`(`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`,`me_image_url`) VALUES('Burger', 41.00, 'yes','2022-11-11','Dessert', 'no','hqqq');


SELECT * FROM menu_item;





SELECT * FROM `truyum`.`menu_item` WHERE me_active='yes' AND me_date_of_launch<=CURDATE();


SELECT * FROM `truyum`.`menu_item` WHERE me_id=4;
UPDATE `truyum`.`menu_item` SET `me_name`='Donut', `me_price`='46', `me_active`='yes', `me_date_of_launch`='2017-04-30', `me_category`='Dessert', `me_free_delivery`='no' WHERE `me_id`='4';



INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('1', 'Neeraj');
INSERT INTO `truyum`.`user` (`us_id`, `us_name`) VALUES ('2', 'Praveen');

INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '4');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '2');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '3');



SELECT * FROM `truyum`.`menu_item` WHERE me_id in (SELECT ct_pr_id FROM `truyum`.`cart` WHERE ct_us_id=3);
SELECT SUM(me_price) as `Total Price` FROM `truyum`.`menu_item` WHERE me_id in (SELECT ct_pr_id FROM `truyum`.`cart` WHERE ct_us_id=3);


DELETE FROM `truyum`.`cart` WHERE ct_us_id=2 AND ct_pr_id=3;

select * from user;
select * from role;
select * from user_role;


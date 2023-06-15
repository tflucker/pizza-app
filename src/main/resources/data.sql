
-- data for CUSTOMER table
INSERT INTO CUSTOMER (NAME, PHONE, EMAIL, RECEIVE_PROMOTIONS) VALUES ('John Doe', '555-123-4567', 'jDoe@email.com', TRUE);
INSERT INTO CUSTOMER (NAME, PHONE, EMAIL, RECEIVE_PROMOTIONS) VALUES ('Jane Doe', '555-456-7890', 'janeDoe@email.com', FALSE);
INSERT INTO CUSTOMER (NAME, PHONE, EMAIL, RECEIVE_PROMOTIONS) VALUES ('Tim Flucker', '555-555-5555', 'tflucker@email.com', TRUE);
	
-- data for PIZZA table
INSERT INTO PIZZA (NAME, DESCRIPTION, COST, IS_VEGETARIAN) VALUES ('Cheese Pizza', 'Classic Cheese Pizza with red sauce.', 10.00, FALSE);
INSERT INTO PIZZA (NAME, DESCRIPTION, COST, IS_VEGETARIAN) VALUES ('Pepperoni Pizza', 'A cheese pizza with pepperoni.', 12.00, FALSE);
INSERT INTO PIZZA (NAME, DESCRIPTION, COST, IS_VEGETARIAN) VALUES ('Veggie Pizza', 'A cheese pizza topped with veggies.', 12.12, FALSE);

-- data for TOPPINGS table
INSERT INTO TOPPINGS (NAME, DESCRIPTION) VALUES ('Cheese', 'House blend of cheese.');
INSERT INTO TOPPINGS (NAME, DESCRIPTION) VALUES ('Mozzerella Cheese', 'Slices of fresh mozzerella.');
INSERT INTO TOPPINGS (NAME, DESCRIPTION) VALUES ('Tomato Sauce', 'Classic tomato sauce freshly made in-house.');
INSERT INTO TOPPINGS (NAME, DESCRIPTION) VALUES ('Pepperoni', 'Slices of pepperoni.');
INSERT INTO TOPPINGS (NAME, DESCRIPTION) VALUES ('Onions', 'Thinly sliced onions.');
INSERT INTO TOPPINGS (NAME, DESCRIPTION) VALUES ('Green Peppers', 'Thinly sliced green peppers.');
INSERT INTO TOPPINGS (NAME, DESCRIPTION) VALUES ('Mushrooms', 'Thinly sliced white mushrooms.');


-- data for PIZZA_TOPPINGS table
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Cheese Pizza'), (select toppings_id from TOPPINGS where name='Cheese'));
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Cheese Pizza'), (select toppings_id from TOPPINGS where name='Tomato Sauce'));

INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Pepperoni Pizza'), (select toppings_id from TOPPINGS where name='Cheese'));
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Pepperoni Pizza'), (select toppings_id from TOPPINGS where name='Tomato Sauce'));
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Pepperoni Pizza'), (select toppings_id from TOPPINGS where name='Pepperoni'));

INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Veggie Pizza'), (select toppings_id from TOPPINGS where name='Cheese'));
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Veggie Pizza'), (select toppings_id from TOPPINGS where name='Tomato Sauce'));
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Veggie Pizza'), (select toppings_id from TOPPINGS where name='Onions'));
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Veggie Pizza'), (select toppings_id from TOPPINGS where name='Green Peppers'));
INSERT INTO PIZZA_TOPPINGS (PIZZA_ID, TOPPINGS_ID) VALUES ( (select pizza_id from PIZZA where name='Veggie Pizza'), (select toppings_id from TOPPINGS where name='Mushrooms'));

-- data for PIZZA_ORDER table
INSERT INTO PIZZA_ORDER (CUSTOMER_ID, PIZZA_ID, ORDER_DATE) VALUES ( (select CUSTOMER_ID from CUSTOMER where name='John Doe'), (select pizza_id from PIZZA where name='Cheese Pizza'), '2023-04-12');
INSERT INTO PIZZA_ORDER (CUSTOMER_ID, PIZZA_ID, ORDER_DATE) VALUES ( (select CUSTOMER_ID from CUSTOMER where name='Jane Doe'), (select pizza_id from PIZZA where name='Veggie Pizza'), '2023-04-12');
INSERT INTO PIZZA_ORDER (CUSTOMER_ID, PIZZA_ID, ORDER_DATE) VALUES ( (select CUSTOMER_ID from CUSTOMER where name='Tim Flucker'), (select pizza_id from PIZZA where name='Pepperoni Pizza'), '2023-04-12');
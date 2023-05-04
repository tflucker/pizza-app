-- DROP TABLES
DROP TABLE IF EXISTS Pizza;
DROP TABLE IF EXISTS Toppings;
DROP TABLE IF EXISTS PizzaToppings;
DROP TABLE IF EXISTS CustomerInfo;
DROP TABLE IF EXISTS PizzaOrder;


-- Create all tables with constraints
CREATE TABLE Pizza (
  Pizza_ID 		SERIAL NOT NULL,
  Name 				VARCHAR(128) 	NOT NULL,
  Description 		VARCHAR(255) 	NOT NULL,
  Cost 				DECIMAL(5,2) 	NOT NULL,
  Is_Vegetarian 	BOOLEAN 		NOT NULL,
  PRIMARY KEY (Pizza_ID)
);

CREATE TABLE Toppings (
  Toppings_ID 	SERIAL 			NOT NULL,
  Name 			VARCHAR(32) 	NOT NULL,
  Description 	VARCHAR(128) 	NOT NULL,
  PRIMARY KEY (Toppings_ID)
);

CREATE TABLE Pizza_Toppings (
  Pizza_Toppings_ID 	SERIAL 	NOT NULL,
  Pizza_ID 			BIGINT 	NOT NULL,
  Toppings_ID 		BIGINT 	NOT NULL,
  PRIMARY KEY (Pizza_Toppings_ID),
  FOREIGN KEY(Pizza_ID) REFERENCES Pizza,
  FOREIGN KEY (Toppings_ID) REFERENCES Toppings
);

CREATE TABLE Customer_Info (
  Customer_Info_ID 		SERIAL 			NOT NULL,
  Name 					VARCHAR(128) 	NOT NULL,
  Phone 				VARCHAR(15) 	NOT NULL,
  Email 				VARCHAR(128) 	NOT NULL,
  Receive_Promotions 	BOOLEAN 		NOT NULL,
  PRIMARY KEY (Customer_Info_ID)
);


CREATE TABLE Pizza_Order (
  Pizza_Order_ID 	SERIAL 			NOT NULL,
  Customer_Info_ID 	BIGINT 			NOT NULL,
  Pizza_ID 			BIGINT 			NOT NULL,
  Order_Date 		DATE 			NOT NULL,
  PRIMARY KEY (Pizza_Order_ID),
  FOREIGN KEY(Pizza_ID) REFERENCES Pizza,
  FOREIGN KEY (Customer_Info_ID) REFERENCES Customer_Info
);


-- Create indexes for tables (foreign key constraints
CREATE INDEX PIZZA_ORDER_CUST_INFO_IDX ON  Pizza_Order (Customer_Info_ID);
CREATE INDEX PIZZA_ORDER_PIZZA_IDX ON  Pizza_Order (Pizza_ID);
CREATE INDEX PIZZA_TOPPINGS_TOPPINGS_IDX ON  Pizza_Toppings (Toppings_ID);
CREATE INDEX PIZZA_TOPPINGS_PIZZA_IDX ON  Pizza_Toppings (Pizza_ID);

-- indexes for fields used in queries
CREATE INDEX PIZZA_NAME_IDX ON PIZZA (Name);
CREATE INDEX TOPPINGS_NAME_IDX ON TOPPINGS(Name);
# CREATE SCHEMA `myshop` DEFAULT CHARACTER SET utf8 ;
# CREATE TABLE `myshop`.`categories` (
#                                        `CategoryID` INT NOT NULL AUTO_INCREMENT,
#                                        `CategoryName` VARCHAR(45) NOT NULL,
#                                        `Description` TEXT NOT NULL,
#                                        PRIMARY KEY (`CategoryID`));
#
# CREATE TABLE `myshop`.`suppliers` (
#                                       `SupplierID` INT NOT NULL AUTO_INCREMENT,
#                                       `SupplierName` VARCHAR(45) NOT NULL,
#                                       `City` VARCHAR(45) NOT NULL,
#                                       `Country` VARCHAR(45) NOT NULL,
#                                       PRIMARY KEY (`SupplierID`));
# CREATE TABLE `myshop`.`products` (
#                                       `ProductID` INT NOT NULL AUTO_INCREMENT,
#                                       `ProductName` VARCHAR(45) NOT NULL,
#                                       `SupplierID` INT NOT NULL,
#                                       `CategoryID` INT NOT NULL,
#                                       `Price` DOUBLE NOT NULL,
#                                       PRIMARY KEY (`ProductID`),
#                                       FOREIGN KEY(SupplierID) REFERENCES suppliers(SupplierID),
#                                       FOREIGN KEY(CategoryID) REFERENCES categories(CategoryID));

# INSERT INTO products (ProductName,SupplierID,CategoryID,Price)  VALUES
#                                                                        ('Chais',1,1,18.00),
#                                                                        ('Chang',1,1,19.00),
#                                                                        ('Aniseed Syrup',1,2,10.00),
#                                                                        ('Chef Anton’s Cajun Seasoning',2,2,22.00),
#                                                                        ('Chef Anton’s Gumbo Mix',2,2,21.35);

# INSERT INTO suppliers (SupplierName,City,Country)  VALUES
#                                                                        ('Exotic Liquid','London','UK'),
#                                                                        ('New Orleans Cajun Delights','New Orleans;','USA'),
#                                                                        ('Grandma Kelly’s Homestead;','Ann Arbor','USA'),
#                                                                        ('Tokyo Traders','Tokyo','Japan'),
#                                                                        ('Cooperativa de Quesos ‘Las Cabras’','Oviedo','Spain');

# INSERT INTO categories (CategoryName, Description)  VALUES
#                                                                        ('Beverages','Soft drinks, coffees, teas, beers, and ales'),
#                                                                        ('Condiments','Sweet and savory sauces, relishes, spreads, and seasonings'),
#                                                                        ('Confections','Desserts, candies, and sweet breads'),
#                                                                        ('Dairy Products','Cheeses'),
#                                                                        ('Grains/Cereals','Breads, crackers, pasta, and cereal');


# 1---------------------------------------------------------------
Select * FROM Products WHERE ProductName LIKE 'C%';

# 2---------------------------------------------------------------
SELECT * FROM products WHERE Price = (SELECT MIN(Price) FROM products);

# 3---------------------------------------------------------------
SELECT SUM(Price) FROM Products INNER JOIN Suppliers ON Suppliers.SupplierID = Products.SupplierID AND Suppliers.Country = 'USA';

# 4---------------------------------------------------------------
Select psc.CategoryName, psc.SupplierName, psc.City, psc.Country
from (Select c.CategoryName, s.SupplierName, s.City, s.Country
      from Products p
               inner join Suppliers s on p.SupplierID = s.SupplierID
               inner join Categories c on p.CategoryID = c.CategoryID) psc
where psc.CategoryName = 'Condiments';

# 5---------------------------------------------------------------
INSERT INTO suppliers (SupplierName, City, Country) VALUES ('Norske Meierier', 'Lviv', 'Ukraine');

INSERT INTO products (productname, supplierid, categoryid, price) VALUES ('Green tea', 6, 1, 10.00);

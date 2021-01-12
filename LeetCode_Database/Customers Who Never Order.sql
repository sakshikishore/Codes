# Write your MySQL query statement below
Select Customers.Name AS Customers From Customers Where Id NOT IN (Select Customers.Id From Customers Inner Join Orders On Orders.CustomerId=Customers.Id)

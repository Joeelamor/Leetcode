// Problem 183 Customers Who Never Order

// This is a SQL problem
# Write your MySQL query statement below
select Name as Customers
from Customers
where Customers.Id not in (select CustomerId from Orders)


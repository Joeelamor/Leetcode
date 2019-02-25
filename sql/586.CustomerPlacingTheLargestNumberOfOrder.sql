# 586 Customer Placing the Largest Number of Orders

# Write your MySQL query statement below
select customer_number
from orders
group by customer_number
order by count(*) desc
limit 1
# 619 Biggest Single Number

# Write your MySQL query statement below
select max(num) num
from (
    select num
    from number 
    group by num
    having count(num) = 1) t

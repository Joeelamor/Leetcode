// Problem 578 Get Highest Answer Rate Question

# Write your MySQL query statement below
select question_id as survey_log from survey_log 
group by question_id 
order by sum(case when action="answer" then 1 else 0 end) desc limit 1
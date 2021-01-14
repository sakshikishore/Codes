# Write your MySQL query statement below
Select p1.id From Weather p1, Weather p2 where Datediff(p1.recordDate,p2.recordDate)=1 AND p1.Temperature>p2.Temperature



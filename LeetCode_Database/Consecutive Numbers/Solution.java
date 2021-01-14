# Write your MySQL query statement below
Select distinct p2.Num As ConsecutiveNums From Logs p1, Logs p2, Logs p3 where p1.Num=p2.Num And p2.Num=p3.Num AND p2.Id-p1.Id=1 AND p3.Id-p2.Id=1 

# Write your MySQL query statement below
Select p1.Name AS Employee From Employee p1,Employee p2 where p1.ManagerId Is NOT Null AND p1.ManagerId=p2.Id AND p1.Salary>p2.Salary

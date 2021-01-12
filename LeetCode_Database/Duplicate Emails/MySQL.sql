# Write your MySQL query statement below
Select distinct p1.Email From Person p1, Person p2 where p1.Email=p2.Email AND p1.Id!=p2.Id

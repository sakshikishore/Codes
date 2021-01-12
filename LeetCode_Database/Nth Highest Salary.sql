CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
SET N=N-1;
  RETURN (
   Select distinct Salary From Employee Order by Salary desc Limit N,1      
  );
END

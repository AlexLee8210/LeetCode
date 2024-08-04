# Write your MySQL query statement below
SELECT e1.name
FROM Employee e1
RIGHT JOIN (
    SELECT managerId, COUNT(managerId) as employeeCount
    FROM Employee
    WHERE managerId IN (SELECT id FROM Employee)
    GROUP BY managerId
) e2 ON e2.managerId = e1.id
WHERE e2.employeeCount >= 5;

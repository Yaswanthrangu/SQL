SELECT a.name 
FROM Employee a 
CROSS JOIN Employee b WHERE a.id = b.managerId 
GROUP BY b.managerId 
HAVING COUNT(*) >= 5;
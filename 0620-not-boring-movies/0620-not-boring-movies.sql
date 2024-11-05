# Write your MySQL query statement below
SELECT id, movie, description, rating from cinema WHERE id % 2 != 0 AND description != 'Boring' ORDER BY rating DESC;
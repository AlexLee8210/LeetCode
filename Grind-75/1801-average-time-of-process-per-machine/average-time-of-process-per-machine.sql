# Write your MySQL query statement below
SELECT machine_id, ROUND(MAX(avg) - MIN(avg), 3) as processing_time
FROM (
    SELECT *, AVG(timestamp) as avg
    FROM Activity
    GROUP BY machine_id, activity_type
) AS t1
GROUP BY machine_id;
# Write your MySQL query statement below
SELECT s.student_id, s.student_name, sub.subject_name, COUNT(e.subject_name) as attended_exams
FROM Students s
CROSS JOIN Subjects sub
LEFT JOIN Examinations e
ON e.student_id = s.student_id and sub.subject_name = e.subject_name
GROUP BY s.student_id, sub.subject_name
ORDER BY s.student_id;

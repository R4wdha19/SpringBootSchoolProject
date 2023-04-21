select * from course;
select * from mark;
select * from school;
select * from student;
SELECT s.id AS student MAX(m.obtained_marks) AS highestMarks
FROM student s
JOIN course cs ON s.id = cs.student_id
JOIN mark m ON cs.id = m.course_id
WHERE s.school_id = 1
GROUP BY s.id, cs.id

SELECT s.id, cs.id, MAX(m.obtained_marks) AS "highestMarks"
FROM student s
JOIN course cs ON s.id = cs.student_id
JOIN mark m ON cs.id = m.course_id
WHERE s.school_id = 1
GROUP BY s.id, cs.id
HAVING highestMarks = MAX(m.obtained_marks)

SELECT s.id, cs.id, MAX(m.obtained_marks) AS highestMarks
FROM student s
JOIN course cs ON s.id = cs.student_id
JOIN mark m ON cs.id = m.course_id
WHERE s.school_id = 1
GROUP BY s.id, cs.id
HAVING MAX(m.obtained_marks) = (
  SELECT MAX(obtained_marks)
  FROM mark
  WHERE course_id = cs.id
)
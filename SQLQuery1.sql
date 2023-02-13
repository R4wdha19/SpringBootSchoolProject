use prcaticeSchool
select * from school
select * from student
select * from course
select * from mark

-- get students by school id 

select id from school where school_name = 'AlNoor';

select student_name from student where school_id = 2;
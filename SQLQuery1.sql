use prcaticeSchool
select * from school
select * from student
select * from course
select * from mark


UPDATE mark set is_active = 1 where is_active is null;

select s.* from School s where s.id = (select Max(s.id) from school s )
select s.* from school s where s.updated_date = (select Max(s.updated_date) from school s)
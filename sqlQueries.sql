         use prcaticeSchool;
		 Update course Set created_date = GETDATE() where created_date is null;
		  Update mark Set created_date = GETDATE() where created_date is null;
		  Update school Set created_date = GETDATE() where created_date is null;
		  Update student Set created_date = GETDATE() where created_date is null;
		 select * from course
		 select * from mark
		 select * from school
		 select * from student
	select c.* from course c where c.created_date >= '2022-02-25'
	  
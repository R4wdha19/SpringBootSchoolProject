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
	  Update school Set is_active = 1 
	  Update course Set is_active = 1 
	  Update student Set is_active = 1 
	  Update mark Set is_active = 1 
	  Update school s Set s.isActive = 0 
	   Update student Set updated_date = GETDATE() where updated_date is null;
	   Update course Set updated_date = GETDATE() where updated_date is null;
	   Update school Set updated_date = GETDATE() where updated_date is null;
	   Update mark Set updated_date = GETDATE() where updated_date is null;
	   select MAX (updated_date) from mark
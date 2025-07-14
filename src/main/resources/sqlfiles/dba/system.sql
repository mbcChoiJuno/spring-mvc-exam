CREATE USER spring_exam 
	IDENTIFIED BY spring_exam

ALTER USER spring_exam 
	DEFAULT TABLESPACE users 
	TEMPORARY TABLESPACE temp

GRANT connect, DBA TO spring_exam
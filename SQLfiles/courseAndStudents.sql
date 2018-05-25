CREATE DATABASE IF NOT EXISTS Course;
 
USE Course;

CREATE TABLE IF NOT EXISTS courses(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL ,
	code INT NOT NULL,
	semester VARCHAR(30) NOT NULL,
	year INT NOT NULL,
	startHour VARCHAR(30),
	endHour VARCHAR(30),
	professorName VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS students(
	id INT NOT NULL AUTO_INCREMENT,
	firstName VARCHAR(50) NOT NULL ,
	lastName VARCHAR(50) NOT NULL ,
	credits INT,
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS coursesJoinStudents(
  id INT NOT NULL AUTO_INCREMENT,
	grade VARCHAR(3),
	courses_id INT,
	students_id INT,
	FOREIGN KEY(courses_id) REFERENCES courses(id),
  FOREIGN KEY(students_id) REFERENCES students(id)
);

CREATE TABLE IF NOT EXISTS days(
  id INT NOT NULL AUTO_INCREMENT,
  dayOfWeek VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS daysCoursesJoin(
  days_id INT,
	courses_id INT,
	FOREIGN KEY(courses_id) REFERENCES courses(id),
  FOREIGN KEY(days_id_id) REFERENCES days(id)
);
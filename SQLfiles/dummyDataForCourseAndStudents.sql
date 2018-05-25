INSERT INTO courses(name, code, semester, year) VALUES
	("Intro to History", 1000, "spring", 2018, "12:30pm", "2:00pm"),
	("Classical Cultures", 2300,"spring", 2018, "12:30pm", "2:00pm"),
	("Intro to Java Programming", 1000, "spring", 2018, "12:45pm", "2:15pm"),
	("Data Structures", 2500, "spring", 2018, "2:45pm", "4:15pm"),
	("Intro to German", 1000, "spring", 2018, "10:00am", "11:15pm"),
	("Political Sociology", 3000, "spring", 2018, "12:45pm", "2:15pm"),
	("Object Oriented Programming", 3100, "spring", 2018, "8:00am", "10:15pm"),
	("Organic Chemistry", 2100, "spring", 2018, "8:00pm", "10:00pm"),
	("Calculus I", 1050, "spring", 2018, "9:10am", "10:15am"),
	("Linear Algebra", 2300, "spring", 2018, , "9:10pm", "10:15pm");

INSERT INTO days(dayOfWeek) VALUES
  ("saturday"),
  ("sunday"),
  ("monday"),
  ("tuesday"),
  ("wednesday"),
  ("thursday"),
  ("friday"),


INSERT INTO students(firstName, lastName) VALUES
	("Bob", "TheBuilder"),
	("Mary", "Lamb"),
	("Hue", "Jazz"),
	("Richard", "Mann");

INSERT INTO coursesJoinStudents(courses_id, students_id) VALUES
	((SELECT id FROM courses WHERE name="Intro to History"), (SELECT id FROM days WHERE firstName="Bob" AND lastName="TheBuilder")),
	((SELECT id FROM courses WHERE name="Political Sociology"), (SELECT id FROM students WHERE firstName="Bob" AND lastName="TheBuilder")),
	((SELECT id FROM courses WHERE name="Linear Algebra"), (SELECT id FROM students WHERE firstName="Bob" AND lastName="TheBuilder")),

	((SELECT id FROM courses WHERE name="Intro to History"), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb")),
	((SELECT id FROM courses WHERE name="Political Sociology"), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb")),
	((SELECT id FROM courses WHERE name="Linear Algebra"), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb")),

	((SELECT id FROM courses WHERE name="Political Sociology"), (SELECT id FROM students WHERE firstName="Hue" AND lastName="Jazz")),
	((SELECT id FROM courses WHERE name="Calculus I"), (SELECT id FROM students WHERE firstName="Hue" AND lastName="Jazz")),
	((SELECT id FROM courses WHERE name="Linear Algebra"), (SELECT id FROM students WHERE firstName="Hue" AND lastName="Jazz")),

	((SELECT id FROM courses WHERE name="Object Oriented Programming"), (SELECT id FROM students WHERE firstName="Richard" AND lastName="Mann")),
	((SELECT id FROM courses WHERE name="Intro to Java Programming"), (SELECT id FROM students WHERE firstName="Richard" AND lastName="Mann")),
	((SELECT id FROM courses WHERE name="Intro to History"), (SELECT id FROM students WHERE firstName="Richard" AND lastName="Mann"));

INSERT INTO daysCoursesJoin(days_id, courses_id) VALUES
  ((SELECT id FROM courses WHERE name="Intro to History"), (SELECT id FROM days WHERE dayOfWeek = "saturday")),
	((SELECT id FROM courses WHERE name="Intro to History"), (SELECT id FROM days WHERE dayOfWeek = "thursday")),
	((SELECT id FROM courses WHERE name="Intro to History"), (SELECT id FROM days WHERE dayOfWeek = "wednesday")),

	((SELECT id FROM courses WHERE name="Classical Cultures"), (SELECT id FROM days WHERE dayOfWeek = "tuesday")),
	((SELECT id FROM courses WHERE name="Classical Cultures"), (SELECT id FROM days WHERE dayOfWeek = "thursday")),
	((SELECT id FROM courses WHERE name="Classical Cultures"), (SELECT id FROM days WHERE dayOfWeek = "friday")),

	((SELECT id FROM courses WHERE name="Intro to Java Programming"), (SELECT id FROM days WHERE dayOfWeek = "monday")),
	((SELECT id FROM courses WHERE name="Intro to Java Programming"), (SELECT id FROM days WHERE dayOfWeek = "wednesday")),
	((SELECT id FROM courses WHERE name="Intro to Java Programming"), (SELECT id FROM days WHERE dayOfWeek = "friday")),

	((SELECT id FROM courses WHERE name="Data Structures"), (SELECT id FROM days WHERE dayOfWeek = "saturday")),
	((SELECT id FROM courses WHERE name="Data Structures"), (SELECT id FROM days WHERE dayOfWeek = "monday")),


	((SELECT id FROM courses WHERE name="Intro to German"), (SELECT id FROM days WHERE dayOfWeek = "tuesday")),
	((SELECT id FROM courses WHERE name="Intro to German"), (SELECT id FROM days WHERE dayOfWeek = "thursday")),
	((SELECT id FROM courses WHERE name="Intro to German"), (SELECT id FROM days WHERE dayOfWeek = "monday")),

  ((SELECT id FROM courses WHERE name="Political Sociology"), (SELECT id FROM days WHERE dayOfWeek = "monday")),
	((SELECT id FROM courses WHERE name="Political Sociology"), (SELECT id FROM days WHERE dayOfWeek = "thursday")),


  ((SELECT id FROM courses WHERE name="Object Oriented Programming"), (SELECT id FROM days WHERE dayOfWeek = "tuesday")),
	((SELECT id FROM courses WHERE name="Object Oriented Programming"), (SELECT id FROM days WHERE dayOfWeek = "thursday")),
	((SELECT id FROM courses WHERE name="Object Oriented Programming"), (SELECT id FROM days WHERE dayOfWeek = "monday")),

  ((SELECT id FROM courses WHERE name="Organic Chemistry"), (SELECT id FROM days WHERE dayOfWeek = "tuesday")),
	((SELECT id FROM courses WHERE name="Organic Chemistry"), (SELECT id FROM days WHERE dayOfWeek = "wednesday")),
	((SELECT id FROM courses WHERE name="Organic Chemistry"), (SELECT id FROM days WHERE dayOfWeek = "thursday")),

  ((SELECT id FROM courses WHERE name="Calculus I"), (SELECT id FROM days WHERE dayOfWeek = "thursday")),
	((SELECT id FROM courses WHERE name="Calculus I"), (SELECT id FROM days WHERE dayOfWeek ="wednesday" )),
	((SELECT id FROM courses WHERE name="Calculus I"), (SELECT id FROM days WHERE dayOfWeek = "monday")),

  ((SELECT id FROM courses WHERE name="Linear Algebra"), (SELECT id FROM days WHERE dayOfWeek = "saturday")),

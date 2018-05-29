INSERT INTO courses(name, code, semester, year, startHour, endHour) VALUES
	("Intro to History", 1000, "fall", 2018, "12:30pm", "2:00pm"),
	("Classical Cultures", 2300,"fall", 2018, "12:30pm", "2:00pm"),
	("Intro to Java Programming", 1000, "fall", 2018, "12:45pm", "2:15pm"),
	("Data Structures", 2500, "fall", 2018, "2:45pm", "4:15pm"),
	("Intro to German", 1000, "fall", 2018, "10:00am", "11:15pm");

INSERT INTO courses(name, code, semester, year, startHour, endHour) VALUES
	("Intro to History", 1000, "fall", 2017, "12:30pm", "2:00pm"),
	("Classical Cultures", 2300,"fall", 2017, "12:30pm", "2:00pm"),
	("Intro to Java Programming", 1000, "fall", 2017, "12:45pm", "2:15pm"),
	("Data Structures", 2500, "fall", 2017, "2:45pm", "4:15pm"),
	("Intro to German", 1000, "fall", 2017, "10:00am", "11:15pm");


INSERT INTO coursesJoinStudents(courses_id, students_id) VALUES
	((SELECT id FROM courses WHERE name="Intro to History" AND semester= "fall"), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb")),
	((SELECT id FROM courses WHERE name="Data Structures" AND semester= "fall"), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb")),
	((SELECT id FROM courses WHERE name="Intro to German" AND semester= "fall"), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb"));


INSERT INTO coursesJoinStudents(courses_id, students_id) VALUES
	((SELECT id FROM courses WHERE name="Intro to History" AND semester= "fall" AND year = 2017), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb")),
	((SELECT id FROM courses WHERE name="Data Structures" AND semester= "fall" AND year = 2017), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb")),
	((SELECT id FROM courses WHERE name="Intro to German" AND semester= "fall" AND year = 2017), (SELECT id FROM students WHERE firstName="Mary" AND lastName="Lamb"));


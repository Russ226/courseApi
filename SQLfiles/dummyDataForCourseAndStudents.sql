INSERT INTO courses(name, code, semester, year) VALUES
	("Intro to History", 1000, "spring", 2018),
	("Classical Cultures", 2300,"spring", 2018),
	("Intro to Java Programming", 1000, "spring", 2018),
	("Data Structures", 2500, "spring", 2018),
	("Intro to German", 1000, "spring", 2018),
	("Political Sociology", 3000, "spring", 2018),
	("Object Oriented Programming", 3100, "spring", 2018),
	("Organic Chemistry", 2100, "spring", 2018),
	("Calculus I", 1050, "spring", 2018),
	("Linear Algebra", 2300, "spring", 2018);


INSERT INTO students(firstName, lastName) VALUES
	("Bob", "TheBuilder"),
	("Mary", "Lamb"),
	("Hue", "Jazz"),
	("Richard", "Mann");

INSERT INTO coursesJoinStudents(courses_id, students_id) VALUES
	((SELECT id FROM courses WHERE name="Intro to History"), (SELECT id FROM students WHERE firstName="Bob" AND lastName="TheBuilder")),
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
package com.test.sql;

import com.example.courseapi.CourseapiApplication;
import com.sqlorm.dao.student.StudentDAO;
import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import com.sqlorm.service.course.CourseService;
import com.sqlorm.service.student.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"/context.xml"})
public class TestStudentQuery {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private CourseService courseService;

    @Test
    @Transactional
    public void testSessionFactory(){
        Session session = sessionFactory.getCurrentSession();

        Student student = session.get(Student.class, 2);

        assertNotEquals(student, null);
        assertEquals(student.getFirstName(), "Mary");

    }

    @Test
    @Transactional
    public void testDirectQuerying(){
        Session session = sessionFactory.getCurrentSession();



        Query query = session.createQuery("from Student S where S.firstName = :firstName", Student.class);
        query.setParameter("firstName", "Mary");

        List<Student> students = query.list();

        assertEquals(students.size(), 1);
        assertEquals(students.get(0).getFirstName(), "Mary");

    }

    @Test
    @Transactional
    public void testStudentDAO(){
        List<Student> students = studentDAO.selectByName("Mary", "Lamb");

        assertEquals(students.size(), 1);
        assertEquals(students.get(0).getFirstName(), "Mary");

    }

    @Test
    public void testSelectByName() {
        List<Student> students = studentService.selectByName("Mary", "Lamb");

        assertEquals(students.size(), 1);
        assertEquals(students.get(0).getFirstName(), "Mary");

    }


    @Test
    public void testGetCourses(){
        List<Course> courses = studentService.getStudentCourses("Mary", "Lamb");

        assertEquals(courses.size(), 3);
        assertEquals(courses.get(0).getName(), "Intro to History");
    }

    @Test
    public void TestThisSemestersCourses(){
        List<Course> courses = studentService.getSchedule("Mary", "Lamb", "spring", 2018);

        assertEquals(courses.get(0).getName(), "Intro to History");
        assertEquals( 3, courses.size());

    }

    @Test
    public void TestYearParamFilterWithSemester(){
        List<Course> courses = studentService.getSchedule("Mary", "Lamb", "fall", 2018);

        assertEquals(courses.get(0).getName(), "Intro to History");
        assertEquals( 3, courses.size());

    }

    @Test
    public void TestRegisteringNewStudent(){
        studentService.registerStudent("Zack", "LaPenis");

        List<Student> students = studentService.selectByName("Zack", "LaPenis");

        assertEquals(1, students.size());
        assertEquals("Zack", students.get(0).getFirstName());


    }


    @Test
    public void TestRegisteringNewStudentWithCredits(){
        studentService.registerStudent("Mortie", "Sanchez", 5);

        List<Student> students = studentService.selectByName("Mortie", "Sanchez");

        assertEquals(1, students.size());
        assertEquals("Mortie", students.get(0).getFirstName());
        assertEquals(java.util.Optional.of(5), java.util.Optional.ofNullable(students.get(0).getCredits()));


    }

    @Test
    public void testStudentReigsterForCourse(){
        List<Course> courses = courseService.getCourse("Classical Cultures", 2300,"spring", 2018 );
        studentService.addCourse("Mortie", "Sanchez", courses.get(0));

        List<Course> studentCourses = studentService.getStudentCourses("Mortie", "Sanchez");

        assertEquals(studentCourses.size(), 1);
        assertEquals(studentCourses.get(0).getName(),"Classical Cultures");
    }







}

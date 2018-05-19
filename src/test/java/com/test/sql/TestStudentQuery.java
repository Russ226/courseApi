package com.test.sql;

import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import com.sqlorm.service.student.StudentService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"/context.xml"})
@SpringBootTest
public class TestStudentQuery {
    @Autowired
    private StudentService studentService;

    @Test
    public void testSelectByName(){


        List<Student> students = studentService.getStudentCourses("Mary", "Lamb");

        assertEquals(students.size(), 1);
        assertEquals(students.get(0).getFirstName(), "Mary");
    }
}

package com.test.sql;


import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCourse {
    private SessionFactory sessionFactory;
    private Session session = null;

    @Before
    public void before(){
        sessionFactory= new Configuration().configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        session = sessionFactory.getCurrentSession();
    }

    @Test
    public void testGettingCourses(){
        session.beginTransaction();
        int id = 1;

        Course course = session.get(Course.class, id);

        assertEquals(course.getName(),  "Intro to History");

    }

    @After
    public void after() {
        session.close();
        sessionFactory.close();
    }

}

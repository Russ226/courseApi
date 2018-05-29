package com.sqlorm.dao.student;


import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    // returns all students
    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    // returns student info
    @Override
    public List<Student> selectByName(String firstName, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        List<Student> student;

        String select = "FROM Student S WHERE S.firstName= :firstName  AND S.lastName= :lastName";
        Query query = session.createQuery(select, Student.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        student = query.list();


        return student;
    }

    // returns all courses of student
    @Override
    public List<Course> getStudentCourses(String firstName, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        List<Course> courses;
        List <Student> students;

        String select = "FROM Student S WHERE S.firstName= :firstName  AND S.lastName= :lastName";
        Query query = session.createQuery(select, Student.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);

        students = query.list();
        courses = students.get(0).getCourses();

        return courses;

    }

    @Override
    public List<Course> getScheduler(String firstName, String lastName, String semester, int year) {
        Session session = sessionFactory.getCurrentSession();
        List<Course> courses;
        List <Student> students;

        String select = "FROM Student S WHERE S.firstName= :firstName  AND S.lastName= :lastName";
        Query query = session.createQuery(select, Student.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);


        students = query.list();
        courses = students.get(0).getCourses();
        List<Course> thisSemesterCourses = new ArrayList();

        for(Course course :courses){
            if(course.getSemester() == semester && course.getYear() == year){
                thisSemesterCourses.add(course);
            }
        }


        return thisSemesterCourses;

    }


}

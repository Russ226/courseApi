package com.sqlorm.dao.student;

import com.sqlorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public List<Student> selectByName(String firstName, String lastName) {
        Session session = sessionFactory.getCurrentSession();
        List<Student> student = null;
        try {
            String select = "FROM Student WHERE firstName=" + firstName + " AND lastName=" + lastName;
            Query query = session.createQuery(select, Student.class);
            query.setParameter("firstName", firstName);
            query.setParameter("lastName", lastName);

            student = query.list();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<Student> getStudentCourses(String firstName, String lastName) {
        return null;
    }
}
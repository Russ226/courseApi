package com.sqlorm.dao.course;

import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDAOImpl implements CourseDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> getCourse(String name, int code, String semester, int year) {
        Session session =  sessionFactory.getCurrentSession();
        List<Course> courses;

        String select = "FROM Course C WHERE C.name= :name  AND C.semester= :semester AND C.year = :year AND C.code = :code";
        Query query = session.createQuery(select, Course.class);
        query.setParameter("name", name);
        query.setParameter("semester", semester);
        query.setParameter("year", year);
        query.setParameter("code", code);

        courses = query.list();

        return courses;

    }
}

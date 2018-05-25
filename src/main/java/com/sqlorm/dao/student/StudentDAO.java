package com.sqlorm.dao.student;

import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAllStudents();

    public List<Student> selectByName(String firstName, String lastName);

    public List<Course> getStudentCourses(String firstName, String lastName);



}

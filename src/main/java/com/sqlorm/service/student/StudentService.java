package com.sqlorm.service.student;

import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public List<Student> selectByName(String firstName, String lastName);

    List<Course> getStudentCourses(String firstName, String lastName);



}

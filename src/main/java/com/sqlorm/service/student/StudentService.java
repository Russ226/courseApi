package com.sqlorm.service.student;

import com.sqlorm.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public List<Student> selectByName(String firstName, String lastName);

    public List<Student> getStudentCourses(String firstName, String lastName);

}

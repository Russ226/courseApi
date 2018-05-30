package com.sqlorm.service.student;

import com.sqlorm.dao.student.StudentDAO;
import com.sqlorm.entity.Course;
import com.sqlorm.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;


    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    @Transactional
    public List<Student> selectByName(String firstName, String lastName) {
        return studentDAO.selectByName(firstName, lastName);
    }

    @Override
    @Transactional
    public List<Course> getStudentCourses(String firstName, String lastName) {
        return studentDAO.getStudentCourses(firstName, lastName);
    }
    @Override
    @Transactional
    public List<Course> getSchedule(String firstName, String lastName, String semester, int year){
        return studentDAO.getSchedule(firstName, lastName,semester,year);
    }

    @Override
    @Transactional
    public void registerStudent(String firstName, String lastName, int credits){
        studentDAO.registerStudent(firstName, lastName, credits);
    }

    @Override
    @Transactional
    public void registerStudent(String firstName, String lastName){
        studentDAO.registerStudent(firstName, lastName, 0);
    }

    @Override
    @Transactional
    public void addCourse(String firstName, String lastName, Course course) {
        studentDAO.addCourse(firstName, lastName, course);
    }


}

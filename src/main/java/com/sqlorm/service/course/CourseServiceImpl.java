package com.sqlorm.service.course;

import com.sqlorm.dao.course.CourseDAO;
import com.sqlorm.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDAO courseDAO;

    @Override
    @Transactional
    public List<Course> getCourse(String name, int code, String semester, int year) {
        return courseDAO.getCourse(name, code, semester, year);
    }
}

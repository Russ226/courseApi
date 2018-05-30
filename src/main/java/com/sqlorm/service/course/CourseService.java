package com.sqlorm.service.course;


import com.sqlorm.entity.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourse(String name, int code, String semester, int year);
}

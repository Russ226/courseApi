package com.sqlorm.dao.course;

import com.sqlorm.entity.Course;

import java.util.List;

public interface CourseDAO {

    public List<Course> getCourse(String name, int code, String semester, int year);

}

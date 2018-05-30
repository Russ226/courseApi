package com.test.sql;

import com.sqlorm.entity.Course;
import com.sqlorm.service.course.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"/context.xml"})
public class TestCourseQuery {

    @Autowired
    CourseService courseService;

    @Test
    public void testGetCourse(){
        List<Course> courses = courseService.getCourse("Classical Cultures", 2300,"spring", 2018 );

        assertEquals(1, courses.size());
        assertEquals("Classical Cultures", courses.get(0).getName());
    }
}

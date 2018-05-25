package com.sqlorm.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "days")
public class Day {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name= "dayOfWeek")
    private String days;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "daysCoursesJoin",
            joinColumns=@JoinColumn(name="dayss_id"),
            inverseJoinColumns=@JoinColumn(name="courses_id"))
    private List<Course> Courses;

    public Day(){

    }

    public Day(String days) {
        this.days = days;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public List<Course> getCourses() {
        return Courses;
    }

    public void setCourses(List<Course> courses) {
        Courses = courses;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id=" + id +
                ", days='" + days + '\'' +
                ", Courses=" + Courses +
                '}';
    }
}

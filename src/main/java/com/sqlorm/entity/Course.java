package com.sqlorm.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "code")
    @NotNull
    private int code;

    @Column(name = "semester")
    @NotNull
    private String semester;

    @Column(name = "year")
    @NotNull
    private int year;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "coursesJoinStudents",
            joinColumns=@JoinColumn(name="courses_id"),
            inverseJoinColumns=@JoinColumn(name="students_id"))
    private List<Student> students;

    Course(){

    }

    public Course(String name, int code, String semester, int year) {
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", students=" + students +
                '}';
    }
}

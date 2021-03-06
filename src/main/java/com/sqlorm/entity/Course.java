package com.sqlorm.entity;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

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
import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@FilterDef(name="semester", parameters={@ParamDef( name="semester", type="string" )})
@FilterDef(name="year", parameters={@ParamDef( name="year", type="integer" )})
public class Course{


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

    @Column(name= "startHour")
    private String startHour;

    @Column(name= "endHour")
    private String endHour;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "coursesJoinStudents",
            joinColumns=@JoinColumn(name="courses_id"),
            inverseJoinColumns=@JoinColumn(name="students_id"))
    private List<Student> students;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "daysCoursesJoin",
            joinColumns=@JoinColumn(name="courses_id"),
            inverseJoinColumns=@JoinColumn(name="days_id"))
    private List<Day> Days;

    Course(){

    }

    public Course(String name, int code, String semester, int year, String startHour, String endHour) {
        this.name = name;
        this.code = code;
        this.semester = semester;
        this.year = year;
        this.startHour = startHour;
        this.endHour = endHour;
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

    public List<Day> getDays() {
        return Days;
    }

    public void setDays(List<Day> days) {
        Days = days;
    }


    public String getStartHour() {
        return startHour;
    }

    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    private int timeCompare(String time) throws ParseException {
        DateFormat format = new SimpleDateFormat("HH:mm aa");

        Date d1 = format.parse(this.startHour);
        Date d2 = format.parse(time);
        if(d1.before(d2)){
            return 0;
        }if(d1.after(d2)){
            return 1;
        }if(d1.equals(d2)){
            return 2;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                ", startHour='" + startHour + '\'' +
                ", endHour='" + endHour + '\'' +
                ", students=" + students +
                ", Days=" + Days +
                '}';
    }


}

package com.company.SimpleWebApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_ID")
    private Integer id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "courses")
    List<Student> students;

    public Course() {
    }

    public Course(Integer id, String name, String description, List<Student> students) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

package com.example.demo.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "classes")
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "teacher_name")
    private String teacherName;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_At")
    private Timestamp updated_At;

    @Column(name = "teacher_id")
    private int teacherID;

    public int getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Timestamp getUpdated_At() {
        return updated_At;
    }

    // getters and setters
}
package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @Column(name = "subject_id")
    private int id;

    @Column(name = "subject_code")
    private String subject_code;

    @Column(name = "subject_name")
    private String subject_name;

    @Column(name = "teacher_id")
    private int teacherId;

    @Column(name = "class_name")
    private String class_name;

    @Column(name = "category")
    private String category;

    public String getClass_name() {
        return class_name;
    }

    public int getSubject_id() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public int getTeacherId() {
        return teacherId;
    }
}

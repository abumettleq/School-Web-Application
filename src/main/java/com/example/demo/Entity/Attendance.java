package com.example.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_name")
    private String className;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "state")
    private char state;


    public int getId() {
        return id;
    }

    public char getState() {
        return state;
    }

    public int getClassId() {
        return classId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getDate() {
        return date.getYear()+"-"+date.getMonth()+"-"+date.getDayOfMonth()+" "+date.getHour()+":"+date.getMinute();
    }

    public String getClassName() {
        return className;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(char state) {
        this.state = state;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}

package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "result_id")
    private int resultId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "subject_code")
    private String subject_code;

    @Column(name = "class_id")
    private int classId;

    @Column(name = "class_num")
    private int class_num;

    @Column(name = "quiz1")
    private float quiz1;

    @Column(name = "quiz2")
    private float quiz2;

    @Column(name = "quiz3")
    private float quiz3;

    @Column(name = "quiz4")
    private float quiz4;

    @Column(name = "midterm")
    private float midterm;

    @Column(name = "finalterm")
    private float finalterm;

    public int getClass_num() {
        return class_num;
    }

    public String getSubject_code() {
        return subject_code;
    }

    public float getFinalterm() {
        return finalterm;
    }

    public float getMidterm() {
        return midterm;
    }

    public float getQuiz1() {
        return quiz1;
    }

    public float getQuiz2() {
        return quiz2;
    }

    public float getQuiz3() {
        return quiz3;
    }

    public int getResult_id() {
        return resultId;
    }

    public float getQuiz4() {
        return quiz4;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setClass_num(int class_num) {
        this.class_num = class_num;
    }

    public void setFinalterm(float finalterm) {
        this.finalterm = finalterm;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public void setQuiz1(float quiz1) {
        this.quiz1 = quiz1;
    }

    public void setQuiz2(float quiz2) {
        this.quiz2 = quiz2;
    }

    public void setQuiz3(float quiz3) {
        this.quiz3 = quiz3;
    }
    public void setQuiz4(float quiz4) {
        this.quiz4 = quiz4;
    }

    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }
}

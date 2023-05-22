package com.example.demo.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.TypeAlias;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "place_of_birth", nullable = false)
    private String placeOfBirth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "parent_guardian_name", nullable = false)
    private String parentGuardianName;

    @Column(name = "parent_guardian_phone_number", nullable = false)
    private String parentGuardianPhoneNumber;

    @Column(name = "class_id")
    private int classID;

    @Column(name = "class")
    private String class_name;

    @Column(name="section")
    private String section;

    @Column(name = "admission_date", nullable = false)
    private LocalDate admissionDate;

    @Column(name = "graduation_date")
    private LocalDate graduationDate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "uid", nullable = false)
    private int uid;

    @Column(name="img_url")
    private String img_url;

    // constructors, getters and setters, toString method


    public String getImg_url() {
        return img_url;
    }

    public int getClassID() {
        return classID;
    }

    public Gender getGender() {
        return gender;
    }

    public int getId() {
        return id;
    }

    public int getUid() {
        return uid;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getSection() {
        return section;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getParentGuardianName() {
        return parentGuardianName;
    }

    public String getParentGuardianPhoneNumber() {
        return parentGuardianPhoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }
}

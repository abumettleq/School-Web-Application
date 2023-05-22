package com.example.demo.Repository;

import com.example.demo.Entity.News;
import com.example.demo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUid(int uid);
    List<Student> findByClassID(int class_id);
}
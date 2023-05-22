package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentByUid(int uid) {
        return studentRepository.findByUid(uid);
    }

    public List<Student> getAllStudentsByClassId(int class_id)
    {
        return studentRepository.findByClassID(class_id);
    }
}

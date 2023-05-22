package com.example.demo.Service;

import com.example.demo.Entity.Teacher;
import com.example.demo.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher getTeacherByUid(int uid)
    {
        return teacherRepository.findByUid(uid);
    }
}

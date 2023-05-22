package com.example.demo.Service;

import com.example.demo.Entity.Subject;
import com.example.demo.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getSubjectByTeacherId(int teacher_id)
    {
       return subjectRepository.findByTeacherId(teacher_id);
    }
}

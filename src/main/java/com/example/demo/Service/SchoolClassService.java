package com.example.demo.Service;

import com.example.demo.Entity.SchoolClass;
import com.example.demo.Repository.SchoolClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {
    @Autowired
    SchoolClassRepository schoolClassRepository;

    public List<SchoolClass> getAllClassesByTeacherId(int teacher_id)
    {
        return schoolClassRepository.findByTeacherID(teacher_id);
    }

    public SchoolClass getClassById(int classId)
    {
        return schoolClassRepository.findById(classId);
    }
}

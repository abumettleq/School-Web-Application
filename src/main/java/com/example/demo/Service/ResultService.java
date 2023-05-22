package com.example.demo.Service;

import com.example.demo.Entity.Result;
import com.example.demo.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getResultsByStudentId(int student_id)
    {
        return resultRepository.findByStudentId(student_id);
    }

    public Result getResultByStudentIdAndClassId(int studentId, int classId)
    {
        return resultRepository.findByStudentIdAndClassId(studentId,classId);
    }

    public void submitResult(Result result)
    {
        resultRepository.save(result);
    }
}

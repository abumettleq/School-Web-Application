package com.example.demo.Repository;

import com.example.demo.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {
    List<Result> findByStudentId(int student_id);

    Result findByStudentIdAndClassId(int studentId, int classId);
}

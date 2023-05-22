package com.example.demo.Repository;

import com.example.demo.Entity.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, List> {
    List<SchoolClass> findByTeacherID(int teacher_id);

    SchoolClass findById(int classId);
}

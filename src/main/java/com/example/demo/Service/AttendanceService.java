package com.example.demo.Service;

import com.example.demo.Entity.Attendance;
import com.example.demo.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceListByStudentId(int studentId)
    {
        List<Attendance> attendanceList = attendanceRepository.findByStudentId(studentId);
        return attendanceList;
    }

    public void insertIntoAttendance(Attendance attendance)
    {
        attendanceRepository.save(attendance);
    }

}

package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sms")
public class SmsController {
    @Autowired
    UserService userService;

    @Autowired
    SchoolClassService schoolClassService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    AttendanceService attendanceService;

    @Autowired
    NotificationService notificationService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ResultService resultService;

    @RequestMapping("logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes)
    {
        session.removeAttribute("user_id");
        session.removeAttribute("user_type");
        session.invalidate();
        redirectAttributes.addFlashAttribute("message", "You have successfully logged out.");
        return "redirect:/login";
    }

    @RequestMapping("")
    public String redirectToSmsHome() {
        return "redirect:sms/home";
    }

    @RequestMapping("/")
    public String emptySMS() {
        return "home";
    }

    @RequestMapping("home")
    public String sms_home() {
        return "home";
    }

    @RequestMapping("my-profile")
    public String sms_profile()
    {
        return "profile";
    }

    @RequestMapping("my-settings")
    public String sms_settings()
    {
        return "settings";
    }

    @RequestMapping("class-attendance")
    public String sms_attendance(HttpSession session, Model model) throws JsonProcessingException {
        Teacher teacher = (Teacher) session.getAttribute("userObject");
        List<SchoolClass> classList = schoolClassService.getAllClassesByTeacherId(teacher.getId());
        model.addAttribute("classList", classList);

        Map<Integer,List<List<Student>>> studentListMap = new HashMap<>();
        for(SchoolClass thisClass : classList)
        {
            int classID = thisClass.getId();

            if (!studentListMap.containsKey(classID)) {
                studentListMap.put(classID, new ArrayList<>());
            }

            studentListMap.get(classID).add(studentService.getAllStudentsByClassId(classID));
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String jsonList = mapper.writeValueAsString(studentListMap);

        model.addAttribute("studentByClass", jsonList);

        return "attendance";
    }

    @RequestMapping("upload-results")
    public String sms_upload_results(HttpSession session, Model model) throws JsonProcessingException {
        Teacher teacher = (Teacher) session.getAttribute("userObject");
        List<SchoolClass> classList = schoolClassService.getAllClassesByTeacherId(teacher.getId());
        model.addAttribute("classList", classList);

        Map<Integer,List<List<Student>>> studentListMap = new HashMap<>();
        for(SchoolClass thisClass : classList)
        {
            int classID = thisClass.getId();

            if (!studentListMap.containsKey(classID)) {
                studentListMap.put(classID, new ArrayList<>());
            }

            studentListMap.get(classID).add(studentService.getAllStudentsByClassId(classID));
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String jsonList = mapper.writeValueAsString(studentListMap);

        model.addAttribute("studentByClass", jsonList);

        return "results";
    }

    @RequestMapping("submit-result")
    public String sms_submit_result(@Param("classId") int classId, @Param("studentId") int studentId,@Param("quiz1") String quiz1,@Param("quiz2") String quiz2,
                                    @Param("quiz3") String quiz3, @Param("quiz4") String quiz4, @Param("midterm") String midterm, @Param("finalterm") String finalterm,
                                    @Param("userId") int userId, HttpSession session, Model model)
    {
        Teacher teacher = teacherService.getTeacherByUid(userId);
        Result result = resultService.getResultByStudentIdAndClassId(studentId,classId);

        if(result == null)
        {
            SchoolClass schoolClass = schoolClassService.getClassById(classId);
            result = new Result();
            result.setStudentId(studentId);
            result.setClassId(classId);
            result.setClass_num(Integer.parseInt(schoolClass.getClassName()));
            result.setSubject_code(subjectService.getSubjectByTeacherId(teacher.getId()).get(0).getSubject_code());
        }

        if(!quiz1.equals(""))
        {
            result.setQuiz1(Integer.parseInt(quiz1));
        }
        if(!quiz2.equals(""))
        {
            result.setQuiz2(Integer.parseInt(quiz2));
        }
        if(!quiz3.equals(""))
        {
            result.setQuiz3(Integer.parseInt(quiz3));
        }
        if(!quiz4.equals(""))
        {
            result.setQuiz4(Integer.parseInt(quiz4));
        }
        if(!midterm.equals(""))
        {
            result.setMidterm(Integer.parseInt(midterm));
        }
        if(!finalterm.equals(""))
        {
            result.setFinalterm(Integer.parseInt(finalterm));
        }

        resultService.submitResult(result);
        model.addAttribute("success", " Result submitted successfully");

        notificationService.insertNewNotification(teacher.getFirstName()+" "+teacher.getLastName(), studentId, LocalTime.now(), LocalDate.now(), "New result of subject '"+ result.getSubject_code() +"' has been added, go check it.");

        return "results";
    }

    @PostMapping("submit-attendance")
    public String sms_submitAttendance(@RequestParam Map<String, String> params, HttpSession session, Model model)
    {
        Map.Entry<String, String> firstEntry = params.entrySet().iterator().next();
        int classId = Integer.parseInt(firstEntry.getValue());

        Teacher teacher = (Teacher) session.getAttribute("userObject");
        List<Subject> thisSubject = subjectService.getSubjectByTeacherId(teacher.getId());
        SchoolClass thisClass = schoolClassService.getClassById(classId);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String paramName = entry.getKey();
            String paramValue = entry.getValue();

            if (paramName.startsWith("status_"))
            {
                Attendance attendance = new Attendance();

                int studentId = Integer.parseInt(paramName.substring("status_".length()));
                char attendanceStatus = paramValue.charAt(0);

                attendance.setClassId(classId);
                attendance.setDate(LocalDateTime.now());
                attendance.setState(attendanceStatus);
                attendance.setStudentId(studentId);

                attendance.setSubjectName(thisSubject.get(0).getSubject_code());
                attendance.setSubjectId(thisSubject.get(0).getSubject_id());
                attendance.setClassName(thisClass.getClassName()+"-"+thisClass.getSectionName());

                attendanceService.insertIntoAttendance(attendance);
                notificationService.insertNewNotification(teacher.getFirstName()+" "+teacher.getLastName(), studentId, LocalTime.now(), LocalDate.now(), "Attendance of class \'"+thisSubject.get(0).getSubject_code()+"\' has been given.");
            }
        }

        model.addAttribute("success", "Attendance list submitted successfully.");
        return "attendance";
    }

    @PostMapping("change-password")
    public String sis_changePassword(@Param("old_password") String old_password, @Param("new_password") String new_password, @Param("confirm_password") String confirm_password, HttpSession session, Model model) {
        if (new_password.equals(confirm_password)) {
            User user = userService.findById((int) session.getAttribute("user_id"));
            if (old_password.equals(user.getPassword())) {
                if (old_password.equals(new_password)) {
                    model.addAttribute("error", " New password cannot be set to current password.");
                    return "settings";
                }

                boolean success = userService.setNewPassword(user.getId(), new_password);
                if (success) {
                    //notificationService.insertNewNotification("SYSTEM", teacherService.getTeacherByUid(user.getId()).getId(), LocalTime.now(), LocalDate.now(), "Your password has been changed.");
                    model.addAttribute("success", " Password has been successfully updated.");
                } else {
                    model.addAttribute("error", " Internal error, please report.");
                }
            } else {
                model.addAttribute("error", " Current password is incorrect.");
            }
        } else {
            model.addAttribute("error", " New password mismatches the confirmation of the new password, please try again.");
        }
        return "settings";
    }



}

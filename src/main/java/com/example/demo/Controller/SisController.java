package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sis")
public class SisController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResultService resultService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    StudentService studentService;

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
    public String redirectToSisHome() {
        return "redirect:sis/home";
    }

    @RequestMapping("/")
    public String emptySIS() {
        return "home";
    }

    @RequestMapping("home")
    public String sis_home(HttpSession session, Model model)
    {
        Student student = (Student) session.getAttribute("userObject");
        List<Notification> studentNotification = notificationService.getNotificationsByStudentId(student.getId());
        model.addAttribute("studentNotifications", studentNotification);
        return "home";
    }

    @RequestMapping("my-profile")
    public String sis_profile()
    {
        return "profile";
    }

    @RequestMapping("my-settings")
    public String sis_settings()
    {
        return "settings";
    }

    @RequestMapping("my-results")
    public String sis_results(HttpSession session, Model model)
    {
        Student student = (Student) session.getAttribute("userObject");
        List<Result> results = resultService.getResultsByStudentId(student.getId());

        Map<Integer, List<Result>> resultsMap = new HashMap<>();
        for (Result result : results) {
            int classNum = result.getClass_num();
            if (!resultsMap.containsKey(classNum)) {
                resultsMap.put(classNum, new ArrayList<>());
            }
            resultsMap.get(classNum).add(result);
        }


        model.addAttribute("resultsMap", resultsMap);
        return "results";
    }

    @RequestMapping("my-attendance")
    public String sis_attendance(HttpSession session, Model model)
    {
        Student student = (Student) session.getAttribute("userObject");
        List<Attendance> attendanceList = attendanceService.getAttendanceListByStudentId(student.getId());

        Map<String, Map<String, List<Attendance>>> attendanceMap = new HashMap<>();
        for (Attendance attendance : attendanceList) {
            String subjectName = attendance.getSubjectName();
            String classNumber = attendance.getClassName();
            if (!attendanceMap.containsKey(classNumber)) {
                attendanceMap.put(classNumber, new HashMap<>());
            }
            if (!attendanceMap.get(classNumber).containsKey(subjectName)) {
                attendanceMap.get(classNumber).put(subjectName, new ArrayList<>());
            }
            attendanceMap.get(classNumber).get(subjectName).add(attendance);
        }



        model.addAttribute("attendanceMap", attendanceMap);
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
                    notificationService.insertNewNotification("SYSTEM", studentService.getStudentByUid(user.getId()).getId(), LocalTime.now(), LocalDate.now(), "Your password has been changed.");
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
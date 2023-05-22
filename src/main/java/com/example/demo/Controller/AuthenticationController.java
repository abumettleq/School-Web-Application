package com.example.demo.Controller;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.Teacher;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserType;
import com.example.demo.Service.StudentService;
import com.example.demo.Service.TeacherService;
import com.example.demo.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.Serializable;

@Controller
@RequestMapping("authenticate")
public class AuthenticationController {
    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public String authenticate(@Param("username") String username, @Param("password") String password, HttpSession session, RedirectAttributes model)
    {
        User user = userService.findUserByUsernameAndPassword(username,password);
        if(user != null)
        {
            session.setAttribute("user_id", user.getId()); // used for authentication filtering
            session.setAttribute("user_type", user.getUserType());
            if(user.getUserType() == UserType.Student)
            {
                Student student = studentService.getStudentByUid(user.getId());
                if(student != null)
                {
                    session.setAttribute("userObject", student);
                    return "redirect:/sis/home";
                }
                else
                {
                    model.addFlashAttribute("error", "Could not find student information.");
                    return "redirect:/login";
                }
            }
            else if(user.getUserType() == UserType.Teacher)
            {
                Teacher teacher = teacherService.getTeacherByUid(user.getId());
                if(teacher != null)
                {
                    session.setAttribute("userObject", teacher);
                    return "redirect:/sms/home";
                }
                else
                {
                    model.addFlashAttribute("error", "Could not find teacher information.");
                    return "redirect:/login";
                }
            }
            else if(user.getUserType() == UserType.Admin)
            {
                // TODO: admin session
                return "redirect:/admin/panel";
            }
            else return "error";
        }
        else
        {
            model.addFlashAttribute("error", "Invalid username or password. ");
            return "redirect:/login";
        }
    }
}

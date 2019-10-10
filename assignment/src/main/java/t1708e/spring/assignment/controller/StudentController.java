package t1708e.spring.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import t1708e.spring.assignment.entity.Clazz;
import t1708e.spring.assignment.entity.Student;
import t1708e.spring.assignment.repository.ClazzRepository;
import t1708e.spring.assignment.repository.StudentRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClazzRepository clazzRepository;

    @GetMapping
    public String details(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentLoginUserEmail = authentication.getName();
        Student loggedInUser = studentRepository.findByEmail(currentLoginUserEmail).orElse(null);
        List<Clazz> clazzes = clazzRepository.findAll();

        model.addAttribute("student", loggedInUser);
        model.addAttribute("clazzes", clazzes);
        return "student-detail";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model){
        Student newStudent = new Student();
        model.addAttribute("student",newStudent);
        return "register-form";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "register-form";
        }
        String oldPass = student.getPassword();
        student.setPassword(passwordEncoder.encode(oldPass));
        studentRepository.save(student);
        return "redirect:/";
    }
}

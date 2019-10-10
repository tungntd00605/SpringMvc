package t1708e.spring.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import t1708e.spring.assignment.entity.Clazz;
import t1708e.spring.assignment.entity.Student;
import t1708e.spring.assignment.repository.ClazzRepository;
import t1708e.spring.assignment.repository.StudentRepository;

import java.util.List;

@Controller
@RequestMapping("/class")
public class ClazzController {
    @Autowired
    ClazzRepository clazzRepository;
    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public String list(Model model){
        List<Clazz> clazzes = clazzRepository.findAll();
        model.addAttribute("clazzes", clazzes);
        return "clazz-list";
    }

    @GetMapping(value = "/{id}")
    public String list(@PathVariable int id, Model model){
        Clazz clazz = clazzRepository.findById(id).orElse(null);
        List<Student> students = studentRepository.findAll();
        if(clazz == null){
            return "redirect:/class";
        }
        model.addAttribute("clazz", clazz);
        model.addAttribute("students", students);

        return "clazz-detail";
    }

    @PostMapping(value = "/{id}")
    public String update(@PathVariable int id, @RequestParam(value = "student") int[] student){
        Clazz clazz = clazzRepository.findById(id).orElse(null);
        for (int sid: student
             ) {
            Student student1 = studentRepository.findById(sid).orElse(null);
            clazz.addStudent(student1);
        }
        clazzRepository.save(clazz);
        return "redirect:/class";
    }
}

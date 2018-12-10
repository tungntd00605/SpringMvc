package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import test.model.Department;
import test.model.Employee;
import test.service.DepartmentService;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/saveDep", method = RequestMethod.POST)
    public ModelAndView addEmployee(@ModelAttribute Department department){
        departmentService.addDepartment(department);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/addDep")
    public String addDepartmentForm(Model model){
        model.addAttribute("department", new Department());
        return "addDep";
    }
}

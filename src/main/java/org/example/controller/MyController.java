package org.example.controller;

import org.example.dao.Employee;
import org.example.service.EmployeeServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class MyController {
    @Autowired
    EmployeeServiceImpl employeeService;
    @RequestMapping("/")
    public String showMainPage(Model model){
        model.addAttribute("AttributeEmployees", employeeService.getAllEmployee());
        return "index";
    }
    @RequestMapping("/addNewEmployee")
    public String showFormAddNewEmployee(Model model){
        model.addAttribute("employee", new Employee());

        return "addNewEmployee";
    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
                               BindingResult bindingResult){
        employeeService.addEmployee(employee);
        if(bindingResult.hasErrors()){
            return "redirect: /addNewEmployee";
        }else {
            return "redirect:/";
        }
    }
    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){
        model.addAttribute("viewTest", id);
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "addNewEmployee";
    }
}

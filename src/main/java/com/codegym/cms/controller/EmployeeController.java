package com.codegym.cms.controller;

import com.codegym.cms.model.Department;
import com.codegym.cms.model.Employee;
import com.codegym.cms.service.EmployeeService;
import com.codegym.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("department")
    public Iterable<Department>provinces(){
        return departmentService.findAll();
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView saveCustomer(@ModelAttribute("employee") Employee customer){
        employeeService.save(customer);

        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New employeecreated successfully");
        return modelAndView;
    }

    @GetMapping("/employee")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s,@PageableDefault(value = 3) Pageable pageable){
        Page<Employee> employee;
        if(s.isPresent()){
            employee = employeeService.findAllByNameDeparment(s.get(), pageable);
        } else {
            employee = employeeService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Employee customer = employeeService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employee", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-employee")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Employee customer){
        employeeService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee", customer);
        modelAndView.addObject("message", "Employee updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-employee/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Employee customer = employeeService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("/employee/delete");
            modelAndView.addObject("employee", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-employee")
    public String deleteCustomer(@ModelAttribute("employee") Employee employee){
        employeeService.remove(employee.getId());
        return "redirect:employee";
    }
}
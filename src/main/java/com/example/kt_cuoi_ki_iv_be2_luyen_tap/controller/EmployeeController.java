package com.example.kt_cuoi_ki_iv_be2_luyen_tap.controller;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Employee;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml.DepartmentService;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("departments")
    public Iterable<Department> departments() {
        return departmentService.findAll();
    }

    @GetMapping("/view")
    public ModelAndView getAllEmployee() {
        ModelAndView modelAndView = new ModelAndView("view-employee");
        Iterable<Employee> employees = employeeService.findAll();
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

//    @GetMapping("/view/asc")
//    public ModelAndView getAllEmployeeAsc() {
//        ModelAndView modelAndView = new ModelAndView("view-employee");
//        Iterable<Employee> employees = employeeService.findAllByAgeOrderByAgeAsc();
//        modelAndView.addObject("employees", employees);
//        return modelAndView;
//    }


    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("create-employee");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @GetMapping("/update/{idEmployee}")
    public ModelAndView showFormUpdate(@PathVariable String idEmployee) {
        Optional<Employee> employeeOptional = employeeService.findById(idEmployee);
        if (employeeOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/update-employee");
            modelAndView.addObject("employee", employeeOptional.get());
            return modelAndView;
        } else {
            return new ModelAndView("/create-employee");
        }
    }

    @PostMapping("/save")
    public ModelAndView saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/create-employee");
        try {
            if (!bindingResult.hasFieldErrors()) {
                employeeService.save(employee);
                modelAndView.setViewName("/view-employee");
                modelAndView.addObject("message", "Save employee successfully");
                Iterable<Employee> employees = employeeService.findAll();
                modelAndView.addObject("employees", employees);
            }
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("/error-404");
        }
        return modelAndView;

    }
//
    @GetMapping("/delete/{idEmployee}")
    public ModelAndView deleteEmployee(@PathVariable String idEmployee) {
        ModelAndView modelAndView = new ModelAndView("/view-employee");
        try {
            employeeService.remove(idEmployee);
            modelAndView.addObject("message", "Delete employee successfully");
            Iterable<Employee> employees = employeeService.findAll();
            modelAndView.addObject("employees", employees);
        } catch (Exception e) {
            modelAndView.setViewName("/error-404");
        }
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName( @ModelAttribute("name") String name) {
        ModelAndView modelAndView = new ModelAndView("/view-employee");
        Iterable<Employee> employees;
        if (name.equals("")) {
            employees = employeeService.findAll();
        } else {
            employees = employeeService.findByName(name);
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }
}

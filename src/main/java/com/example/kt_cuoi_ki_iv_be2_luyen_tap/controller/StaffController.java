package com.example.kt_cuoi_ki_iv_be2_luyen_tap.controller;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Staff;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml.DepartmentService;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;

    @ModelAttribute("departments")
    public Iterable<Department> departments() {
        return departmentService.findAll();
    }

    @GetMapping("/view")
    public ModelAndView getAllStudents(@PageableDefault(5) Pageable pageable) {
        Page<Staff> staffPage =  staffService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/view-staff");
        modelAndView.addObject("staffPage", staffPage);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create-staff");
        modelAndView.addObject("staff", new Staff());
        return modelAndView;
    }

    @GetMapping("/update/{idStaff}")
    public ModelAndView showFormUpdate(@PathVariable Long idStaff) {
        Optional<Staff> staff = staffService.findById(idStaff);
        if (staff.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/update-staff");
            modelAndView.addObject("staff", staff.get());
            return modelAndView;
        } else {
            return new ModelAndView("/create-staff");
        }
    }

    @PostMapping("/save")
    public ModelAndView saveStaff(@PageableDefault(5) Pageable pageable, @Validated @ModelAttribute("staff") Staff staff, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("/create-staff");
        if (!bindingResult.hasFieldErrors()) {
            staffService.save(staff);
            modelAndView.setViewName("/view-staff");
            redirectAttributes.addFlashAttribute("message", "Create new staff successfully");
            Page<Staff> staffPage =  staffService.findAll(pageable);
            modelAndView.addObject("staffPage", staffPage);
        }
        return modelAndView;
    }

    @GetMapping("/delete/{idStaff}")
    public ModelAndView deleteStaff(@PathVariable Long idStaff, @PageableDefault(5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/view-staff");
        try {
            staffService.remove(idStaff);
            Page<Staff> staffPage =  staffService.findAll(pageable);
            modelAndView.addObject("staffPage", staffPage);
        } catch (Exception e) {
            modelAndView.setViewName("/error-404");
        }
        return modelAndView;
    }

    @GetMapping("/findByFullName")
    public ModelAndView findByName( @ModelAttribute("name") String name, @PageableDefault(5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/view-staff");
        Page<Staff> staffPage;
        if (name.equals("")) {
            staffPage = staffService.findAll(pageable);
        } else {
            staffPage = staffService.findStaffByName(pageable, name);
        }
        modelAndView.addObject("staffPage", staffPage);
        return modelAndView;
    }
}

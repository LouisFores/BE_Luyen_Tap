package com.example.kt_cuoi_ki_iv_be2.controller;

import com.example.kt_cuoi_ki_iv_be2.model.People;
import com.example.kt_cuoi_ki_iv_be2.model.Product;
import com.example.kt_cuoi_ki_iv_be2.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/peoples")
public class PeopleController {
    @Autowired
    private IPeopleService peopleService;
//    @GetMapping("/view")
//    public ModelAndView showHome() {
//        ModelAndView modelAndView = new ModelAndView("/view-people");
//        modelAndView.addObject("peopleList", peopleService.findAll());
//        return modelAndView;
//    }

    @GetMapping("/view")
    public ModelAndView getAllStudents(@PageableDefault(5) Pageable pageable) {
        Page<People> list =  peopleService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/view-people");
        modelAndView.addObject("peopleList", list);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        ModelAndView modelAndView = new ModelAndView("/create-people");
        modelAndView.addObject("people", new People());
        return modelAndView;
    }

    @GetMapping("/update/{idPeople}")
    public ModelAndView showFormUpdate(@PathVariable Long idPeople) {
        Optional<People> people = peopleService.findById(idPeople);
        if (people.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/update-people");
            modelAndView.addObject("people", people.get());
            return modelAndView;
        } else {
            return new ModelAndView("/create-people");
        }
    }

    @PostMapping("/save")
    public ModelAndView savePeople( @PageableDefault(5) Pageable pageable, @Validated @ModelAttribute("people") People people, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("/create-people");
        if (!bindingResult.hasFieldErrors()) {
            peopleService.save(people);
            modelAndView.setViewName("/view-people");
            redirectAttributes.addFlashAttribute("message", "Create new people successfully");
            Page<People> peopleList =  peopleService.findAll(pageable);
            modelAndView.addObject("peopleList", peopleList);
        }
        return modelAndView;
    }

    @GetMapping("/delete/{idPeople}")
    public ModelAndView deletePeople(@PathVariable Long idPeople) {
        ModelAndView modelAndView = new ModelAndView("/view-people");
        try {
            peopleService.remove(idPeople);
            modelAndView.addObject("peopleList", peopleService.findAll());
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("/error-404");
            return modelAndView;
        }

    }

    @GetMapping("/findByFullName")
    public ModelAndView findByName(@ModelAttribute("name") String name) {
        ModelAndView modelAndView = new ModelAndView("/view-people");
        modelAndView.addObject("peopleList", peopleService.finAllByFullName(name));
        return modelAndView;
    }
}

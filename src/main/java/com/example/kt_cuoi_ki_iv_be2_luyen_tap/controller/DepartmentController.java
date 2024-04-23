package com.example.kt_cuoi_ki_iv_be2_luyen_tap.controller;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    public DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Iterable<Department>> findAllDepartment() {
        List<Department> departments = (List<Department>) departmentService.findAll();
        if (departments.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveDepartment(@Valid @RequestBody Department department, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            StringBuilder builder = new StringBuilder();
            for (FieldError error : fieldErrorList) {
                builder.append(error.getDefaultMessage()).append("\n");
            }
            return new ResponseEntity<>(builder.toString(), HttpStatus.CREATED);
        }
        departmentService.save(department);
        return new ResponseEntity<>("Create success", HttpStatus.CREATED);
    }

    @PutMapping("/{idDepartment}")
    public ResponseEntity<Department> updateDepartment(@PathVariable Long idDepartment, @RequestBody Department department) {
        Optional<Department> departmentOptional = departmentService.findById(idDepartment);
        if (!departmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        department.setIdDepartment(departmentOptional.get().getIdDepartment());
        return new ResponseEntity<>(departmentService.save(department), HttpStatus.OK);
    }

    @DeleteMapping("/{idDepartment}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long idDepartment) {
        Optional<Department> departmentOptional = departmentService.findById(idDepartment);
        if (!departmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departmentService.remove(idDepartment);
        return new ResponseEntity<>("Giá trị đã xoá thành công", HttpStatus.OK);
    }

    @GetMapping("/search-name")
    public ResponseEntity<Iterable<Department>> findDepartmentByName(@RequestParam("nameDepartment") String nameDepartment){
        Iterable<Department> departments = departmentService.finDepartmentByName(nameDepartment);
        if (!departments.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
}

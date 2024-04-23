package com.example.kt_cuoi_ki_iv_be2_luyen_tap.controller;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Employee;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.EmployeeDTO;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml.DepartmentService;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeControllerAPI {
    @Autowired
    public EmployeeService employeeService;
    @Autowired
    public DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAllEmployee() {
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

//    @GetMapping("/asc")
//    public ResponseEntity<Iterable<Employee>> findAllEmployeeAsc() {
//        List<Employee> employees = (List<Employee>) employeeService.findAllByAgeOrderByAgeAsc();
//        if (employees.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(employees, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult bindingResult) {
        Department department = departmentService.findById(employeeDTO.getIdDepartment()).get();
        Employee employee = new Employee(employeeDTO.getIdEmployee(), employeeDTO.getName(), employeeDTO.getAge(),
                employeeDTO.getSalary(), department);
        employeeService.save(employee);
        return new ResponseEntity<>("Create success", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@ModelAttribute("idEmployee") String idEmployee, @RequestBody EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeService.findById(idEmployee);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Department department = departmentService.findById(employeeDTO.getIdDepartment()).get();
        Employee employee = new Employee(idEmployee, employeeDTO.getName(), employeeDTO.getAge(), employeeDTO.getSalary(), department);
        employeeService.save(employee);
        return new ResponseEntity<>("Update success", HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDepartment(@ModelAttribute("idEmployee") String idEmployee) {
        Optional<Employee> employeeOptional = employeeService.findById(idEmployee);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.remove(idEmployee);
        return new ResponseEntity<>("Giá trị đã xoá thành công", HttpStatus.OK);
    }

}

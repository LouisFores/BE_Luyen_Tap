package com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Employee;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.repository.IEmployeeRepository;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public Iterable<Employee> findByName(String name) {
        return iEmployeeRepository.findByNameContaining(name);
    }
    public void remove(String idEmployee) {
        iEmployeeRepository.deleteById(idEmployee);
    }

    @Override
    public Optional<Employee> findById(String idEmployee) {
        return iEmployeeRepository.findByIdEmployee(idEmployee);
    }

//    @Override
//    public Iterable<Employee> findAllByAgeOrderByAgeAsc() {
//        return iEmployeeRepository.findAllByAgeOrderByAgeAsc();
//    }
}

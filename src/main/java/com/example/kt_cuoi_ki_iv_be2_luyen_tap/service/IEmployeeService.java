package com.example.kt_cuoi_ki_iv_be2_luyen_tap.service;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService extends IGeneratorService<Employee> {
    Iterable<Employee> findByName(String name);
    Optional<Employee> findById(String idEmployee);
//    Iterable<Employee> findAllByAgeOrderByAgeAsc();

}

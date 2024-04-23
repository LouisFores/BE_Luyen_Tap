package com.example.kt_cuoi_ki_iv_be2_luyen_tap.repository;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IEmployeeRepository extends CrudRepository<Employee, String> {
    Iterable<Employee> findByNameContaining(String name);
    Optional<Employee> findByIdEmployee(String idEmployee);
    @Override
    void deleteById(String s);

//    Iterable<Employee> findEmployeeByAgeIsAfter();
}

package com.example.kt_cuoi_ki_iv_be2_luyen_tap.repository;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface IDepartmentRepository extends CrudRepository<Department, Long> {
    Iterable<Department> findAllByNameDepartmentContaining(String name);

}

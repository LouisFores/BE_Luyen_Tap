package com.example.kt_cuoi_ki_iv_be2_luyen_tap.service;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;

public interface IDepartmentService extends IGeneratorService<Department> {
    Iterable<Department> finDepartmentByName(String name);
}

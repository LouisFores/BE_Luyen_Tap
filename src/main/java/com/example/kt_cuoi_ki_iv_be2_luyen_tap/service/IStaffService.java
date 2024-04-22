package com.example.kt_cuoi_ki_iv_be2_luyen_tap.service;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStaffService extends IGeneratorService<Staff>{
    Page<Staff> findStaffByName(Pageable pageable, String name);

}

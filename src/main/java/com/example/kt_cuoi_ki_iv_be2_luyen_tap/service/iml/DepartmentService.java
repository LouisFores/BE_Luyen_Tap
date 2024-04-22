package com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Department;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.repository.IDepartmentRepository;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository iDepartmentRepository;
    @Override
    public Iterable<Department> findAll() {
        return iDepartmentRepository.findAll();
    }

    @Override
    public Page<Department> findAll(Pageable pageable) {
        return iDepartmentRepository.findAll(pageable);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return iDepartmentRepository.findById(id);
    }

    @Override
    public Department save(Department department) {
        return iDepartmentRepository.save(department);
    }

    @Override
    public void remove(Long id) {
        iDepartmentRepository.deleteById(id);
    }

    @Override
    public Iterable<Department> finDepartmentByName(String name) {
        return iDepartmentRepository.findAllByNameDepartmentContaining(name);
    }
}

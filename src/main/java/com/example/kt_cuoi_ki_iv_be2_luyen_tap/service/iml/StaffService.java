package com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.iml;

import com.example.kt_cuoi_ki_iv_be2_luyen_tap.model.Staff;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.repository.IStaffRepository;
import com.example.kt_cuoi_ki_iv_be2_luyen_tap.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StaffService implements IStaffService {
    @Autowired
    private IStaffRepository iStaffRepository;
    @Override
    public Iterable<Staff> findAll() {
        return iStaffRepository.findAll();
    }

    @Override
    public Page<Staff> findAll(Pageable pageable) {
        return iStaffRepository.findAll(pageable);
    }

    @Override
    public Optional<Staff> findById(Long id) {
        return iStaffRepository.findById(id);
    }

    @Override
    public Staff save(Staff staff) {
        return iStaffRepository.save(staff);
    }

    @Override
    public void remove(Long id) {
        iStaffRepository.deleteById(id);
    }

    @Override
    public Page<Staff> findStaffByName(Pageable pageable, String name) {
        return iStaffRepository.findByFullNameContaining(pageable, name);
    }
}

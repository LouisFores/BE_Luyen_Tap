package com.example.kt_cuoi_ki_iv_be2.service.iml;

import com.example.kt_cuoi_ki_iv_be2.model.People;
import com.example.kt_cuoi_ki_iv_be2.repository.IPeopleRepository;
import com.example.kt_cuoi_ki_iv_be2.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PeopleService implements IPeopleService {
    @Autowired
    private IPeopleRepository iPeopleRepository;
    @Override
    public Iterable<People> findAll() {
        return iPeopleRepository.findAll();
    }

    @Override
    public Page<People> findAll(Pageable pageable) {
        return iPeopleRepository.findAll(pageable);
    }

    @Override
    public Optional<People> findById(Long id) {
        return iPeopleRepository.findById(id);
    }

    @Override
    public People save(People people) {
        return iPeopleRepository.save(people);
    }

    @Override
    public void remove(Long id) {
        iPeopleRepository.deleteById(id);
    }

    @Override
    public Iterable<People> finAllByFullName(String name) {
        return iPeopleRepository.findAllByFullNameContaining(name);
    }
}

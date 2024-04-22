package com.example.kt_cuoi_ki_iv_be2.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneralService<E> {
        Iterable<E> findAll();
        Page<E> findAll(Pageable pageable);
        Optional<E> findById(Long id);
        E save(E e);
        void remove(Long id);
}
package com.example.kt_cuoi_ki_iv_be2_luyen_tap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IGeneratorService<E> {
    Iterable<E> findAll();
    E save(E e);
}

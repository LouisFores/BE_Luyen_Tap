package com.example.kt_cuoi_ki_iv_be2.service;

import com.example.kt_cuoi_ki_iv_be2.model.People;

public interface IPeopleService extends IGeneralService<People> {
    Iterable<People> finAllByFullName(String name);
}

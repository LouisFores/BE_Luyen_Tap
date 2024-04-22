package com.example.kt_cuoi_ki_iv_be2.repository;

import com.example.kt_cuoi_ki_iv_be2.model.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeopleRepository extends CrudRepository<People, Long> {
    Page<People> findAll(Pageable pageable);
    Iterable<People> findAllByFullNameContaining(String name);
}

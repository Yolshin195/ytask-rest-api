package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface BaseEntityService<T extends BaseEntity> {

    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(UUID uuid);
    boolean existsById(UUID id);
    T findById(UUID id);

    Page<T> findAll(Pageable pageable);

}

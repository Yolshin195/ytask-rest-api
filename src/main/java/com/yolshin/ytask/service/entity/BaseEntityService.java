package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.BaseEntity;

import java.util.UUID;

public interface BaseEntityService<T extends BaseEntity> {

    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(UUID uuid);
    boolean existsById(UUID id);
    T findById(UUID id);

}

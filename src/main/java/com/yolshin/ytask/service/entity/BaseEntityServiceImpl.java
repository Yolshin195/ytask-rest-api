package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.BaseEntity;
import com.yolshin.ytask.repository.BaseEntityRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class BaseEntityServiceImpl<T extends BaseEntity> implements BaseEntityService<T> {
    BaseEntityRepository<T> repository;

    public BaseEntityServiceImpl(BaseEntityRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        if (entity == null)
            throw new RuntimeException("BaseEntityServiceImpl.save entity equals null");

        entity.setId(UUID.randomUUID());
        entity.setCreateTs(LocalDateTime.now());

        return repository.save(entity);
    }

    @Override
    public T update(T entity) {
        if (entity == null)
            throw new RuntimeException("BaseEntityServiceImpl.save entity equals null");

        entity.setUpdateTs(LocalDateTime.now());

        return repository.save(entity);
    }

    @Override
    public void delete(T entity) {
        if (entity == null)
            throw new RuntimeException("BaseEntityServiceImpl.save entity equals null");

        entity.setDeleteTs(LocalDateTime.now());

        repository.save(entity);
    }

    @Override
    public void deleteById(UUID id) {
        if (id == null)
            throw new RuntimeException("BaseEntityServiceImpl.deleteById id equals null");

       T entity = findById(id);

        delete(entity);
    }

    public T findById(UUID id) {
        if (id == null)
            throw new RuntimeException("BaseEntityServiceImpl.deleteById id equals null");

        return repository
                .findByIdAndDeleteTsIsNull(id)
                .orElseThrow(() -> new RuntimeException("BaseEntityServiceImpl not found by id '" + id + "'"));
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsByIdAndDeleteTsIsNull(id);
    }
}

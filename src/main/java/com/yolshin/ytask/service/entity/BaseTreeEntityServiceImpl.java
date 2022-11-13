package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.BaseTreeEntity;
import com.yolshin.ytask.repository.BaseTreeEntityRepository;

public class BaseTreeEntityServiceImpl<T extends BaseTreeEntity> extends BaseEntityServiceImpl<T> implements BaseTreeEntityService<T> {

    protected BaseTreeEntityRepository<T> repository;

    public BaseTreeEntityServiceImpl(BaseTreeEntityRepository<T> repository) {
        super(repository);
        this.repository = repository;
    }

}

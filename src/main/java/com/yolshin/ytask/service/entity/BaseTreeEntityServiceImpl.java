package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.BaseTreeEntity;
import com.yolshin.ytask.repository.BaseTreeEntityRepository;

public class BaseTreeEntityServiceImpl<T extends BaseTreeEntity> implements BaseTreeEntityService<T> {

    BaseTreeEntityRepository<T> repository;

    public BaseTreeEntityServiceImpl(BaseTreeEntityRepository<T> repository) {
        this.repository = repository;
    }

}

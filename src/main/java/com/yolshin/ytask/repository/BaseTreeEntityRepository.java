package com.yolshin.ytask.repository;

import com.yolshin.ytask.model.entity.BaseTreeEntity;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseTreeEntityRepository<T extends BaseTreeEntity> extends BaseEntityRepository<T> {
}

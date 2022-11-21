package com.yolshin.ytask.repository;

import com.yolshin.ytask.model.entity.BaseTreeEntity;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseTreeEntityRepository<T extends BaseTreeEntity> extends BaseEntityRepository<T> {
    Collection<T> findByParentIsNullAndDeleteTsIsNull();

    Collection<T> findByParentAndDeleteTsIsNull(UUID parent);

}

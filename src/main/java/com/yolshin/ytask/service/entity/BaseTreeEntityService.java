package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.BaseTreeEntity;

import java.util.Collection;
import java.util.UUID;

public interface BaseTreeEntityService<T extends BaseTreeEntity> extends BaseEntityService<T> {
    Collection<T> getRootNode();
    Collection<T> getChildrenNode(UUID parent);
}

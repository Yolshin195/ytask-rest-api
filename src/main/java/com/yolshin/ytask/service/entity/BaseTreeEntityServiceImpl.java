package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.BaseTreeEntity;
import com.yolshin.ytask.repository.BaseTreeEntityRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BaseTreeEntityServiceImpl<T extends BaseTreeEntity> extends BaseEntityServiceImpl<T> implements BaseTreeEntityService<T> {

    protected BaseTreeEntityRepository<T> repository;

    public BaseTreeEntityServiceImpl(BaseTreeEntityRepository<T> repository) {
        super(repository);
        this.repository = repository;
    }

    @Transactional
    public T save(T treeEntity) {

        treeEntity.setLevel(1);
        treeEntity.setChildren(false);

        if (treeEntity.getParent() != null) {
            T parentTreeEntity = super.findById(treeEntity.getParent());
            treeEntity.setLevel(parentTreeEntity.getLevel() + 1);
            treeEntity.setChildren(true);
        }

        return super.save(treeEntity);
    }

    @Override
    public Collection<T> getRootNode() {
        return repository.findByParentIsNullAndDeleteTsIsNull();
    }

    @Override
    public Collection<T> getChildrenNode(UUID parent) {
        return repository.findByParentAndDeleteTsIsNull(parent);
    }
}

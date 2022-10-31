package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.ProvideAccessTask;
import com.yolshin.ytask.repository.ProvideAccessTaskRepository;
import org.springframework.stereotype.Service;

@Service
public class ProvideAccessTaskServiceImpl extends BaseEntityServiceImpl<ProvideAccessTask> {

    private final ProvideAccessTaskRepository repository;

    public ProvideAccessTaskServiceImpl(ProvideAccessTaskRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

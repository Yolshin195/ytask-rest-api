package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.Timer;
import com.yolshin.ytask.repository.TimerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TimerEntityServiceImpl extends BaseEntityServiceImpl<Timer> implements TimerEntityService {

    private final TimerRepository repository;

    public TimerEntityServiceImpl(TimerRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Timer> findByTaskId(UUID taskId) {
        return repository.findByTaskIdAndDeleteTsIsNull(taskId);
    }
}

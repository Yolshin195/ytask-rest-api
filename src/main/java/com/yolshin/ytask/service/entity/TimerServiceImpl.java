package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.Timer;
import com.yolshin.ytask.repository.BaseEntityRepository;
import com.yolshin.ytask.repository.TimerRepository;
import org.springframework.stereotype.Service;

@Service
public class TimerServiceImpl extends BaseEntityServiceImpl<Timer> implements TimerService {

    private final TimerRepository repository;

    public TimerServiceImpl(TimerRepository repository) {
        super(repository);
        this.repository = repository;
    }
}

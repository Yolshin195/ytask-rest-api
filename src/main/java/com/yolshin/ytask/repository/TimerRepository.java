package com.yolshin.ytask.repository;

import com.yolshin.ytask.model.entity.Timer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TimerRepository extends BaseEntityRepository<Timer> {
    List<Timer> findByTaskIdAndDeleteTsIsNull(UUID taskId);
}

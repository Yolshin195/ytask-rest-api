package com.yolshin.ytask.repository;

import com.yolshin.ytask.model.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseTreeEntityRepository<Task> {
}

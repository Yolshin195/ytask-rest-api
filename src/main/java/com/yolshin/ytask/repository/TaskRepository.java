package com.yolshin.ytask.repository;

import com.yolshin.ytask.model.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends BaseTreeEntityRepository<Task> {
    List<Task> findAllByAuthorAndDeleteTsIsNull(UUID author);
    Collection<Task> findByAuthorAndParentIsNullAndDeleteTsIsNull(UUID author);

    Collection<Task> findByParentAndAuthorAndDeleteTsIsNull(UUID parent, UUID author);
}

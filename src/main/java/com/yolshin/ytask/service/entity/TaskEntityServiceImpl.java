package com.yolshin.ytask.service.entity;

import com.yolshin.ytask.model.entity.AppUser;
import com.yolshin.ytask.model.entity.AppUserRole;
import com.yolshin.ytask.model.entity.Task;
import com.yolshin.ytask.model.entity.TaskStatusEnum;
import com.yolshin.ytask.repository.TaskRepository;
import org.aspectj.weaver.bcel.ExceptionRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class TaskEntityServiceImpl extends BaseTreeEntityServiceImpl<Task> implements TaskEntityService {

    protected final TaskRepository repository;
    protected final UserEntityService userEntityService;

    public TaskEntityServiceImpl(TaskRepository repository, UserEntityService userEntityService) {
        super(repository);
        this.repository = repository;
        this.userEntityService = userEntityService;
    }

    @Override
    public List<Task> findAll() {
        return repository.findAllByAuthorAndDeleteTsIsNull(getUserId());
    }

    @Override
    public Collection<Task> getRootNode() {
        return repository.findByAuthorAndParentIsNullAndDeleteTsIsNull(getUserId());
    }

    @Override
    public Collection<Task> getChildrenNode(UUID parent) {
       return repository.findByParentAndAuthorAndDeleteTsIsNull(getUserId(), parent);
    }

    @Override
    public Task save(Task task) {
        task.setAuthor(getUserId());
        task.setTaskStatus(TaskStatusEnum.CREATE);
        return super.save(task);
    }


    private UUID getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            AppUser user = userEntityService.findByUsername(authentication.getName());
            if (user != null) return user.getId();
        }

        throw new RuntimeException("Authentication user not found");
    }
}

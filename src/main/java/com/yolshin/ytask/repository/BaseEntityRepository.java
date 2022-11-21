package com.yolshin.ytask.repository;

import com.yolshin.ytask.model.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {
    Optional<T> findByIdAndDeleteTsIsNull(UUID id);
    Boolean existsByIdAndDeleteTsIsNull(UUID id);

    Iterable<T> findAllByDeleteTsIsNull(Sort sort);

    Page<T> findAllByDeleteTsIsNull(Pageable pageable);


}

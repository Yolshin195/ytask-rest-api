package com.yolshin.ytask.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseTreeEntity extends BaseEntity {

    @Column(name = "parent_id")
    protected UUID parent;

    @Column(name = "level_")
    protected Integer level;

    public UUID getParent() {
        return parent;
    }

    public void setParent(UUID parent) {
        this.parent = parent;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

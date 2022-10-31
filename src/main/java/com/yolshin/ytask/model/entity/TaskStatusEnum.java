package com.yolshin.ytask.model.entity;

public enum TaskStatusEnum {
    CREATE(0),
    COMPLETE(1);

    private final Integer value;

    TaskStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static TaskStatusEnum valueOf(Integer value) {
        for (var taskStatus : values()) {
            if (taskStatus.value.equals(value)) {
                return taskStatus;
            }
        }

        throw new RuntimeException("TaskStatusEnum not found by name '" + value + "'");
    }
}

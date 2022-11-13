package com.yolshin.ytask.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record TimerFullResponse(UUID id, UUID taskId, LocalDateTime begin, LocalDateTime end) {
}

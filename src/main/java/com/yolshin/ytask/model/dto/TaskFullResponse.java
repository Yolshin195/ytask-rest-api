package com.yolshin.ytask.model.dto;

import java.util.UUID;

public record TaskFullResponse(UUID id, String title, String description) {}

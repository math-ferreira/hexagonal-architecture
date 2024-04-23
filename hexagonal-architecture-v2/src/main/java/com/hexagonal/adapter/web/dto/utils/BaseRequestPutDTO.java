package com.hexagonal.adapter.web.dto.utils;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.UUID;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public interface BaseRequestPutDTO<TO> {
    TO toDomain(UUID fromId);
}

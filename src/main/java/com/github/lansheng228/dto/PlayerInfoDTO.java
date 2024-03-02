package com.github.lansheng228.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;


@Slf4j
@Data
@Builder
@AllArgsConstructor
public class PlayerInfoDTO {
    private final UUID id;
    private final String name;
}


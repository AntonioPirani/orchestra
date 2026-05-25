package com.orchestra.crm.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record CustomerDto(
        UUID id,
        String externalId,
        String firstName,
        String lastName,
        String email,
        String phone,
        String country,
        List<ContactDto> contacts,
        Instant createdAt
) {
    public record ContactDto(
            UUID id,
            String type,
            String fullName,
            String email,
            String phone
    ) {}
}
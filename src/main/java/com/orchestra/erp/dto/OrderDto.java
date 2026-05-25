package com.orchestra.erp.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderDto(
        UUID id,
        String orderNumber,
        String customerExternalId,
        String status,
        BigDecimal totalAmount,
        String currency,
        String notes,
        List<OrderItemDto> items,
        Instant createdAt
) {
    public record OrderItemDto(
            UUID id,
            String sku,
            String description,
            Integer quantity,
            BigDecimal unitPrice
    ) {}
}
package com.orchestra.warehouse.dto;

import java.time.Instant;
import java.util.UUID;

public record InventoryItemDto(
        UUID id,
        String sku,
        String name,
        String description,
        Integer quantityAvailable,
        Integer quantityReserved,
        Integer quantityFree,
        UUID warehouseId,
        String warehouseCode,
        Instant createdAt
) {}
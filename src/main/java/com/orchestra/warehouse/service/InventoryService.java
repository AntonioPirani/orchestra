package com.orchestra.warehouse.service;

import com.orchestra.common.exception.ResourceNotFoundException;
import com.orchestra.warehouse.domain.InventoryItem;
import com.orchestra.warehouse.dto.InventoryItemDto;
import com.orchestra.warehouse.repository.InventoryItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryService {

    private final InventoryItemRepository inventoryItemRepository;

    public List<InventoryItemDto> findAll() {
        return inventoryItemRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public InventoryItemDto findById(UUID id) {
        return inventoryItemRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Inventory item not found with id: " + id));
    }

    public InventoryItemDto findBySku(String sku) {
        return inventoryItemRepository.findBySku(sku)
                .map(this::toDto)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Inventory item not found with SKU: " + sku));
    }

    public List<InventoryItemDto> findOutOfStock() {
        return inventoryItemRepository.findOutOfStock()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public List<InventoryItemDto> findFullyReserved() {
        return inventoryItemRepository.findFullyReserved()
                .stream()
                .map(this::toDto)
                .toList();
    }

    private InventoryItemDto toDto(InventoryItem i) {
        return new InventoryItemDto(
                i.getId(),
                i.getSku(),
                i.getName(),
                i.getDescription(),
                i.getQuantityAvailable(),
                i.getQuantityReserved(),
                i.getQuantityAvailable() - i.getQuantityReserved(),
                i.getWarehouse().getId(),
                i.getWarehouse().getCode(),
                i.getCreatedAt()
        );
    }
}
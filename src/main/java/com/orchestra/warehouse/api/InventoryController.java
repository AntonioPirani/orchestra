package com.orchestra.warehouse.api;

import com.orchestra.common.api.ApiResponse;
import com.orchestra.warehouse.dto.InventoryItemDto;
import com.orchestra.warehouse.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/warehouse/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<InventoryItemDto>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(inventoryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItemDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(inventoryService.findById(id));
    }

    @GetMapping("/by-sku/{sku}")
    public ResponseEntity<ApiResponse<InventoryItemDto>> getBySku(@PathVariable String sku) {
        return ResponseEntity.ok(ApiResponse.ok(inventoryService.findBySku(sku)));
    }

    @GetMapping("/out-of-stock")
    public ResponseEntity<ApiResponse<List<InventoryItemDto>>> getOutOfStock() {
        return ResponseEntity.ok(ApiResponse.ok(inventoryService.findOutOfStock()));
    }

    @GetMapping("/fully-reserved")
    public ResponseEntity<ApiResponse<List<InventoryItemDto>>> getFullyReserved() {
        return ResponseEntity.ok(ApiResponse.ok(inventoryService.findFullyReserved()));
    }
}
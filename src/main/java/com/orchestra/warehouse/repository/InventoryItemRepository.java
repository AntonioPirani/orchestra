package com.orchestra.warehouse.repository;

import com.orchestra.warehouse.domain.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, UUID> {

    Optional<InventoryItem> findBySku(String sku);

    boolean existsBySku(String sku);

    List<InventoryItem> findByWarehouseId(UUID warehouseId);

    @Query("SELECT i FROM InventoryItem i WHERE i.quantityAvailable = 0")
    List<InventoryItem> findOutOfStock();

    @Query("SELECT i FROM InventoryItem i WHERE i.quantityAvailable > 0 " +
            "AND i.quantityAvailable = i.quantityReserved")
    List<InventoryItem> findFullyReserved();
}
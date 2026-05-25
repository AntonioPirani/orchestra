package com.orchestra.erp.api;

import com.orchestra.erp.dto.OrderDto;
import com.orchestra.erp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/erp/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("/by-number/{orderNumber}")
    public ResponseEntity<OrderDto> getByOrderNumber(@PathVariable String orderNumber) {
        return ResponseEntity.ok(orderService.findByOrderNumber(orderNumber));
    }

    @GetMapping("/by-customer/{customerExternalId}")
    public ResponseEntity<List<OrderDto>> getByCustomer(@PathVariable String customerExternalId) {
        return ResponseEntity.ok(orderService.findByCustomerExternalId(customerExternalId));
    }

    @GetMapping("/by-status/{status}")
    public ResponseEntity<List<OrderDto>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(orderService.findByStatus(status));
    }
}
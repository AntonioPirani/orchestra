package com.orchestra.erp.api;

import com.orchestra.common.api.ApiResponse;
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
    public ResponseEntity<ApiResponse<List<OrderDto>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(orderService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<OrderDto>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.ok(orderService.findById(id)));
    }

    @GetMapping("/by-number/{orderNumber}")
    public ResponseEntity<ApiResponse<OrderDto>> getByOrderNumber(@PathVariable String orderNumber) {
        return ResponseEntity.ok(ApiResponse.ok(orderService.findByOrderNumber(orderNumber)));
    }

    @GetMapping("/by-customer/{customerExternalId}")
    public ResponseEntity<ApiResponse<List<OrderDto>>> getByCustomer(@PathVariable String customerExternalId) {
        return ResponseEntity.ok(ApiResponse.ok(orderService.findByCustomerExternalId(customerExternalId)));
    }

    @GetMapping("/by-status/{status}")
    public ResponseEntity<ApiResponse<List<OrderDto>>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(ApiResponse.ok(orderService.findByStatus(status)));
    }
}
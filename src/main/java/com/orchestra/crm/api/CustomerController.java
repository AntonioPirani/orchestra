package com.orchestra.crm.api;

import com.orchestra.common.api.ApiResponse;
import com.orchestra.crm.dto.CustomerDto;
import com.orchestra.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/crm/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerDto>>> getAll() {
        return ResponseEntity.ok(ApiResponse.ok(customerService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.ok(customerService.findById(id)));
    }

    @GetMapping("/by-external-id/{externalId}")
    public ResponseEntity<ApiResponse<CustomerDto>> getByExternalId(@PathVariable String externalId) {
        return ResponseEntity.ok(ApiResponse.ok(customerService.findByExternalId(externalId)));
    }
}
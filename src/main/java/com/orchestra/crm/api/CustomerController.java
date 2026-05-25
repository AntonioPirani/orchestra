package com.orchestra.crm.api;

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
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @GetMapping("/by-external-id/{externalId}")
    public ResponseEntity<CustomerDto> getByExternalId(@PathVariable String externalId) {
        return ResponseEntity.ok(customerService.findByExternalId(externalId));
    }
}
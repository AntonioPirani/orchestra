package com.orchestra.crm.service;

import com.orchestra.common.exception.ResourceNotFoundException;
import com.orchestra.crm.domain.Customer;
import com.orchestra.crm.dto.CustomerDto;
import com.orchestra.crm.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<CustomerDto> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public CustomerDto findById(UUID id) {
        Customer customer = customerRepository.findByIdWithContacts(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found with id: " + id));
        return toDto(customer);
    }

    public CustomerDto findByExternalId(String externalId) {
        Customer customer = customerRepository.findByExternalId(externalId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer not found with externalId: " + externalId));
        return toDto(customer);
    }

    private CustomerDto toDto(Customer c) {
        List<CustomerDto.ContactDto> contacts = c.getContacts()
                .stream()
                .map(contact -> new CustomerDto.ContactDto(
                        contact.getId(),
                        contact.getType(),
                        contact.getFullName(),
                        contact.getEmail(),
                        contact.getPhone()
                ))
                .toList();

        return new CustomerDto(
                c.getId(),
                c.getExternalId(),
                c.getFirstName(),
                c.getLastName(),
                c.getEmail(),
                c.getPhone(),
                c.getCountry(),
                contacts,
                c.getCreatedAt()
        );
    }
}
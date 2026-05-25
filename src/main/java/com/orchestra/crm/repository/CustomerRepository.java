package com.orchestra.crm.repository;

import com.orchestra.crm.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByExternalId(String externalId);

    boolean existsByExternalId(String externalId);

    @Query("SELECT c FROM Customer c LEFT JOIN FETCH c.contacts WHERE c.id = :id")
    Optional<Customer> findByIdWithContacts(UUID id);
}
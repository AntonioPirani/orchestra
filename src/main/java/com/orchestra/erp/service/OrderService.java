package com.orchestra.erp.service;

import com.orchestra.common.exception.ResourceNotFoundException;
import com.orchestra.erp.domain.Order;
import com.orchestra.erp.dto.OrderDto;
import com.orchestra.erp.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public OrderDto findById(UUID id) {
        Order order = orderRepository.findByIdWithItems(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Order not found with id: " + id));
        return toDto(order);
    }

    public OrderDto findByOrderNumber(String orderNumber) {
        Order order = orderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Order not found with number: " + orderNumber));
        return toDto(order);
    }

    public List<OrderDto> findByCustomerExternalId(String customerExternalId) {
        return orderRepository.findByCustomerExternalId(customerExternalId)
                .stream()
                .map(this::toDto)
                .toList();
    }

    public List<OrderDto> findByStatus(String status) {
        return orderRepository.findByStatus(status)
                .stream()
                .map(this::toDto)
                .toList();
    }

    private OrderDto toDto(Order o) {
        List<OrderDto.OrderItemDto> items = o.getItems()
                .stream()
                .map(item -> new OrderDto.OrderItemDto(
                        item.getId(),
                        item.getSku(),
                        item.getDescription(),
                        item.getQuantity(),
                        item.getUnitPrice()
                ))
                .toList();

        return new OrderDto(
                o.getId(),
                o.getOrderNumber(),
                o.getCustomerExternalId(),
                o.getStatus(),
                o.getTotalAmount(),
                o.getCurrency(),
                o.getNotes(),
                items,
                o.getCreatedAt()
        );
    }
}
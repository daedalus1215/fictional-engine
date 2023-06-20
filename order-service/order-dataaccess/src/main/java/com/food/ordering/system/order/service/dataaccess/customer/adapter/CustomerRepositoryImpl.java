package com.food.ordering.system.order.service.dataaccess.customer.adapter;

import com.food.ordering.system.application.order.service.domain.entity.Customer;
import com.food.ordering.system.application.order.service.domain.ports.output.repository.CustomerRepository;

import java.util.Optional;
import java.util.UUID;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return Optional.empty();
    }
}

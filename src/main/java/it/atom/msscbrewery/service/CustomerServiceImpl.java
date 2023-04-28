package it.atom.msscbrewery.service;

import it.atom.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .Id(UUID.randomUUID())
                .Name("Sunil Kumar")
                .build();
    }
}

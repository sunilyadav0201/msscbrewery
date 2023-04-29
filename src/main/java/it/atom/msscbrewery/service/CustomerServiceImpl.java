package it.atom.msscbrewery.service;

import it.atom.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .Id(UUID.randomUUID())
                .Name("Sunil Kumar")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .Id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating Customer ........");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting customer ..........");
    }
}

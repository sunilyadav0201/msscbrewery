package it.atom.msscbrewery.web.controller;

import it.atom.msscbrewery.service.CustomerService;
import it.atom.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto saveDto=customerService.saveCustomer(customerDto);
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("location","/api/vi/customer/"+saveDto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);

    }

    @PutMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
    }

}

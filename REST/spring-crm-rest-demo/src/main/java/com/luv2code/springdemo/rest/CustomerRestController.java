package com.luv2code.springdemo.rest;


import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    //autowire the customerService
    @Autowired
    private CustomerService customerService;

    //add mapping for get customers
    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId)
    {
        Customer customer = customerService.getCustomer(customerId);
        if(customer==null)
        {
            throw new CustomerNotFoundException("Customer id not found: " + customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer)
    {
        //also just in case the client pas an id in json.. set id to 0

        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    //add mapping for update customers
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer)
    {
        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId)
    {
        Customer tempCustomer = customerService.getCustomer(customerId);

        if(tempCustomer == null)
        {
            throw new CustomerNotFoundException("Customer id not found: " + customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted Customer id: " + customerId;
    }
}

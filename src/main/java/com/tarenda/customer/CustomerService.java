package com.tarenda.customer;

import com.tarenda.exception.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomerById(Integer id) {
        return customerDao.getCustomerById(id)
                .orElseThrow(() -> new ResourceNotFound("customer with id %s not found".formatted(id)));
    }
}

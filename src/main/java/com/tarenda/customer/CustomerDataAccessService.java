package com.tarenda.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDao{
    private static List<Customer> customerList;

    static{
        customerList = new ArrayList<>();
    }
    @Override
    public List<Customer> selectAllCustomers() {

        Customer alex= new Customer(
                1,
                "Alex",
                "alex@gmail.com",
                21
        );
        customerList.add(alex);

        Customer sam = new Customer(
                2,
                "Sam",
                "sam@gmail.com",
                9
        );
        customerList.add(sam);
        return customerList;
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
        return customerList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}

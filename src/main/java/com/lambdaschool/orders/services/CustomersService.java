package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

import java.util.List;


public interface CustomersService {
    List<Customer> findAllCustomers();

    Customer findCustomersById(long custid);

    List<Customer> findByCustomerName(String custname);
}

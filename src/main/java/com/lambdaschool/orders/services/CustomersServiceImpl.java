package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService{

    @Autowired
    private CustomersRepository custrepos;

    @Override
    public List<Customer> findAllCustomers() {

        List<Customer> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    @Override
    public Customer findCustomersById(long custid) throws EntityNotFoundException {
        return custrepos.findById(custid).orElseThrow(()-> new EntityNotFoundException("Customer "+ custid + " Not Found"));
    }

    @Override
    public List<Customer> findByCustomerName(String custname) {
        return custrepos.findByCustnameContainingIgnoringCase(custname);
    }
}

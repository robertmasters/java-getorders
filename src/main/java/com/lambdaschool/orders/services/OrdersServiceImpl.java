package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service(value = "ordersService")
public class OrdersServiceImpl implements OrderService{

    @Autowired
    private OrdersRepository ordersRepo;


    @Override
    public List<Order> findOrdersWithAdvancedAmount() {
        return ordersRepo.findAllByAdvanceamountGreaterThan(0.00);
    }

    @Override
    public Order findOrdersById(long ordernum) {
        return ordersRepo.findById(ordernum).orElseThrow(()->new EntityNotFoundException("Order "+ordernum+" Not Found"));
    }
}

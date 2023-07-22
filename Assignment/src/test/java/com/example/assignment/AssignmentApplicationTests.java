package com.example.assignment;

import com.example.assignment.entity.Customer;
import com.example.assignment.entity.Order;
import com.example.assignment.entity.OrderItem;
import com.example.assignment.service.customer.CustomerService;
import com.example.assignment.service.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AssignmentApplicationTests {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {

    }

    @Test
    void addCustomer(){
        Customer customer = new Customer();
        customer.setName("Rohit");
        customer.setEmail("abc@gmail.com");
        customerService.saveCustomer(customer);
    }

}

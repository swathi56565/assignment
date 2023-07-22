package com.example.assignment.service.customer;

import com.example.assignment.entity.Customer;
import com.example.assignment.response.BaseResponse;

public interface CustomerService {

    BaseResponse saveCustomer(Customer customer);

}

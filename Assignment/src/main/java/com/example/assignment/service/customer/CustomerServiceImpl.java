package com.example.assignment.service.customer;

import com.example.assignment.entity.Customer;
import com.example.assignment.repository.CustomerRepository;
import com.example.assignment.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public BaseResponse saveCustomer(Customer customer) {
        BaseResponse response = new BaseResponse();
        Optional<Customer> optional = customerRepository.findCustomerByEmail(customer.getEmail());
        if(optional.isPresent()){
            response.setSuccess(false);
            response.setMessage("User is Already Present");
            return response;
        }
        this.customerRepository.save(customer);
        response.setSuccess(true);
        response.setMessage("SUCCESS");
        return response;
    }
}

package com.example.assignment.service.order;

import com.example.assignment.entity.Order;
import com.example.assignment.response.RewardTransactionResponse;

public interface OrderService {

        void saveOrder(Order order);

        RewardTransactionResponse getAllOrderByMonths();

        RewardTransactionResponse getAllOrderMonthWiseByClient(Long cid);

        RewardTransactionResponse getOrderByMonths();

        RewardTransactionResponse getOrderMonthWiseByClient(Long cid);


}

package com.example.assignment.service.transaction;

import com.example.assignment.response.RewardTransactionResponse;
import com.example.assignment.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private OrderService orderService;

    @Override
    public RewardTransactionResponse getTractionPerMonth() {
        return orderService.getOrderByMonths();
    }

    @Override
    public RewardTransactionResponse getAllTransaction() {
        return orderService.getAllOrderByMonths();
    }

    @Override
    public RewardTransactionResponse getTractionPerMonthByClient(Long cid) {
        return orderService.getOrderMonthWiseByClient(cid);
    }

    @Override
    public RewardTransactionResponse getAllTransactionByClient(Long cid) {
        return orderService.getAllOrderMonthWiseByClient(cid);
    }
}

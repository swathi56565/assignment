package com.example.assignment.service.transaction;

import com.example.assignment.entity.Order;
import com.example.assignment.response.RewardTransactionResponse;

public interface TransactionService {

    RewardTransactionResponse getTractionPerMonth();

    RewardTransactionResponse getAllTransaction();

    RewardTransactionResponse getTractionPerMonthByClient(Long cid);

    RewardTransactionResponse getAllTransactionByClient(Long cid);

}

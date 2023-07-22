package com.example.assignment.service.order;

import com.example.assignment.entity.Order;
import com.example.assignment.repository.OrderRepository;
import com.example.assignment.response.RewardTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        order.setCreatedOn(System.currentTimeMillis());
        Double point = 0.0;
        if((order.getAmount() - 100) > 0){
            point += (order.getAmount() - 100) * 2;
        }
        if(order.getAmount() > 50){
            point += (order.getAmount() - 50) * 1;
        }
        order.setRewardPoints(point);
        orderRepository.save(order);
    }

    @Override
    public RewardTransactionResponse getAllOrderByMonths() {
        return orderRepository.getTotalConsolidatedDataMonthWise();
    }

    @Override
    public RewardTransactionResponse getAllOrderMonthWiseByClient(Long cid) {
        return orderRepository.getTotalConsolidatedDataMonthWiseByClientId(cid);
    }

    @Override
    public RewardTransactionResponse getOrderByMonths() {
        return orderRepository.getConsolidatedDataMonthWise(getTimeStamp().toString(),System.currentTimeMillis()+"");
    }

    @Override
    public RewardTransactionResponse getOrderMonthWiseByClient(Long cid) {
        return orderRepository.getConsolidatedDataMonthWiseByClientId(cid,getTimeStamp().toString(),System.currentTimeMillis()+"");
    }

    private Long getTimeStamp(){
        LocalDate currentDate = LocalDate.now();

        LocalDate threeMonthsAgo = currentDate.minusMonths(3);

        LocalDateTime threeMonthsAgoDateTime = threeMonthsAgo.atStartOfDay();

        long timestamp = threeMonthsAgoDateTime.toEpochSecond(ZoneOffset.UTC);

        return timestamp;
    }

}

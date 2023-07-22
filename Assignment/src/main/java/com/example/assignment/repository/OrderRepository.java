package com.example.assignment.repository;

import com.example.assignment.entity.Order;
import com.example.assignment.response.RewardTransactionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

     @Query(value = "select sum(ord.amount) As totalPurchaseAmount, sum(ord.reward_points) As totalRewardPoint, month(ord.created_on) As Month, year(ord.created_on) As year from order odr group by month(ord.created_on) order by year, month(ord.created_on)",nativeQuery = true)
     RewardTransactionResponse getTotalConsolidatedDataMonthWise();

    @Query(value = "select sum(ord.amount) As totalPurchaseAmount, sum(ord.reward_points) As totalRewardPoint, month(ord.created_on) As Month, year(ord.created_on) As year from order odr where odr.cid = ?1 group by month(ord.created_on) order by year, month(ord.created_on)",nativeQuery = true)
    RewardTransactionResponse getTotalConsolidatedDataMonthWiseByClientId(Long cid);

    @Query(value = "select sum(ord.amount) As totalPurchaseAmount, sum(ord.reward_points) As totalRewardPoint, month(ord.created_on) As Month, year(ord.created_on) As year from order odr where ord.created_on between ?1 AND ?2 group by month(ord.created_on) order by year, month(ord.created_on)",nativeQuery = true)
    RewardTransactionResponse getConsolidatedDataMonthWise(String from, String to);

    @Query(value = "select sum(ord.amount) As totalPurchaseAmount, sum(ord.reward_points) As totalRewardPoint, month(ord.created_on) As Month, year(ord.created_on) As year from order odr where odr.cid = ?1 && ord.created_on between ?2 AND ?3 group by month(ord.created_on) order by year, month(ord.created_on) ",nativeQuery = true)
    RewardTransactionResponse getConsolidatedDataMonthWiseByClientId( Long cid,  String from,  String to);

}

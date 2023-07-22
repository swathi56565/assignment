package com.example.assignment.controller;

import com.example.assignment.response.GenericResponse;
import com.example.assignment.response.RewardTransactionResponse;
import com.example.assignment.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction/")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("get-all")
    public ResponseEntity<GenericResponse<RewardTransactionResponse>> getAllTransaction(@RequestParam(name = "cid" ,required = false,defaultValue = "0") Long cid) {
        GenericResponse<RewardTransactionResponse> response = new GenericResponse<>();
        try {
              if(cid == 0){
                  response.setDto(transactionService.getAllTransaction());
              }else{
                  response.setDto(transactionService.getAllTransactionByClient(cid));
              }
              response.setSuccess(true);
              response.setMessage("SUCCESS");
        } catch (Exception ex) {
              response.setMessage("FAILURE WHILE FETCHING THE DATA");
              response.setSuccess(false);
        }
       return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("get-monthly")
    public ResponseEntity<GenericResponse<RewardTransactionResponse>> getMonthlyTransaction(@RequestParam(name = "cid" ,required = false,defaultValue = "0") Long cid) {
        GenericResponse<RewardTransactionResponse> response = new GenericResponse<>();
        try {
            if(cid == 0){
                response.setDto(transactionService.getTractionPerMonth());
            }else{
                response.setDto(transactionService.getTractionPerMonthByClient(cid));
            }
            response.setSuccess(true);
            response.setMessage("SUCCESS");
        } catch (Exception ex) {
            response.setMessage("FAILURE WHILE FETCHING THE DATA");
            response.setSuccess(false);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}

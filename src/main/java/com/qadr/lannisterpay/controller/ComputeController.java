package com.qadr.lannisterpay.controller;

import com.qadr.lannisterpay.model.SplitResponse;
import com.qadr.lannisterpay.model.Transaction;
import com.qadr.lannisterpay.service.LannisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public record ComputeController(LannisterService service) {

    @PostMapping("/split-payments/compute")
    public SplitResponse compute(@RequestBody Transaction transaction, HttpServletRequest request){
        return service.compute(transaction);
    }
}

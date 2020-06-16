package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment){

        return paymentService.create(payment);
    }

    @GetMapping("getPaymentById")
    public CommonResult getPaymentById(Long id){

        return paymentService.getPaymentById(id);
    }
}

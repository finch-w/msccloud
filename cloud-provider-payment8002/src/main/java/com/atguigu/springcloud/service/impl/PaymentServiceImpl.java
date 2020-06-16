package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public CommonResult create(Payment payment) {
        int result = paymentDao.create(payment);
        log.info("插入成功：" + result);
        if (result>0){
            return new CommonResult(CommonResult.CommonResultUtil.OK_CODE,CommonResult.CommonResultUtil.OK_MESSAGE,result);
        }else {
            return new CommonResult(CommonResult.CommonResultUtil.SYSTEM_ERROR,CommonResult.CommonResultUtil.SYSTEM_ERROR_MESSAGE,result);
        }
    }

    @Override
    public CommonResult getPaymentById(Long id) {
        if(id!=null){
            Payment payment = paymentDao.getPaymentById(id);
            return new CommonResult(CommonResult.CommonResultUtil.OK_CODE,CommonResult.CommonResultUtil.OK_MESSAGE,payment);
        }
        return new CommonResult(CommonResult.CommonResultUtil.SYSTEM_ERROR,CommonResult.CommonResultUtil.SYSTEM_ERROR_MESSAGE,null);
    }
}

package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo() {
        System.out.println("进入-----");
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        //String result = restTemplate.getForObject("http://localhost:8004/payment/zk",String.class);
        System.out.println("成功-----");
        return result;
    }
}

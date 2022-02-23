package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    @ResponseBody
    @SentinelResource(value = "testA",blockHandler = "dealHandler_testHotKey")
    public String testA(@RequestParam(value = "a",required = false) int a,
                        @RequestParam(value = "b",required = false) int b) {
        String s = Thread.currentThread().getName() + "\t" + "---testA";
        log.info(s);
        return "------testA" + s;
    }

    @GetMapping("/rateLimit/byUrl")
    @ResponseBody
    @SentinelResource(value = "default",blockHandler = "dealHandler_testHotKey")
    public String testB() {
        return "------testB";
    }

    public String dealHandler_testHotKey(Integer a, Integer b, BlockException exception)
    {
        return "-----dealHandler_testHotKey";
    }

}

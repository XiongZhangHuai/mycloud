package com.atguigu.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;

public class MyHandler {
    public CommonResult handler1(BlockException exception) {
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }
}

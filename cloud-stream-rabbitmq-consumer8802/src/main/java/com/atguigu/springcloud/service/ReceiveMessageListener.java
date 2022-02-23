package com.atguigu.springcloud.service;

import org.apache.tomcat.util.net.WriteBuffer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListener {
    @Value("${server.port}")
    private String serverPort;


    public ReceiveMessageListener() {
        System.out.println("--------------------被创建了");
    }

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("接收到的消息：" + message.getPayload() + "\t port:" + serverPort);
    }
}

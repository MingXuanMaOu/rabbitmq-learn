package com.ming.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author liuming
 * @description
 * @date 2022/8/15
 */
@Component
public class MyListener {

    //测试

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void myListener(String message){

        System.out.println("消费者收到的消息：" + message);
    }
}

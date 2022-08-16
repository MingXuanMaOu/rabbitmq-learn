package com.ming.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuming
 * @description
 * @date 2022/8/15
 */
@Configuration
public class RabbitMQConfig {

    public static final String ITEM_TOPIC_EXCHANGE = "item_topic_exchange";
    public static final String ITEM_QUEUE = "item_queue";
    public static final String ITEM_QUEUE1 = "item_queue1";

    @Bean("itemTopicExchange")
    public Exchange topicExchange(){
        return ExchangeBuilder.topicExchange(ITEM_TOPIC_EXCHANGE).durable(true).build();
    }
//
//    @Bean("itemQueue")
//    public Queue itemQueue(){
//        return QueueBuilder.durable(ITEM_QUEUE).build();
//    }
//
//    @Bean
//    public Binding itemQueueExchange(@Qualifier("itemQueue") Queue queue,@Qualifier("itemTopicExchange")Exchange exchange){
//        return BindingBuilder.bind(queue).to(exchange).with("item.#").noargs();
//    }
    @Bean("itemQueue1")
    public Queue itemQueue(){
        return QueueBuilder.durable(ITEM_QUEUE1).build();
    }
    @Bean
    public Binding itemQueueExchange(@Qualifier("itemQueue1") Queue queue,@Qualifier("itemTopicExchange")Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("item.insert").noargs();
    }
}

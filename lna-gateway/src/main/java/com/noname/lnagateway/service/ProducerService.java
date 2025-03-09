package com.noname.lnagateway.service;

import com.noname.lnaprocessordto.MessageRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE = "custom_exchange";
    private static final String ROUTING_KEY = "queue_1";

    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendCustomDto(final MessageRequestDTO messageRequestDTO) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, messageRequestDTO);
    }
}

package com.noname.lnagateway.service;

import com.noname.lnagateway.MessageRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProducerService {

    private static final String EXCHANGE = "custom_exchange";
    private static final String ROUTING_KEY = "queue_1";

    private final RabbitTemplate rabbitTemplate;

    public void sendCustomDto(final MessageRequestDTO messageRequestDTO) {
        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, messageRequestDTO);
    }

}
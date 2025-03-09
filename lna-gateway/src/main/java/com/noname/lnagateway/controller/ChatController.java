package com.noname.lnagateway.controller;

import com.noname.lnagateway.service.ProducerService;
import com.noname.lnaprocessordto.MessageRequestDTO;
import com.noname.lnasessiondto.MessageDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class ChatController {

    private final ProducerService producerService;

    public ChatController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public MessageDTO handleMessage(@RequestBody MessageRequestDTO message) {
        System.out.println("Received message: " + message.getMessage());
        producerService.sendCustomDto(message);
        return MessageDTO.builder()
                .sender("LUNA")
                .content("TEst TEst")
                .build();
    }

}
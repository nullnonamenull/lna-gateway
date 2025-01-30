package com.noname.lnagateway.controller;

import com.noname.lnasessiondto.MessageDTO;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/session/{sessionId}/send")
    @SendTo("/topic/session/{sessionId}")
    public MessageDTO handleMessage(MessageDTO message) {
        System.out.println("Received message: " + message.getContent());
        return MessageDTO.builder()
                .sender("LUNA")
                .content("TEst TEst")
                .build();
    }

}



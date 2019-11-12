package com.xel.proxy.socket.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

	  @MessageMapping("/chat/{chatId}")
	  @SendTo("/chat/{chatId}")
	  public String handle(@DestinationVariable String chatId, String input) throws Exception {

		  return input;
	  }
	  
}

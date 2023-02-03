package org.kafka.controller;

import org.kafka.domain.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class KafkaChatController {
	
	@Autowired
	private KafkaTemplate<String, MessageVO> kafkatemplate;
	
	@Autowired
	private SimpMessagingTemplate simpmessagingtemplate;
	
	@GetMapping("/kafkachat")
	public void kafkachat() {
		
	}

	//echo 로 들어오는 메세지가 오는것입니다.
	@MessageMapping("/echo")
	public void send(@RequestBody MessageVO msg) {
		System.out.println("message is coming right?"+msg);
		kafkatemplate.send("topic", msg);
	}
	
    @KafkaListener(id = "listen1", topics = "topic")
    public void listen1(MessageVO messagevo) {
    	System.out.println("listener coming~:"+messagevo);

    	simpmessagingtemplate.convertAndSend("/topic/echo", messagevo);
    }
}

package com.idt.handler;

import com.idt.channel.Consumer;
import com.idt.channel.Producer;
import com.idt.msg.AccountMsg;
import lombok.extern.java.Log;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@EnableBinding({Consumer.class})
@Log
public class AccountHandler {
	@StreamListener(target = "account", condition = "headers['source']=='idt.one'")
	public void handleAccount0(AccountMsg accountMsg){
		log.info("[Process] source from idt.one: " + accountMsg);
	}

	@StreamListener(target = "account", condition = "headers['source']=='exchange.idt.one'")
	public void handleAccount1(AccountMsg accountMsg){
		log.info("[Process] source from exchange.idt.one: " + accountMsg);
	}

}

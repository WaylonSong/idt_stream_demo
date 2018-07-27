package com.idt.handler;

import com.idt.channel.Consumer;
import com.idt.msg.AccountMsg;
import com.idt.msg.CaptchaMsg;
import lombok.extern.java.Log;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({Consumer.class})
@Log
public class CaptchaHandler {
	@StreamListener(target = "captcha", condition = "headers['source']=='idt.one'")
	public void handleCaptcha0(CaptchaMsg captchaMsg){
		log.info("[Process] source from idt.one: " + captchaMsg);
	}
	@StreamListener(target = "captcha", condition = "headers['source']=='exchange.idt.one'")
	public void handleCaptcha1(CaptchaMsg captchaMsg){
		log.info("[Process] source from exchange.idt.one: " + captchaMsg);
	}
}

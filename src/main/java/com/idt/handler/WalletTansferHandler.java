package com.idt.handler;

import com.idt.channel.Consumer;
import com.idt.msg.CaptchaMsg;
import com.idt.msg.WalletTransferMsg;
import lombok.extern.java.Log;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({Consumer.class})
@Log
public class WalletTansferHandler {
	@StreamListener(target = "walletTransfer", condition = "headers['source']=='idt.one'")
	public void handleAccount0(WalletTransferMsg walletTransferMsg){
		log.info("[Process] source from idt.one: " + walletTransferMsg);
	}
	@StreamListener(target = "walletTransfer", condition = "headers['source']=='exchange.idt.one'")
	public void handleAccount1(WalletTransferMsg walletTransferMsg){
		log.info("[Process] source from exchange.idt.one: " + walletTransferMsg);
	}
}

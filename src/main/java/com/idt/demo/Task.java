package com.idt.demo;

import com.idt.emitter.Emitter;
import com.idt.msg.AccountMsg;
import com.idt.msg.CaptchaMsg;
import com.idt.msg.WalletTransferMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

import static java.util.UUID.randomUUID;

/**
 * Created by song on 2018/7/26.
 */
@Service
public class Task {
    @Autowired
    Emitter emitter;
    Random random = new Random();

    String[] sources = {"idt.one", "exchange.idt.one"};
    String[] currencies = {"usdt", "idt", "btc"};

    @Scheduled(cron="0/10 * * * * ? ")
    public void fireAccountEmitter(){
        AccountMsg accountMsg = new AccountMsg(random.nextLong(), randomUUID().toString(), randomUUID().toString(), randomUUID().toString(), randomUUID().toString());
        emitter.emit(accountMsg, sources[new Random().nextInt(2)]);
    }

    @Scheduled(cron="0/15 * * * * ? ")
    public void fireCaptchaEmitter(){
        emitter.emit(new CaptchaMsg(random.nextLong(), randomUUID().toString()), sources[new Random().nextInt(2)]);
    }

    @Scheduled(cron="0/15 * * * * ? ")
    public void fireWalletTransferEmitter(){
        emitter.emit(new WalletTransferMsg(random.nextLong(), randomUUID().toString(), random.nextInt(10000)), sources[new Random().nextInt(2)]);
    }


}

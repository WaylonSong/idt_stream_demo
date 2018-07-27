package com.idt.emitter;

import com.idt.channel.Producer;
import com.idt.msg.AccountMsg;
import com.idt.msg.CaptchaMsg;
import com.idt.msg.Msg;
import com.idt.msg.WalletTransferMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Service;

/**
 * Created by song on 2018/7/27.
 */
@EnableBinding({Producer.class})
@Service
public class Emitter {
    @Autowired
    @Qualifier("account_")
    private MessageChannel accountChannel;

    @Autowired
    @Qualifier("captcha_")
    private MessageChannel captchaChannel;

    @Autowired
    @Qualifier("walletTransfer_")
    private MessageChannel walletTransferChannel;

    @Deprecated
    public void emit(Msg msg) {
        getMessageChannelByMsg(msg).send(MessageBuilder.withPayload(msg).build());
    }

    public void emit(Msg msg, MessageHeaderAccessor messageHeaderAccessor){
        getMessageChannelByMsg(msg).send(MessageBuilder.withPayload(msg).setHeaders(messageHeaderAccessor).build());
    }

    public void emit(Msg msg, String source){
        getMessageChannelByMsg(msg).send(MessageBuilder.withPayload(msg).setHeader("source", source).build());
    }

    private MessageChannel getMessageChannelByMsg(Msg msg){
        if(msg instanceof AccountMsg)
            return accountChannel;
        if(msg instanceof CaptchaMsg)
            return captchaChannel;
        if(msg instanceof WalletTransferMsg)
            return walletTransferChannel;
        return null;
    }

}

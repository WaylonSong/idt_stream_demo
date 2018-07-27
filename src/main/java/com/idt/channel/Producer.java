package com.idt.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by song on 2018/5/11.
 */
public interface Producer {

    @Output
    MessageChannel account_();

    @Output
    MessageChannel captcha_();

    @Output
    MessageChannel walletTransfer_();

}
package com.idt.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by song on 2018/5/11.
 */
public interface Consumer {

    @Input
    SubscribableChannel account();

    @Input
    SubscribableChannel captcha();

    @Input
    SubscribableChannel walletTransfer();

}
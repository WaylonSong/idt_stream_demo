package com.idt.msg;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by song on 2018/7/26.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WalletTransferMsg implements Msg {
    long userId;
    String currency;
    double amount;
}

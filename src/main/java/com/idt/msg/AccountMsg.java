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
@ToString(exclude="password")
public class AccountMsg implements Msg {
    long userId;
    String name;
    String password;//统一加密算法
    String mobile;
    String email;
}

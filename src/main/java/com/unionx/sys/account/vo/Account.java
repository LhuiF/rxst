package com.unionx.sys.account.vo;

import com.unionx.core.security.shiro.UserAccount;
import lombok.Data;

/**
 * Created by abner on 2016/5/17.
 */
@Data
public class Account extends UserAccount {
    private String deleted;
}

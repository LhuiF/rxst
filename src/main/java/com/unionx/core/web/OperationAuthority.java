package com.unionx.core.web;

import com.unionx.core.security.shiro.UserDetails;
import org.apache.shiro.SecurityUtils;
import java.io.Serializable;
import java.util.List;

/**
 * Created by abner on 2016/5/9.
 */
public class OperationAuthority implements Serializable{


    public static Boolean hasPermission(String buttonId) {
        UserDetails userDetails = (UserDetails) SecurityUtils.getSubject().getPrincipal();
        List<String> buttonList = userDetails.getButtonList();
        for (String bl : buttonList) {
            if (bl.equals(buttonId)) {
                return true;
            }
        }
        return false;
    }
}

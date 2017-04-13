package com.unionx.core.web.function;

import com.unionx.core.security.shiro.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import java.util.List;

/**
 * Created by abner on 2016/5/9.
 */
@Slf4j
public class OperationAuthorityFunction{

    /**
     * 根据按钮id查询当前用户是否有权限显示按钮
     * @author abner
     * @param buttonId
     * @return
     */
    public static boolean hasPermission(String buttonId) {
        try {
            UserDetails userDetails = (UserDetails) SecurityUtils.getSubject().getPrincipal();
            List<String> buttonList = userDetails.getButtonList();
            for (String bl : buttonList) {
                if (bl.equals(buttonId)) {
                    return true;
                }
            }
        } catch (Exception e) {
            log.error("",e);
        }
        return false;
    }
}

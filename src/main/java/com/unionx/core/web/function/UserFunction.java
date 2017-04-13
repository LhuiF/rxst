package com.unionx.core.web.function;

import com.unionx.core.util.JsonUtils;
import com.unionx.core.util.SpringContextUtil;
import com.unionx.sys.user.service.UserService;
import com.unionx.sys.user.vo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abner
 */
public class UserFunction {
    /**
     * 根据岗位编码返回该岗位用户列表
     *
     * @return
     * @author abner
     */
    public static String getUserListByPost(String post) {
        try {
            UserService userService = SpringContextUtil.getBean("userService", UserService.class);
            List<User> list = userService.getUserListByPost(post);
            List<User> userList = new ArrayList<>();
            if (list != null && list.size()!=0) {
                for (User u:list) {
                    u.setName(u.getName() + "【" + u.getLoginName() + "】");
                    userList.add(u);
                }
                return JsonUtils.writeValueAsString(userList);
            } else {
                return "[]";
            }
        } catch (Exception e) {
            return "[]";
        }
    }
    /**
     * 根据岗位编码返回该岗位用户列表 带登录帐号
     * @author xuchengibn
     * @return
     */
    public static String getUserToPost(String post) {
        try {
            UserService userService = SpringContextUtil.getBean("userService", UserService.class);
            List<User> userList = userService.getUserListByPost(post);
            List<User> list = new ArrayList<User>();
                for (User u : userList) {
                    u.setName(u.getName() + "【" + u.getLoginName() + "】");
                    list.add(u);
                }
            if (userList != null) {
                return JsonUtils.writeValueAsString(list);
            } else {
                return "[]";
            }
        } catch (Exception e) {
            return "[]";
        }
    }
}

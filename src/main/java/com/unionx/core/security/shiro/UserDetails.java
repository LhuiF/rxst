package com.unionx.core.security.shiro;

import com.unionx.core.util.JsonUtils;
import com.unionx.sys.module.vo.Module;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 认证用户的信息
 * @author songjunejie
 */
@Data
@Getter
@Setter
public class UserDetails implements Serializable{

    private String id;
    private String name;//用户名称
    private String loginName;//登录帐号
    private List<String> roleList;// 角色集合
    private List<Module> moduleList;// 资源集合
    private List<String> buttonList;//按钮集合
    private String host;//主机IP

    /**
     * 用json的格式输出
     *
     * @return
     */
    public String toString() {
        return JsonUtils.writeValueAsString(this, null, true);
    }

	
}

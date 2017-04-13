package com.unionx.core.web.function;

import com.unionx.core.enums.ServiceTypeEnum;
import com.unionx.core.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 返回岗位数据
 *
 * @author xuchengbin
 */
@Slf4j
public class TrackFunction {


    /**
     *   人工追踪 返回分类code和名字映射表
     * @return
     */
    public static String typeToName() {
        return JsonUtils.writeValueAsString(ServiceTypeEnum.toMap());
    }

}

package com.unionx.core.web;

import lombok.Data;

/**
 * 用于proxy向上抛异常
 * Created by abner on 2016/4/19.
 */
@Data
public class BizException extends RuntimeException {

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }
}

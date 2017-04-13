package com.unionx.core.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by walden on 2016/9/12.
 */
@Data
@Component
public class InitConfigValue {
    @Value("${report.server.url}")
    public String reportServerUrl;
}


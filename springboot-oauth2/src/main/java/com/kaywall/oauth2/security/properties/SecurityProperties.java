package com.kaywall.oauth2.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * security配置properties
 * @author lijian
 * @date 2018年8月24日17:04:57
 */
@Component
@ConfigurationProperties(prefix = "security.oauth2.resource")
@Data
public class SecurityProperties {
    private Integer filterOrder;
}


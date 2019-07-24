package com.kaywall.oauth2.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * authentication 授权应用配置
 * @author lijian
 * @date 2018年8月24日17:04:57
 */
@Component
@ConfigurationProperties(prefix = "authentication.oauth")
@Data
public class OauthProperties {
    private String clientid;
	private String secret;
	private Integer accessTokenValiditySeconds = 24*60*60;
	private Integer refreshTokenValiditySeconds = 7200;
}


package com.kaywall.oauth2.security.config;

import com.kaywall.oauth2.security.properties.OauthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 *  配置OAuth2验证服务器
 * @author aikaiqiang
 * @date 2019年07月24日 16:34
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private OauthProperties oauthProperties;

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients()
				.tokenKeyAccess("isAuthenticated()")
				.checkTokenAccess("permitAll()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory() // 使用in-memory存储
				.withClient(oauthProperties.getClientid()) // client_id用来标识客户的Id
				.secret(oauthProperties.getSecret()) //secret客户端安全码
				.scopes("read", "write") //允许授权范围
				.authorities("ROLE_ADMIN","ROLE_USER") //客户端可以使用的权限
				.authorizedGrantTypes("password", "refresh_token", "authorization_code") //允许授权类型
				.accessTokenValiditySeconds(oauthProperties.getAccessTokenValiditySeconds())
				.refreshTokenValiditySeconds(oauthProperties.getRefreshTokenValiditySeconds());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore)
				.authenticationManager(authenticationManager) ;
	}


}

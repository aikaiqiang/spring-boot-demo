package com.kaywall.oauth2.security.handler;

import com.kaywall.oauth2.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  自定义登出控制
 * @author aikaiqiang
 * @date 2019年07月24日 16:24
 */
public class CustomLogoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements
		LogoutSuccessHandler {

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {

		String token = httpServletRequest.getHeader(CommonConstant.HEADER_AUTHORIZATION);
		if (token!=null && token.startsWith(CommonConstant.AUTHENTICATION_TOKEN_PREFIX)){
			OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(token.split(" ")[0]);
			if (oAuth2AccessToken!=null){
				tokenStore.removeAccessToken(oAuth2AccessToken);
			}
		}
	}
}

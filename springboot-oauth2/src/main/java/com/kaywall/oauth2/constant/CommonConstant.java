package com.kaywall.oauth2.constant;

/**
 *  E
 * @author aikaiqiang
 * @date 2019年07月24日 16:11
 */
public class CommonConstant {

	/**
	 * jwt signingKey
	 */
	public static final String  JWT_SIGNNING_KEY = "kaywall";
	/**
	 * 请求 authorization token 头信息前缀
	 */
	public static final String AUTHENTICATION_TOKEN_PREFIX = "Bearer ";
	/**
	 * oauth2登录authorization头信息前缀
	 */
	public static final String AUTHENTICATION_HEADER_PREFIX = "Basic ";
	/**
	 * 请求 HEADER_AUTHORIZATION
	 */
	public static final String HEADER_AUTHORIZATION = "Authorization";
}

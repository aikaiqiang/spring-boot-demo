package com.kaywall.oauth2.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *  自定义 UserDetailsService
 * @author aikaiqiang
 * @date 2019年07月24日 17:22
 */
public class CustomUserService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return null;
	}
}

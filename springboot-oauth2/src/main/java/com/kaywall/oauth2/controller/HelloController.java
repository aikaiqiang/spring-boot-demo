package com.kaywall.oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  E
 * @author aikaiqiang
 * @date 2019年07月24日 15:54
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index(){
		return "index" ;
	}

	@RequestMapping("/hello")
	public String hello(){
		return "hello" ;
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}

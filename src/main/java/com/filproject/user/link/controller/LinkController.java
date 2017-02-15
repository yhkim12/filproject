package com.filproject.user.link.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinkController {

	@RequestMapping(value={"/", "/login"})
	public String login() {
		
		return "login";
	}
}

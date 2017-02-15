package com.filproject.user.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InformationController {

	@RequestMapping(value={"/", "/login"})
	public String login() {
		
		return "login";
	}
}

package com.silverblaze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

//	@ResponseBody
//	@RequestMapping("/")
//	public String ola() {
//		return "Hello! How are you?";
//	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

}

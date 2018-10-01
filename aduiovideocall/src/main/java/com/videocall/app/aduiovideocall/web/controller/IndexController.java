package com.videocall.app.aduiovideocall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public String showIndexPage(){
		return "index";
	}

	@GetMapping("/subjectLevel")
	public String subjectLevelPage(){
		return "views/subjectLevel";
	}

	@GetMapping("/loadWait")
	public String loadWaitPage(){
		return "views/loadWait";
	}

	@GetMapping("/videoChat")
	public String videoChat(){
		return "video";
	}
	@GetMapping("/login")
	public String loginForm(){
		return "views/loginForm";
	}


	@GetMapping("/subjectTopic")
	public String subjectTopic(){
		return "views/subjectTopic";
	}
}

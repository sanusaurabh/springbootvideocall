package com.videocall.app.aduiovideocall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
//	@GetMapping("/favicon.ico")
//	public String showIndexPage(){
//		return "index";
//	}
	
	@RequestMapping(value={"/", "page*","view/*,**/msg"})
	public ModelAndView indexMultipleMapping(){
	     return new ModelAndView("index.html");
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

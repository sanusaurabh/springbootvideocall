package com.videocall.app.aduiovideocall.web.controller;

import com.videocall.app.aduiovideocall.web.entity.ActiveUserStore;
import com.videocall.app.aduiovideocall.web.entity.User;
import com.videocall.app.aduiovideocall.web.srvice.TaskService;
import com.videocall.app.aduiovideocall.web.srvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProfileController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@Autowired
	private SessionRegistry sessionRegistry;


	
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal , HttpSession httpSession){

		String email =principal.getName();

		User user =userService.findOne(email);

		if(user.getRoles().get(0).getName().equals("USER"))
			return "views/subjectLevel";
		if(user.getRoles().get(0).getName().equals("TEACHER"))
			return "teacherVideo";
		//httpSession.setAttribute("user", user);
		model.addAttribute("tasks", taskService.findUserTask(user));
		model.addAttribute("users",  getUsersFromSessionRegistry());
		return "views/profile";
	}

	@PostMapping("/logout1")
	public void logout(HttpServletRequest request , HttpSession httpSession){

		//String email =principal.getName();

		//User user =userService.findOne(email);
		//httpSession.removeAttribute(user.getName());
	//	httpSession.invalidate();
		if (request.getSession() != null){
			httpSession.removeAttribute("user");
		}
		//return "views/loginForm";
	}




	public List<String> getUsersFromSessionRegistry() {
		return sessionRegistry.getAllPrincipals().stream()
				.filter(u -> !sessionRegistry.getAllSessions(u, false).isEmpty())
				.map(Object::toString)
				.collect(Collectors.toList());
	}
}

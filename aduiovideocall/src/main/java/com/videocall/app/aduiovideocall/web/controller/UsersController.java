package com.videocall.app.aduiovideocall.web.controller;

import com.videocall.app.aduiovideocall.web.entity.Student;
import com.videocall.app.aduiovideocall.web.entity.Teacher;
import com.videocall.app.aduiovideocall.web.entity.User;
import com.videocall.app.aduiovideocall.web.repositories.UserRepository;
import com.videocall.app.aduiovideocall.web.srvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/users")
	public String registerForm(Model model, @RequestParam(defaultValue="0") int page){
		//model.addAttribute("users", userService.findAll());


		Page<User> userlist=userRepository.findAll(new PageRequest(page, 4));
		List<Student> studentList = new ArrayList<>();
		for(User user : userlist){
			if("USER".equals(user.getRoles().get(0).getName()))
				studentList.add(new Student(user.getEmail(),user.getName()));
		}
		model.addAttribute("users", studentList);
		model.addAttribute("currentPage", page);
		return "views/list";
	}
	
	@GetMapping("/searchUsers")
	public String searchsregisterUser(Model model, @RequestParam(defaultValue="") String name){
		model.addAttribute("users", userService.findByName("%"+name+"%"));
		return "views/list";
	}
}

package com.videocall.app.aduiovideocall.web.controller;


import com.videocall.app.aduiovideocall.web.entity.Country;
import com.videocall.app.aduiovideocall.web.entity.Teacher;
import com.videocall.app.aduiovideocall.web.entity.User;
import com.videocall.app.aduiovideocall.web.repositories.CountryRepository;
import com.videocall.app.aduiovideocall.web.repositories.UserRepository;
import com.videocall.app.aduiovideocall.web.srvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.dk.DkCrypto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TeacherController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/showPage")
	public String showPage(Model model, @RequestParam(defaultValue="0") int page){
		Page<User> userlist=userRepository.findAll(new PageRequest(page, 4));
		List<Teacher> teachersList = new ArrayList<>();
		for(User user : userlist){
			if("TEACHER".equals(user.getRoles().get(0).getName()))
			teachersList.add(new Teacher(user.getEmail(),user.getName(),user.getPassword()));
		}


		model.addAttribute("data", teachersList);
		model.addAttribute("currentPage", page);
		return "showPage";
		
	}

	@GetMapping("/searchTeachers")
	public String searchsregisterUser(Model model, @RequestParam(defaultValue="") String name){
		List<User> users =userRepository.findByNameLike("%"+name+"%");
		//List<User> userlist =users.stream().filter(user-> "TEACHER".equals(user.getRoles().get(0))).collect(Collectors.toList());
		List<Teacher> teachersList = new ArrayList<>();
		for(User user : users){
			if("TEACHER".equals(user.getRoles().get(0).getName()))
			teachersList.add(new Teacher(user.getEmail(),user.getName(),user.getPassword()));
		}
		model.addAttribute("data", teachersList);
		return "showPage";
	}
	@PostMapping("/save")
	public String saveCountry(Teacher teacher){
		userService.createTeacher(new User(teacher.getEmail(),teacher.getName(),teacher.getPassword()));
		//userRepository.save(new User())
		return"redirect:/showPage";
	}
	
	
	@GetMapping("/delete")
	public String deleteCountry(String emailId){
		userRepository.deleteById(emailId);
		return"redirect:/showPage";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Teacher findOne(String emailId){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		User user =userRepository.findById(emailId).get();
		Teacher teacher =new Teacher(user.getEmail(),user.getName(),user.getPassword());
		return teacher;
		
	}
}

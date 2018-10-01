package com.videocall.app.aduiovideocall.web.srvice;

import com.videocall.app.aduiovideocall.web.entity.Role;
import com.videocall.app.aduiovideocall.web.entity.User;
import com.videocall.app.aduiovideocall.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public void createUser(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role roleUser = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(roleUser);
		user.setRoles(roles);
		user.setIsaccountaccessable(1);

		repository.save(user);

	}

	public void createAdmin(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role roleUser = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(roleUser);
		user.setRoles(roles);

		repository.save(user);

	}
	public void createTeacher(User user) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role roleUser = new Role("TEACHER");
		List<Role> roles = new ArrayList<>();
		roles.add(roleUser);
		user.setRoles(roles);

		repository.save(user);

	}

	public User findOne(String email) {

		return repository.findById(email).get();
	}

	public boolean isUserPresent(String email) {
		 
		return repository.findById(email).isPresent();
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findByNameLike(name);
	}

}

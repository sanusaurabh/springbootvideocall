package com.videocall.app.aduiovideocall.web.repositories;

import com.videocall.app.aduiovideocall.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

	List<User> findByNameLike(String name);
	public User findUserByEmail(String email);



	 

}

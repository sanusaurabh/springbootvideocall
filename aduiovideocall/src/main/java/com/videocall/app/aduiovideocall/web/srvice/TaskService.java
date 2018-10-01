package com.videocall.app.aduiovideocall.web.srvice;

import com.videocall.app.aduiovideocall.web.entity.Task;
import com.videocall.app.aduiovideocall.web.entity.User;
import com.videocall.app.aduiovideocall.web.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;
	
	public void addTask(Task task, User user){
		
		task.setUser(user);
		repository.save(task);
		
	}
	
	public List<Task> findUserTask(User user){
		
		return repository.findByUser(user);
	}
}

package com.videocall.app.aduiovideocall.web.repositories;

import com.videocall.app.aduiovideocall.web.entity.Task;
import com.videocall.app.aduiovideocall.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}

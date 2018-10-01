package com.videocall.app.aduiovideocall;


import com.videocall.app.aduiovideocall.web.entity.ActiveUserStore;
import com.videocall.app.aduiovideocall.web.entity.Country;
import com.videocall.app.aduiovideocall.web.entity.User;
import com.videocall.app.aduiovideocall.web.repositories.CountryRepository;
import com.videocall.app.aduiovideocall.web.srvice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;


@SpringBootApplication

public class AduiovideocallApplication implements CommandLineRunner {
@Autowired
    private UserService userService;

    @Autowired
    private CountryRepository countryRepository;
	public static void main(String[] args) {
		SpringApplication.run(AduiovideocallApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        User newAdmin = new  User("admin@mail.com", "Admin", "123456");
        User newUser = new  User("san.619jaan@gmail.com", "sanu", "123456");
        User newTeacher = new  User("san.61jaan@gmail.com", "sanu1", "123456");
        User newTeacher1 = new  User("san.6jaan@gmail.com", "sanu1", "123456");
        User newUser1 = new  User("san.6191jaan@gmail.com", "sanu", "123456");
        User newTeacher2 = new  User("san.jaan@gmail.com", "sanu1", "123456");
        User newUser2 = new  User("san.6192jaan@gmail.com", "sanu", "123456");
        userService.createAdmin(newAdmin);
        userService.createUser(newUser);
        userService.createTeacher(newTeacher);
        userService.createUser(newUser1);
        userService.createTeacher(newTeacher1);
        userService.createUser(newUser2);
        userService.createTeacher(newTeacher2);

    }
    @Bean
    public ActiveUserStore activeUserStore(){
        return new ActiveUserStore();
    }

}

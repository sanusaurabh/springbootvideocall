package com.videocall.app.aduiovideocall.web.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {
	@Id
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min = 4)
	private String password;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Task> tasks;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLES", joinColumns = {
			@JoinColumn(name = "USER_EMAIL", referencedColumnName = "email") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")

	})

	private List<Role> roles;

    private int isaccountaccessable;

    private int isuseractive;

    private String subjectcallAttender;

	public User() {

	}

	public User(String email, String name, String password) {

		this.email = email;
		this.name = name;
		this.password = password;
		this.isaccountaccessable=isaccountaccessable;
		this.isuseractive=isuseractive;
		this.subjectcallAttender=subjectcallAttender;

	}


    public User(String email, String name, String password,int isaccountaccessable,int isuseractive, String subjectcallAttender) {

        this.email = email;
        this.name = name;
        this.password = password;
        this.isaccountaccessable=isaccountaccessable;
        this.isuseractive=isuseractive;
        this.subjectcallAttender=subjectcallAttender;

    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTask() {
		return tasks;
	}

	public void setTask(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

    public int getIsaccountaccessable() {
        return isaccountaccessable;
    }

    public void setIsaccountaccessable(int isaccountaccessable) {
        this.isaccountaccessable = isaccountaccessable;
    }

    public int getIsuseractive() {
        return isuseractive;
    }

    public void setIsuseractive(int isuseractive) {
        this.isuseractive = isuseractive;
    }

    public String getSubjectcallAttender() {
        return subjectcallAttender;
    }

    public void setSubjectcallAttender(String subjectcallAttender) {
        this.subjectcallAttender = subjectcallAttender;
    }
}

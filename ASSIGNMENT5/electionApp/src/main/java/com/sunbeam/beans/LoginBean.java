package com.sunbeam.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;

	
	
	public LoginBean() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User authenticate() {
		
		try(UserDao ud = new UserDaoImpl()) {
			
			user=ud.findByEmail(email);
			if(user!=null && password.equals(user.getPassword())) //password =set by the parameter, user.getPassword() = password from database
				return user;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}
}






package com.qing.mapper;

import org.springframework.stereotype.Component;

import com.qing.user.User;

@Component
public interface UserDao {

	public User login(User user) throws Exception;
	
	public int checkNameExists(String name) throws Exception;
	
	public int checkIpExists(String ip) throws Exception;
	
	public void addUser(User user) throws Exception;
	
	public User loadUserByIp(String ip) throws Exception;
}

package com.qing.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qing.mapper.UserDao;
import com.qing.util.StringUtils;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public User login(User user) throws Exception {
		if(dao.checkNameExists(user.getUsername()) < 1) {
			user.setCode(21);
			return user;
		}
		
		User u = dao.login(user);
		if(u == null)
			user.setCode(22);
		else {
			user = u;
			user.setCode(20);
		}
		return user;
	}
	
	public User registe(User user) throws Exception {
//		if(dao.checkNameExists(user.getUsername()) > 0) {
//			user.setCode(11);
//			return user;
//		}
		user.setId(StringUtils.getUUID());
		dao.addUser(user);
		user.setCode(10);
		return user;
	}
	
	public User loadUserByIp(String ip) throws Exception {
		User user = new User();
		if(dao.checkIpExists(ip) < 1) {
			user.setCode(31);
			return user;
		}
		
		user = dao.loadUserByIp(ip);
		user.setCode(30);
		return user;
	}
}

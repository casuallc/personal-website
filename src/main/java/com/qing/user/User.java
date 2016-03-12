package com.qing.user;

public class User {

	private String id;
	private String username;
	private String password;
	private String ip;
	private long registeTime;
	private long loginTimes;
	
	private int code;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public long getRegisteTime() {
		return registeTime;
	}

	public void setRegisteTime(long registeTime) {
		this.registeTime = registeTime;
	}

	public long getLoginTimes() {
		return loginTimes;
	}

	public void setLoginTimes(long loginTimes) {
		this.loginTimes = loginTimes;
	}

}

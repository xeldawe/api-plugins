package com.xel.smartshop.bean;

public class TwitchLogin {
	
	public TwitchLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TwitchLogin(String token) {
		super();
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}

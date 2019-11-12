package com.xel.smartshop.bean;

import com.xel.twitch.bean.TwitchAuthBean;
import com.xel.twitch.bean.TwitchUserBean;

public class TwitchLoginData {

	public TwitchLoginData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TwitchLoginData(TwitchAuthBean auth, TwitchUserBean user) {
		super();
		this.auth = auth;
		this.user = user;
	}

	private TwitchAuthBean auth;
	private TwitchUserBean user;
	public TwitchAuthBean getAuth() {

		return auth;
	}

	public void setAuth(TwitchAuthBean auth) {
		this.auth = auth;
	}

	public TwitchUserBean getUser() {
		return user;
	}

	public void setUser(TwitchUserBean user) {
		this.user = user;
	}

}

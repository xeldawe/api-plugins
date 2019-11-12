package com.xel.proxy.socket.chat.bean;

import java.sql.Timestamp;

public class ChatData {

	private Timestamp time;
	private String userDisplayName;
	private String message;
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getUserDisplayName() {
		return userDisplayName;
	}
	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}

package com.xel.twitch.service.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchReedemCodeRequestHelperBean {
	private String code;
	private String[] codes;
	@JsonProperty("user_id")
	private String userId;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String[] getCodes() {
		return codes;
	}

	public void setCodes(String[] codes) {
		this.codes = codes;
	}
	
}

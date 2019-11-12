package com.xel.twitch.service.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchBroadcasterSubscriptionsRequestHelperBean {

	@JsonProperty("broadcaster_id")
	private String broadcasterId;
	
	@JsonProperty("user_id")
	private String userId;

	public String getBroadcasterId() {
		return broadcasterId;
	}

	public void setBroadcasterId(String broadcasterId) {
		this.broadcasterId = broadcasterId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

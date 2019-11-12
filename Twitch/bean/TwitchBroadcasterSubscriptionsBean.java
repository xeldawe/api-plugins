package com.xel.twitch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchBroadcasterSubscriptionsBean {

	@JsonProperty("broadcaster_id")
	private String broadcasterId;
	@JsonProperty("broadcaster_name")
	private String broadcasterName;
	@JsonProperty("is_gift")
	private boolean isGift; // Type of subscription (Tier 1, Tier 2, Tier 3). 1000 = Tier 1, 2000 = Tier 2,
							// 3000 = Tier 3 subscriptions.
	private String tier;
	@JsonProperty("plan_name")
	private String planName;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("user_name")
	private String userName;
	public String getBroadcasterId() {
		return broadcasterId;
	}
	public void setBroadcasterId(String broadcasterId) {
		this.broadcasterId = broadcasterId;
	}
	public String getBroadcasterName() {
		return broadcasterName;
	}
	public void setBroadcasterName(String broadcasterName) {
		this.broadcasterName = broadcasterName;
	}
	public boolean isGift() {
		return isGift;
	}
	public void setGift(boolean isGift) {
		this.isGift = isGift;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}



}

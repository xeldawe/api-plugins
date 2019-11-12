package com.xel.twitch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchUserBean {

	private String id;
	private String login;
	@JsonProperty("display_name")
	private String displayName;
	private String type;
	@JsonProperty("broadcaster_type")
	private String broadcasterType;
	private String description;
	@JsonProperty("profile_image_url")
	private String profileImageUrl;
	@JsonProperty("offline_image_url")
	private String offlineImageUrl;
	@JsonProperty("view_count")
	private int viewCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBroadcasterType() {
		return broadcasterType;
	}

	public void setBroadcasterType(String broadcasterType) {
		this.broadcasterType = broadcasterType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getOfflineImageUrl() {
		return offlineImageUrl;
	}

	public void setOfflineImageUrl(String offlineImageUrl) {
		this.offlineImageUrl = offlineImageUrl;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "TwitchUserBean [id=" + id + ", login=" + login + ", displayName=" + displayName + ", type=" + type
				+ ", broadcasterType=" + broadcasterType + ", description=" + description + ", profileImageUrl="
				+ profileImageUrl + ", offlineImageUrl=" + offlineImageUrl + ", viewCount=" + viewCount + "]";
	}

}

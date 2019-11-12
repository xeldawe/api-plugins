package com.xel.twitch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchStreamsMetadataBean {

	@JsonProperty("game_id")
	private String gameId;
	private Overwatch overwatch;
	private Hearthstone hearthstone;
	@JsonProperty("userId")
	private String user_id;
	@JsonProperty("user_name")
	private String userName;
	private String pagination;

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Overwatch getOverwatch() {
		return overwatch;
	}

	public void setOverwatch(Overwatch overwatch) {
		this.overwatch = overwatch;
	}

	public Hearthstone getHearthstone() {
		return hearthstone;
	}

	public void setHearthstone(Hearthstone hearthstone) {
		this.hearthstone = hearthstone;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

}

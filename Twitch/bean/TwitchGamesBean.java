package com.xel.twitch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchGamesBean {

	@JsonProperty("box_art_url")
	private Object boxArtUrl;
	private String id;
	private String name;

	public Object getBoxArtUrl() {
		return boxArtUrl;
	}

	public void setBoxArtUrl(Object boxArtUrl) {
		this.boxArtUrl = boxArtUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

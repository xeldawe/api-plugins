 package com.xel.smartshop.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchTopGames {

	@JsonProperty("box_art_url")
	private Object boxArtUrl;
	private String id;
	private String name;
	private String pagination;

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

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

}

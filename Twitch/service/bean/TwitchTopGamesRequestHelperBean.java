package com.xel.twitch.service.bean;

public class TwitchTopGamesRequestHelperBean {
	private String after;
	private String before;
	private Integer first;

	public String getAfter() {
		return after;
	}

	public void setAfter(String after) {
		this.after = after;
	}

	public String getBefore() {
		return before;
	}

	public void setBefore(String before) {
		this.before = before;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

}

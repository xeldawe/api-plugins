package com.xel.twitch.old.service.bean;

public class KrakenStreamsRequestHelperBean {

	private String channel;
	private String game;
	private String language;
	private Integer streamType;
	private String limit;
	private String offset;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getStreamType() {
		return streamType;
	}

	public void setStreamType(Integer streamType) {
		this.streamType = streamType;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

}

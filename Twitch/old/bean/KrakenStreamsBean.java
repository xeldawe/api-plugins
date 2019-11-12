package com.xel.twitch.old.bean;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xel.twitch.old.common.bean.Channel;
import com.xel.twitch.old.common.bean.PreviewBean;

public class KrakenStreamsBean {

	@JsonProperty("_id")
	private String id;
	private String game;
	private int viewers;
	@JsonProperty("video_height")
	private int videoHeight;
	@JsonProperty("average_fps")
	private double averageFps;
	private int delay;
	@JsonProperty("created_at")
	private Timestamp createdAt;
	@JsonProperty("is_playlist")
	private boolean isPlaylist;
	@JsonProperty("stream_type")
	private String streamType;
	private PreviewBean preview;
	private Channel channel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public int getViewers() {
		return viewers;
	}

	public void setViewers(int viewers) {
		this.viewers = viewers;
	}

	public int getVideoHeight() {
		return videoHeight;
	}

	public void setVideoHeight(int videoHeight) {
		this.videoHeight = videoHeight;
	}

	public double getAverageFps() {
		return averageFps;
	}

	public void setAverageFps(double averageFps) {
		this.averageFps = averageFps;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public boolean isPlaylist() {
		return isPlaylist;
	}

	public void setPlaylist(boolean isPlaylist) {
		this.isPlaylist = isPlaylist;
	}

	public String getStreamType() {
		return streamType;
	}

	public void setStreamType(String streamType) {
		this.streamType = streamType;
	}

	public PreviewBean getPreview() {
		return preview;
	}

	public void setPreview(PreviewBean preview) {
		this.preview = preview;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

}

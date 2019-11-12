package com.xel.twitch.bean;

import java.sql.Timestamp;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchStreamsBean {

	private String id;
	@JsonProperty("user_id")
	private String userId;
	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("game_id")
	private String gameId;
	@JsonProperty("community_ids")
	private String[] communityIds;
	private String type;
	private String title;
	@JsonProperty("viewer_count")
	private int viewerCount;
	@JsonProperty("started_at")
	private Timestamp startedAt;
	private String language;
	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;
	@JsonProperty("tag_ids")
	private String[] tagIds;
	private String pagination;

	public String getPagination() {
		return pagination;
	}

	public void setPagination(String pagination) {
		this.pagination = pagination;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String[] getCommunityIds() {
		return communityIds;
	}

	public void setCommunityIds(String[] communityIds) {
		this.communityIds = communityIds;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewerCount() {
		return viewerCount;
	}

	public void setViewerCount(int viewerCount) {
		this.viewerCount = viewerCount;
	}

	public Timestamp getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(Timestamp startedAt) {
		this.startedAt = startedAt;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String[] getTagIds() {
		return tagIds;
	}

	public void setTagIds(String[] tagIds) {
		this.tagIds = tagIds;
	}

	@Override
	public String toString() {
		return "TwitchStreamBean [id=" + id + ", userId=" + userId + ", userName=" + userName + ", gameId=" + gameId
				+ ", communityIds=" + Arrays.toString(communityIds) + ", type=" + type + ", title=" + title
				+ ", viewerCount=" + viewerCount + ", startedAt=" + startedAt + ", language=" + language
				+ ", thumbnailUrl=" + thumbnailUrl + ", tagIds=" + Arrays.toString(tagIds) + "]";
	}

}

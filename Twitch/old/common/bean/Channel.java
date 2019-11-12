package com.xel.twitch.old.common.bean;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Channel {

	private boolean mature;
	private boolean partner;
	private String status;
	@JsonProperty("broadcaster_language")
	private String broadcasterLanguage;
	@JsonProperty("broadcaster_software")
	private String broadcasterSoftware;
	@JsonProperty("display_name")
	private String displayName;
	private String game;
	private String language;
	@JsonProperty("_id")
	private long id;
	private String name;
	@JsonProperty("created_at")
	private Timestamp createdAt;
	@JsonProperty("updated_at")
	private Timestamp updatedAt;
	private int delay;
	private String logo;
	private String banner;
	@JsonProperty("video_banner")
	private String videoBanner;
	private String background;
	@JsonProperty("profile_banner")
	private String profileBanner;
	@JsonProperty("profile_banner_background_color")
	private String profileBannerBackgroundColor;
	private String url;
	private int views;
	private int followers;

	public boolean isMature() {
		return mature;
	}

	public void setMature(boolean mature) {
		this.mature = mature;
	}

	public boolean isPartner() {
		return partner;
	}

	public void setPartner(boolean partner) {
		this.partner = partner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBroadcasterLanguage() {
		return broadcasterLanguage;
	}

	public void setBroadcasterLanguage(String broadcasterLanguage) {
		this.broadcasterLanguage = broadcasterLanguage;
	}

	public String getBroadcasterSoftware() {
		return broadcasterSoftware;
	}

	public void setBroadcasterSoftware(String broadcasterSoftware) {
		this.broadcasterSoftware = broadcasterSoftware;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getVideoBanner() {
		return videoBanner;
	}

	public void setVideoBanner(String videoBanner) {
		this.videoBanner = videoBanner;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getProfileBanner() {
		return profileBanner;
	}

	public void setProfileBanner(String profileBanner) {
		this.profileBanner = profileBanner;
	}

	public String getProfileBannerBackgroundColor() {
		return profileBannerBackgroundColor;
	}

	public void setProfileBannerBackgroundColor(String profileBannerBackgroundColor) {
		this.profileBannerBackgroundColor = profileBannerBackgroundColor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

}

package com.xel.twitch.old.common.bean;

public class LogoBean {

	private String large;
	private String medium;
	private String small;
	private String template;

	public String getLarge() {
		return large;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "LogoBean [large=" + large + ", medium=" + medium + ", small=" + small + ", template=" + template + "]";
	}

}

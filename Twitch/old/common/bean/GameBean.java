package com.xel.twitch.old.common.bean;

public class GameBean {

	private BoxBean box;
	private LogoBean logo;
	public BoxBean getBox() {
		return box;
	}
	public void setBox(BoxBean box) {
		this.box = box;
	}
	public LogoBean getLogo() {
		return logo;
	}
	public void setLogo(LogoBean logo) {
		this.logo = logo;
	}
	@Override
	public String toString() {
		return "GameBean [box=" + box + ", logo=" + logo + "]";
	}
	
	
	
}

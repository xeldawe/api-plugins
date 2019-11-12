package com.xel.twitch.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hero {

	private String type;
	@JsonProperty("class")
	private String heroClass;
	private String name;
	private String ability;
	private String role;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHeroClass() {
		return heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

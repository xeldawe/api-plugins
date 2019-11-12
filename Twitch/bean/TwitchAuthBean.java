package com.xel.twitch.bean;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwitchAuthBean {
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private long expiresIn;
	@JsonProperty("id_token")
	private String idToken;
	@JsonProperty("refresh_token")
	private String refreshToken;
	private String[] scope;
	@JsonProperty("token_type")
	private String tokenType;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String[] getScope() {
		return scope;
	}

	public void setScope(String[] scope) {
		this.scope = scope;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@Override
	public String toString() {
		return "TwitchAuthBean [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", idToken=" + idToken
				+ ", refreshToken=" + refreshToken + ", scope=" + Arrays.toString(scope) + ", tokenType=" + tokenType
				+ "]";
	}

}

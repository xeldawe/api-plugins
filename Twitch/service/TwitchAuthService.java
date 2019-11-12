package com.xel.twitch.service;

import org.springframework.http.HttpMethod;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.EncodingMode;
import com.jsoniter.output.JsonStream;
import com.xel.twitch.bean.TwitchAuthBean;
import com.xel.twitch.config.TwitchConfig;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;

public class TwitchAuthService extends TwitchServiceCore {

	public String getLoginUrl() {
		StringBuilder sb = new StringBuilder();
		sb.append("https://id.twitch.tv/oauth2/authorize?response_type=code&client_id=").append(TwitchConfig.CLIENT_ID)
				.append("&redirect_uri=").append(TwitchConfig.REDIRECT_URL).append("&scope=").append(TwitchConfig.SCOPE)
				.append("&claims={\"id_token\":{\"email_verified\":null}}");
		return sb.toString();
	}

	public TwitchAuthBean refreshToken() {
		StringBuilder sb = new StringBuilder();
		sb.append("https://id.twitch.tv/oauth2/token").append("?client_id=").append(TwitchConfig.CLIENT_ID)
				.append("&client_secret=").append(TwitchConfig.CLIENT_SECRET).append("&refresh_token=")
				.append(this.auth.getRefreshToken()).append("&grant_type=refresh_token").append("&redirect_uri=")
				.append(TwitchConfig.REDIRECT_URL);

		String response = rr.getRequest(sb.toString(), null, HttpMethod.POST).toString();
		response = response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1);

		JsonStream.setMode(EncodingMode.DYNAMIC_MODE);
		this.auth.setAccessToken(JsonIterator.deserialize(response).get("access_token").toString());
		this.auth.setExpiresIn(Long.valueOf(JsonIterator.deserialize(response).get("expires_in").toString()));
		this.auth.setRefreshToken(JsonIterator.deserialize(response).get("refresh_token").toString());
		this.auth.setScope(JsonIterator.deserialize(response).get("scope").as(String[].class));
		this.auth.setTokenType(JsonIterator.deserialize(response).get("token_type").toString());
		return this.auth;
	}

	public TwitchAuthBean getAuth(String code) {
		StringBuilder sb = new StringBuilder();
		sb.append("https://id.twitch.tv/oauth2/token").append("?client_id=").append(TwitchConfig.CLIENT_ID)
				.append("&client_secret=").append(TwitchConfig.CLIENT_SECRET).append("&code=").append(code)
				.append("&grant_type=authorization_code").append("&redirect_uri=").append(TwitchConfig.REDIRECT_URL);

		String response = rr.getRequest(sb.toString(), null, HttpMethod.POST).toString();
		response = response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1);
		TwitchJsonParser<TwitchAuthBean> parser = new TwitchJsonParser<TwitchAuthBean>();
		return parser.parse(response, TwitchAuthBean.class);
	}

}

package com.xel.twitch.core;

import org.springframework.http.HttpHeaders;

import com.xel.twitch.bean.TwitchAuthBean;
import com.xel.twitch.config.TwitchConfig;

public class TwitchUtils extends TwitchConfig {

	protected HttpHeaders autoHeaderBuilder() {
		return autoHeaderBuilder(null, false);
	}

	protected HttpHeaders autoHeaderBuilder(TwitchAuthBean auth) {
		return autoHeaderBuilder(auth, false);
	}

	protected HttpHeaders autoHeaderBuilder(TwitchAuthBean auth, boolean isDual) {
		HttpHeaders headers = new HttpHeaders();
		if (auth != null) {
			StringBuilder sb = new StringBuilder();
			String tokenType = auth.getTokenType();
			tokenType = tokenType.substring(0, 1).toUpperCase() + tokenType.substring(1);
			sb.append(tokenType).append(" ").append(auth.getAccessToken());
			headers.add(AUTH_HEADER, sb.toString());
			if (isDual) {
				headers.add(CLIENT_ID_HEADER, CLIENT_ID);
			}
			return headers;
		} else {
			headers.add(CLIENT_ID_HEADER, CLIENT_ID);
			return headers;
		}
	}

}

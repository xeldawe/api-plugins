package com.xel.twitch.service;

import org.springframework.http.HttpMethod;

import com.xel.twitch.bean.TwitchUserBean;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;

public class TwitchUserService extends TwitchServiceCore {

	public TwitchUserBean getUser() {
		TwitchUserBean user = null;
		if (this.auth != null) {
			String url = API_CORE_URL_HELIX+USER_ENDPOINT;
			String response = rr.getRequest(url, this.autoHeaderBuilder(this.auth), HttpMethod.GET).toString();
			TwitchJsonParser<TwitchUserBean> parser = new TwitchJsonParser<TwitchUserBean>();
			return parser.parse(response, TwitchUserBean.class);

		}
		return user;
	}
	
}

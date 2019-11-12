package com.xel.twitch.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.bean.TwitchBroadcasterSubscriptionsBean;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.service.bean.TwitchBroadcasterSubscriptionsRequestHelperBean;

//Required OAuth Scope: channel:read:subscriptions
public class TwitchBroadcasterSubscriptionsService extends TwitchServiceCore {
private TwitchJsonParser<TwitchBroadcasterSubscriptionsBean> parser = new TwitchJsonParser<TwitchBroadcasterSubscriptionsBean>();
	
	public List<TwitchBroadcasterSubscriptionsBean> getBroadcasterSubscriptions(String broadcasterId){
		return getBroadcasterSubscriptions(broadcasterId, null);
	}

	public List<TwitchBroadcasterSubscriptionsBean> getBroadcasterSubscriptions(TwitchBroadcasterSubscriptionsRequestHelperBean input){
		return getBroadcasterSubscriptions(input.getBroadcasterId(), input.getUserId());
	}
	
	public List<TwitchBroadcasterSubscriptionsBean> getBroadcasterSubscriptions(
			String broadcasterId, 
			String userId
			){
		
		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		if(broadcasterId != null) {
			queryMap.put(BROADCASTER_SUBSCRIPTIONS_BROADCASTER_ID_QUERY_PARAM, broadcasterId);
		}
		if(userId != null) {
			queryMap.put(BROADCASTER_SUBSCRIPTIONS_USER_ID_QUERY_PARAM, userId);
		}

		String url = ApiUrlBuilder(Api.HELIX, Endpoint.BROADCASTER_SUBSCRIPTIONS, queryMap);
		
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder(this.auth)).toString());
	}
	
}

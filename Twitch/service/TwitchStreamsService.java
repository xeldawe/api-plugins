package com.xel.twitch.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.bean.TwitchStreamsBean;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.service.bean.TwitchStreamsRequestHelperBean;

public class TwitchStreamsService extends TwitchServiceCore {
	
	private TwitchJsonParser<TwitchStreamsBean> parser = new TwitchJsonParser<TwitchStreamsBean>();
	
	public List<TwitchStreamsBean> getStreams() {
		return getStreams(null, null, null, null, null, null, null, null);
	}
	
	public List<TwitchStreamsBean> getStreamsByUserId(String userId) {
		return getStreams(null, null, null, null, null, null, userId, null);
	}
	
	public List<TwitchStreamsBean> getStreamsByGameId(String gameId) {
		return getStreams(null, null, null, null, gameId, null, null, null);
	}
	
	public List<TwitchStreamsBean> getStreams(TwitchStreamsRequestHelperBean input){
		return getStreams(input.getAfter(), input.getBefore(), input.getCommunityId(), input.getFirst(), input.getGameId(), input.getLanguage(), input.getUserId(), input.getUserLogin());
	}
	
	public List<TwitchStreamsBean> getStreams(Map<String, Object> input){
		String url = ApiUrlBuilder(Api.HELIX, Endpoint.STREAMS, input);
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}
	
	public List<TwitchStreamsBean> getStreams(
			String after, 
			String before, 
			String communityId,
			Integer first,
			String gameId,
			String language,
			String userId,
			String userLogin
			){
		
		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		if(after != null) {
			queryMap.put(STREAMS_AFTER_QUERY_PARAM, after);
		}
		if(before != null) {
			queryMap.put(STREAMS_BEFORE_QUERY_PARAM, before);
		}
		if(communityId != null) {
			queryMap.put(STREAMS_COMMUNITY_ID_QUERY_PARAM, communityId);
		}
		if(first != null) {
			queryMap.put(STREAMS_FIRST_QUERY_PARAM, String.valueOf(first));
		}
		if(gameId != null) {
			queryMap.put(STREAMS_GAME_ID_QUERY_PARAM, gameId);
		}
		if(language != null) {
			queryMap.put(STREAMS_LANGUAGE_QUERY_PARAM, language);
		}
		if(userId != null) {
			queryMap.put(STREAMS_USER_ID_QUERY_PARAM, userId);
		}
		if(userLogin != null) {
			queryMap.put(STREAMS_USER_LOGIN_QUERY_PARAM, userLogin);
		}
		
		String url = ApiUrlBuilder(Api.HELIX, Endpoint.STREAMS, queryMap);
		
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}
	
}

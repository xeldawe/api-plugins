package com.xel.twitch.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.bean.TwitchTopGamesBean;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.service.bean.TwitchTopGamesRequestHelperBean;

public class TwitchTopGamesService extends TwitchServiceCore {

private TwitchJsonParser<TwitchTopGamesBean> parser = new TwitchJsonParser<TwitchTopGamesBean>();
	
	public List<TwitchTopGamesBean> getTopGames() {
		return getTopGames(null, null, null);
	}

	public List<TwitchTopGamesBean> getTopGames(TwitchTopGamesRequestHelperBean input){
		return getTopGames(input.getAfter(), input.getBefore(), input.getFirst());
	}
	
	public List<TwitchTopGamesBean> getTopGames(Map<String, Object> input){
		String url = ApiUrlBuilder(Api.HELIX, Endpoint.TOP_GAMES, input);
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}
	
	public List<TwitchTopGamesBean> getTopGames(
			String after, 
			String before, 
			Integer first
			){
		System.out.println("TRY TO CALL");
		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		if(after != null) {
			queryMap.put(TOP_GAMES_AFTER_QUERY_PARAM, after);
		}
		if(before != null) {
			queryMap.put(TOP_GAMES_BEFORE_QUERY_PARAM, before);
		}
		if(first != null) {
			queryMap.put(TOP_GAMES_FIRST_QUERY_PARAM, String.valueOf(first));
		}
		
		String url = ApiUrlBuilder(Api.HELIX, Endpoint.TOP_GAMES, queryMap);
		
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}
	
}

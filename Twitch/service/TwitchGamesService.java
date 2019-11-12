package com.xel.twitch.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.bean.TwitchGamesBean;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.service.bean.TwitchGamesRequestHelperBean;

public class TwitchGamesService extends TwitchServiceCore {
	
	private TwitchJsonParser<TwitchGamesBean> parser = new TwitchJsonParser<TwitchGamesBean>();

	public List<TwitchGamesBean> getGamesById(String id) {
		return getGames(id, null);
	}

	public List<TwitchGamesBean> getGamesByName(String name) {
		return getGames(null, name);
	}

	private List<TwitchGamesBean> getGames(TwitchGamesRequestHelperBean input) {
		return getGames(input.getId(), input.getName());
	}
	
	private List<TwitchGamesBean> getGames(String id, String name) {
		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		if(id != null) {
			queryMap.put(GAMES_ID_QUERY_PARAM, id);
		}
		if(name != null) {
			queryMap.put(GAMES_NAME_QUERY_PARAM, name);
		}
		
		String url = ApiUrlBuilder(Api.HELIX, Endpoint.GAMES, queryMap);
		
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}

}

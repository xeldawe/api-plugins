package com.xel.twitch.old.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.old.bean.KrakenTopGamesBean;

public class KrakenTopGamesService extends TwitchServiceCore {

	private TwitchJsonParser<KrakenTopGamesBean> parser = new TwitchJsonParser<KrakenTopGamesBean>(true, "top");
	
	public List<KrakenTopGamesBean> getTopGames(int limit, int offset) {
		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		queryMap.put("limit", limit);
		queryMap.put("offset", offset);
		String url = ApiUrlBuilder(Api.KRAKEN, Endpoint.TOP_GAMES, queryMap);
		
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}
	
}

package com.xel.twitch.old.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.old.bean.KrakenTopGamesBean;
import com.xel.twitch.old.service.bean.KrakenStreamsRequestHelperBean;

public class KrakenStreamsService extends TwitchServiceCore {
	private TwitchJsonParser<KrakenTopGamesBean> parser = new TwitchJsonParser<KrakenTopGamesBean>(true, "streams");
	
	@Deprecated
	public List<KrakenTopGamesBean> getStreamsByChannelId(int channelId) {
		String url = ApiUrlBuilder(Api.KRAKEN, Endpoint.STREAMS, null, String.valueOf(channelId));
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}
	
	public List<KrakenTopGamesBean> getStreams(KrakenStreamsRequestHelperBean input){
		return getStreams(input.getChannel(), input.getGame(), input.getLanguage(), input.getStreamType(), input.getLimit(), input.getOffset());
	}

	public List<KrakenTopGamesBean> getStreams(
			String channel, 
			String game, 
			String language,
			Integer streamType,
			String limit,
			String offset
			){
		
		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		if(channel != null) {
			queryMap.put("channel", channel);
		}
		if(language != null) {
			queryMap.put("language", language);
		}
		if(streamType != null) {
			queryMap.put("stream_type", String.valueOf(streamType));
		}
		if(game != null) {
			queryMap.put("game", game);
		}
		if(limit != null) {
			queryMap.put("limit", limit);
		}
		if(offset != null) {
			queryMap.put("offset", offset);
		}
		
		String url = ApiUrlBuilder(Api.KRAKEN, Endpoint.STREAMS, queryMap);
		System.out.println(url);
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder(this.auth, true)).toString());
	}
}

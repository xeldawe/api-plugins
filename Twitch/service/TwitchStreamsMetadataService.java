package com.xel.twitch.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.bean.TwitchStreamsMetadataBean;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.service.bean.TwitchStreamsMetadataRequestHelperBean;

public class TwitchStreamsMetadataService extends TwitchServiceCore {
	private TwitchJsonParser<TwitchStreamsMetadataBean> parser = new TwitchJsonParser<TwitchStreamsMetadataBean>();

	public List<TwitchStreamsMetadataBean> getStreamsMetadata() {
		return getStreamsMetadata(null, null, null, null, null, null, null, null);
	}

	public List<TwitchStreamsMetadataBean> getStreamsMetadataByUserId(String userId) {
		return getStreamsMetadata(null, null, null, null, null, null, userId, null);
	}

	public List<TwitchStreamsMetadataBean> getStreamsMetadataByGameId(String gameId) {
		return getStreamsMetadata(null, null, null, null, gameId, null, null, null);
	}

	public List<TwitchStreamsMetadataBean> getStreamsMetadata(TwitchStreamsMetadataRequestHelperBean input) {
		return getStreamsMetadata(input.getAfter(), input.getBefore(), input.getCommunityId(), input.getFirst(),
				input.getGameId(), input.getLanguage(), input.getUserId(), input.getUserLogin());
	}
	
	public List<TwitchStreamsMetadataBean> getStreamsMetadata(Map<String, Object> input){
		String url = ApiUrlBuilder(Api.HELIX, Endpoint.STREAMS_METADATA, input);
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}
	
	public List<TwitchStreamsMetadataBean> getStreamsMetadata(String after, String before, String communityId,
			Integer first, String gameId, String language, String userId, String userLogin) {

		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		if (after != null) {
			queryMap.put(STREAMS_METADATA_AFTER_QUERY_PARAM, after);
		}
		if (before != null) {
			queryMap.put(STREAMS_METADATA_BEFORE_QUERY_PARAM, before);
		}
		if (communityId != null) {
			queryMap.put(STREAMS_METADATA_COMMUNITY_ID_QUERY_PARAM, communityId);
		}
		if (first != null) {
			queryMap.put(STREAMS_METADATA_FIRST_QUERY_PARAM, String.valueOf(first));
		}
		if (gameId != null) {
			queryMap.put(STREAMS_METADATA_GAME_ID_QUERY_PARAM, gameId);
		}
		if (language != null) {
			queryMap.put(STREAMS_METADATA_LANGUAGE_QUERY_PARAM, language);
		}
		if (userId != null) {
			queryMap.put(STREAMS_METADATA_USER_ID_QUERY_PARAM, userId);
		}
		if (userLogin != null) {
			queryMap.put(STREAMS_METADATA_USER_LOGIN_QUERY_PARAM, userLogin);
		}

		String url = ApiUrlBuilder(Api.HELIX, Endpoint.STREAMS_METADATA, queryMap);

		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder()).toString());
	}

}

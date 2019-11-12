package com.xel.twitch.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.xel.twitch.bean.TwitchRedeemCodeBean;
import com.xel.twitch.core.TwitchJsonParser;
import com.xel.twitch.core.TwitchServiceCore;
import com.xel.twitch.service.bean.TwitchReedemCodeRequestHelperBean;

public class TwitchReedemCodeService extends TwitchServiceCore {

	private TwitchJsonParser<TwitchRedeemCodeBean> parser = new TwitchJsonParser<TwitchRedeemCodeBean>();

	public List<TwitchRedeemCodeBean> getRedeemCodes(String userId, String... code) {
		return getRedeemCode(userId, code);
	}

	private List<TwitchRedeemCodeBean> getGames(TwitchReedemCodeRequestHelperBean input) {
		if (input.getCodes() != null) {
			return getRedeemCode(input.getUserId(), input.getCodes());
		} else {
			return getRedeemCode(input.getUserId(), input.getCode());
		}
	}

	private List<TwitchRedeemCodeBean> getRedeemCode(String userId, String... code) {
		Map<String, Object> queryMap = new LinkedHashMap<String, Object>();
		if (code != null) {
			queryMap.put(REEDEM_CODE_CODE_QUERY_PARAM, code);
		}
		if (userId != null) {
			queryMap.put(REEDEM_CODE_USER_ID_QUERY_PARAM, userId);
		}

		String url = ApiUrlBuilder(Api.HELIX, Endpoint.REEDEM_CODE, queryMap);
		
		return parser.parse(rr.getRequest(url, this.autoHeaderBuilder(this.auth)).toString());
	}

}

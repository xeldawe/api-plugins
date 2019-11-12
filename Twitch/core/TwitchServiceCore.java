package com.xel.twitch.core;

import java.util.Map;

import com.xel.twitch.bean.TwitchAuthBean;

public class TwitchServiceCore extends TwitchUtils {

	protected TwitchRestRequest rr = new TwitchRestRequest();
	protected TwitchAuthBean auth = null;

	protected enum Api {
		HELIX(API_CORE_URL_HELIX),
		KRAKEN(API_CORE_URL_KRAKEN);

		Api(String url) {
			this.url = url;
		}

		private final String url;

		public String getUrl() {
			return url;
		}
	}

	protected enum Endpoint {
		USER(API_CORE_URL_HELIX), STREAMS(STREAMS_ENDPOINT), STREAMS_METADATA(STREAMS_METADATA_ENDPOINT), GAMES(GAMES_ENDPOINT), TOP_GAMES(TOP_GAMES_ENDPOINT),
		REEDEM_CODE(REEDEM_CODE_ENDPOINT),BROADCASTER_SUBSCRIPTIONS(BROADCASTER_SUBSCRIPTIONS_ENDPOINT);

		Endpoint(String endpoint) {
			this.endpoint = endpoint;
		}

		private final String endpoint;

		public String getEndpoint() {
			return endpoint;
		}
	}

	protected String UrlBuilder(String... urlParts) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < urlParts.length; i++) {
			sb.append(urlParts[i]);
		}
		return sb.toString();
	}
	
	protected String ApiUrlBuilder(Api api, Endpoint endpoint, Map<String, Object> queryMap) {
		return ApiUrlBuilder(api, endpoint, queryMap, null);
	}

	protected String ApiUrlBuilder(Api api, Endpoint endpoint, Map<String, Object> queryMap, String nativePart) {
		StringBuilder sb = new StringBuilder();
		if (api != null) {
			sb.append(api.url);
			if (endpoint != null) {
				sb.append(endpoint.endpoint);
				if (queryMap != null) {
					sb.append(QueryParamBuilder(queryMap));
				}
			}
		}
		if(nativePart!=null) {
		sb.append(nativePart);
		}
		return sb.toString();
	}

	protected String QueryParamBuilder(Map<String, Object> queryMap) {
		if (queryMap.isEmpty()) {
			return new String();
		}
		StringBuilder sb = new StringBuilder();
		sb.append("?");
		for (Map.Entry<String, Object> entry : queryMap.entrySet()) {
			sb.append(entry.getKey()).append("=");
			try {
				String[] array = (String[]) entry.getValue();
				sb.append(array[0]);
				if (array.length > 1) {
					for (int i = 1; i < array.length; i++) {
						sb.append(entry.getKey())
						.append("=")
						.append(array[i]);
						if(i < array.length-1) {
							sb.append("&");
						}
					}
				}
			} catch (Exception e) {
				sb.append(entry.getValue());
			}
			sb.append("&");
		}
		return sb.substring(0, sb.length() - 1);
	}

	public TwitchAuthBean getAuth() {
		return auth;
	}

	public void setAuth(TwitchAuthBean auth) {
		this.auth = auth;
	}

}

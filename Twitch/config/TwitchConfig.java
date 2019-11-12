package com.xel.twitch.config;

public class TwitchConfig {

	//CLIENT
	protected final static String CLIENT_ID = "YOUR_CLIENT_ID";
	protected final static String CLIENT_SECRET = "YOUR_SECRET";
	protected final static String REDIRECT_URL = "YOUR_DOMAIN";
	protected final static String SCOPE = "user_blocks_read+user_subscriptions+user_read+viewing_activity_read+openid+bits:read+whispers:edit+whispers:read+chat:read+chat:edit+channel:moderate+channel:read:subscriptions";
	
	//URL
	protected final static String API_CORE_URL_HELIX = "https://api.twitch.tv/helix";
	protected final static String API_CORE_URL_KRAKEN = "https://api.twitch.tv/kraken";

	//HEADER
	protected final static String AUTH_HEADER = "Authorization";
	protected final static String CLIENT_ID_HEADER = "Client-ID";
	protected final static String CONTENT_TYPE_HEADER = "Content-Type";

	//HEADER VALUES
	protected final static String CONTENT_TYPE_APPLICATION_JSON = "application/json";
	
	//ENDPOINT
	protected final static String USER_ENDPOINT = "/users";
	protected final static String STREAMS_ENDPOINT = "/streams";
	protected final static String STREAMS_METADATA_ENDPOINT = "/streams/metadata";
	protected final static String GAMES_ENDPOINT = "/games";
	protected final static String TOP_GAMES_ENDPOINT = "/games/top";
	protected final static String REEDEM_CODE_ENDPOINT = "/entitlements/codes";
	protected final static String BROADCASTER_SUBSCRIPTIONS_ENDPOINT = "/subscriptions";
	
	//STREAM QUERY PARAMS
	protected final static String STREAMS_AFTER_QUERY_PARAM = "after";
	protected final static String STREAMS_BEFORE_QUERY_PARAM = "before";
	protected final static String STREAMS_COMMUNITY_ID_QUERY_PARAM = "community_id";
	protected final static String STREAMS_FIRST_QUERY_PARAM = "first";
	protected final static String STREAMS_GAME_ID_QUERY_PARAM = "game_id";
	protected final static String STREAMS_LANGUAGE_QUERY_PARAM = "language";
	protected final static String STREAMS_USER_ID_QUERY_PARAM = "user_id";
	protected final static String STREAMS_USER_LOGIN_QUERY_PARAM = "user_login";
	
	//STREAM METADATA QUERY PARAMS
	protected final static String STREAMS_METADATA_AFTER_QUERY_PARAM = "after";
	protected final static String STREAMS_METADATA_BEFORE_QUERY_PARAM = "before";
	protected final static String STREAMS_METADATA_COMMUNITY_ID_QUERY_PARAM = "community_id";
	protected final static String STREAMS_METADATA_FIRST_QUERY_PARAM = "first";
	protected final static String STREAMS_METADATA_GAME_ID_QUERY_PARAM = "game_id";
	protected final static String STREAMS_METADATA_LANGUAGE_QUERY_PARAM = "language";
	protected final static String STREAMS_METADATA_USER_ID_QUERY_PARAM = "user_id";
	protected final static String STREAMS_METADATA_USER_LOGIN_QUERY_PARAM = "user_login";

	//BROADCASTER SUBSCRIPTIONS QUERY PARAMS
	protected final static String BROADCASTER_SUBSCRIPTIONS_BROADCASTER_ID_QUERY_PARAM = "broadcaster_id";
	protected final static String BROADCASTER_SUBSCRIPTIONS_USER_ID_QUERY_PARAM = "user_id";

	//GAMES QUERY PARAMS
	protected final static String GAMES_ID_QUERY_PARAM = "id";
	protected final static String GAMES_NAME_QUERY_PARAM = "name";
	
	//TOP GAMES QUERY PARAMS
	protected final static String TOP_GAMES_AFTER_QUERY_PARAM = "after";
	protected final static String TOP_GAMES_BEFORE_QUERY_PARAM = "before";
	protected final static String TOP_GAMES_FIRST_QUERY_PARAM = "first";
	
	//REEDEM CODE QUERY PARAMS
	protected final static String REEDEM_CODE_CODE_QUERY_PARAM = "code";
	protected final static String REEDEM_CODE_USER_ID_QUERY_PARAM = "user_id";
	
	//STATUS DEFAULT TEXT
	public final static String TWITCH_REEDEM_CODE_STATUS_SUCCESSFULLY_REDEEMED = "Request successfully redeemed this code to the authenticated user’s account.";
	public final static String TWITCH_REEDEM_CODE_STATUS_ALREADY_CLAIMED = "Code has already been claimed by a Twitch user.";
	public final static String TWITCH_REEDEM_CODE_STATUS_EXPIRED = "Code has expired and can no longer be claimed.";
	public final static String TWITCH_REEDEM_CODE_STATUS_USER_NOT_ELIGIBLE = "Not eligible to redeem this code.";
	public final static String TWITCH_REEDEM_CODE_STATUS_NOT_FOUND = "Code is not valid and/or does not exist in our database.";
	public final static String TWITCH_REEDEM_CODE_STATUS_INACTIVE = "Code is not currently active.";
	public final static String TWITCH_REEDEM_CODE_STATUS_UNUSED = "Code has not been claimed.";
	public final static String TWITCH_REEDEM_CODE_STATUS_INCORRECT_FORMAT = "Code was not properly formatted.";
	public final static String TWITCH_REEDEM_CODE_STATUS_INTERNAL_ERROR = "Indicates some internal and/or unknown failure handling this code.";
}

package com.xel.twitch.status;

import com.xel.twitch.config.TwitchConfig;

	public enum TwitchReedemCodeStatus {
		SUCCESSFULLY_REDEEMED(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_SUCCESSFULLY_REDEEMED), 
		ALREADY_CLAIMED(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_ALREADY_CLAIMED),
		EXPIRED(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_EXPIRED),
		USER_NOT_ELIGIBLE(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_USER_NOT_ELIGIBLE),
		NOT_FOUND(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_NOT_FOUND),
		INACTIVE(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_INACTIVE),
		UNUSED(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_UNUSED),
		INCORRECT_FORMAT(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_INCORRECT_FORMAT),
		INTERNAL_ERROR(TwitchConfig.TWITCH_REEDEM_CODE_STATUS_INTERNAL_ERROR);
		
		TwitchReedemCodeStatus(String defaultText) {
			this.defaultText = defaultText;
		}

		private final String defaultText;

		public String getDefaultText() {
			return defaultText;
		}
	}
	

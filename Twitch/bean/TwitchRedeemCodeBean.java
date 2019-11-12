package com.xel.twitch.bean;

import com.xel.twitch.status.TwitchReedemCodeStatus;

public class TwitchRedeemCodeBean{

	private String code;
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		TwitchReedemCodeStatus RCstatus = TwitchReedemCodeStatus.valueOf(status);
		switch (RCstatus) {
		case ALREADY_CLAIMED:
			this.status = RCstatus.ALREADY_CLAIMED.getDefaultText();
			break;
		case EXPIRED:
			this.status = RCstatus.EXPIRED.getDefaultText();
			break;
		case INACTIVE:
			this.status = RCstatus.INACTIVE.getDefaultText();
			break;
		case INCORRECT_FORMAT:
			this.status = RCstatus.INCORRECT_FORMAT.getDefaultText();
			break;
		case INTERNAL_ERROR:
			this.status = RCstatus.INTERNAL_ERROR.getDefaultText();
			break;
		case NOT_FOUND:
			this.status = RCstatus.NOT_FOUND.getDefaultText();
			break;
		case SUCCESSFULLY_REDEEMED:
			this.status = RCstatus.SUCCESSFULLY_REDEEMED.getDefaultText();
			break;
		case UNUSED:
			this.status = RCstatus.UNUSED.getDefaultText();
			break;
		case USER_NOT_ELIGIBLE:
			this.status = RCstatus.USER_NOT_ELIGIBLE.getDefaultText();
			break;
		default:
			break;
		}
	}

}

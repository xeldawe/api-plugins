package com.xel.twitch.old.bean;

import com.xel.twitch.old.common.bean.GameBean;

public class KrakenTopGamesBean {
	private GameBean game;
	private int viewers;
	private int channels;

	public GameBean getGame() {
		return game;
	}

	public void setGame(GameBean game) {
		this.game = game;
	}

	public int getViewers() {
		return viewers;
	}

	public void setViewers(int viewers) {
		this.viewers = viewers;
	}

	public int getChannels() {
		return channels;
	}

	public void setChannels(int channels) {
		this.channels = channels;
	}

	@Override
	public String toString() {
		return "KrakenTopGamesBean [game=" + game + ", viewers=" + viewers + ", channels=" + channels + "]";
	}

}

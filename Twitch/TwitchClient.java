package com.xel.twitch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.xel.twitch.bean.TwitchAuthBean;
import com.xel.twitch.core.TwitchUtils;
import com.xel.twitch.old.service.KrakenStreamsService;
import com.xel.twitch.old.service.bean.KrakenStreamsRequestHelperBean;
import com.xel.twitch.service.TwitchStreamsService;

public class TwitchClient {
	
	private TwitchUtils utils = new TwitchUtils();
	int[] counter = new int[1];
	int max = 1;
	
	synchronized void addToCounter(){
		counter[0]++;
	}
	
	public void testRun() {

		ExecutorService es = Executors.newFixedThreadPool(max);
		//TwitchReedemCodeService reedemCoode = new TwitchReedemCodeService();
		
		TwitchAuthBean auth = new TwitchAuthBean();
		auth.setTokenType("bearer");
		auth.setAccessToken("YOUR_TOKEN");
//		reedemCoode.setAuth(auth);
		
		TwitchStreamsService stream = new TwitchStreamsService();
		Runnable runnable = () -> { 
//			TwitchStreamsService stream2 = new TwitchStreamsService();
//			TwitchStreamsRequestHelperBean t = new TwitchStreamsRequestHelperBean();
//			t.setLanguage("hu");
//			System.out.println(stream.getStreams(t));
			
//			KrakenTopGamesService k = new KrakenTopGamesService();
//			List topGames = k.getTopGames(10,0);
//			for(Object game : topGames) {
//				System.err.println(game.toString());
//			}
//			topGames = k.getTopGames(10,10);
//			for(Object game : topGames) {
//				System.err.println(game.toString());
//			}
			
			KrakenStreamsService ks = new KrakenStreamsService();
			KrakenStreamsRequestHelperBean ki = new KrakenStreamsRequestHelperBean();
			ki.setChannel("AdamKissAK");
		//	ki.setLanguage("hu");
			//ki.setGame();
			ks.getStreams(ki);
			
			
			addToCounter();
		};
		
		counter[0]= 0;
		long t = System.currentTimeMillis();
//		long t = System.currentTimeMillis();
		for(int i = 0; i < max; i++) {
//		System.out.println(stream.getStreams());
			es.execute(runnable);
			
		}
		while(counter[0] != max) {
			try {
				TimeUnit.MICROSECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.err.println("Total time: "+(System.currentTimeMillis()-t)+" ms - REQUEST COUNT: "+max);
//		System.err.println(System.currentTimeMillis()-t+" ms");
		try {
		//System.out.println(reedemCoode.getRedeemCodes("42296618", "YOUR_CODE"));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
//		TwitchTopGamesService topGames = new TwitchTopGamesService();
//		System.out.println(topGames.getTopGames());
//		System.out.println("1:");
//		TwitchBroadcasterSubscriptionsService broadcasterSubscriptions = new TwitchBroadcasterSubscriptionsService();
//		broadcasterSubscriptions.setAuth(auth);
//		try {
//		broadcasterSubscriptions.getBroadcasterSubscriptions("123", "1111");
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("2:");
//		try {
//		broadcasterSubscriptions.getBroadcasterSubscriptions("123");
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("3:");
//		TwitchBroadcasterSubscriptionsRequestHelperBean input = new TwitchBroadcasterSubscriptionsRequestHelperBean();
//		input.setBroadcasterId("123");
//		try {
//		broadcasterSubscriptions.getBroadcasterSubscriptions(input);
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("4:");
//		input.setUserId("1111");
//		try {
//		broadcasterSubscriptions.getBroadcasterSubscriptions(input);
//		}catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		
//		System.out.println("Login url: "+utils.getLoginUrl());
//		
//		TwitchAuthBean auth = utils.getAuth("YOUR_TOKEN");
//		System.out.println("TOKEN: "+auth.getAccessToken());
//		
//		System.out.println(auth.toString());
//		TwitchAuthBean [accessToken=YOURTOKEN, expiresIn=15221, idToken=YOUR_ID_TOKEN, refreshToken=null, scope=[bits:read, channel:moderate, chat:edit, chat:read, openid, user_blocks_read, user_read, user_subscriptions, viewing_activity_read, whispers:edit, whispers:read], tokenType=bearer]
//		TwitchAuthBean auth = new TwitchAuthBean();
//		auth.setRefreshToken("YOUR_TOKEN");
//		utils.setAuth(auth);
//		System.out.println("new auth: "+utils.refreshToken());
//
//		auth.setAccessToken("YOUR_TOKEN");
//		auth.setTokenType("bearer");
//		utils.setAuth(auth);
//		System.out.println(utils.getUser().toString());
//		
//		List streams = utils.getStreamsByGameId("33214");
//		
//		int counter = 0;
//		for(Object stream:streams) {
//			System.out.println("Stream ["+(++counter)+"]: "+stream);
//		}
		
	}
	
}

package com.xel.proxy.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xel.proxy.core.jpa.Controller;
import com.xel.proxy.core.jpa.Service;
import com.xel.proxy.service.TwitchLoginService;
import com.xel.smartshop.bean.TwitchLogin;
import com.xel.smartshop.bean.TwitchLoginData;
import com.xel.smartshop.bean.TwitchLoginUrl;

/**
 * Custom Controller
 * @author xeldawe
 *
 */
public class TwitchLoginController implements Controller{
	
	private TwitchLoginService tls = new TwitchLoginService();
	
	private com.xel.proxy.core.jpa.Service service;
	
	private Class t;
	
	@Override
	public List get() {
		List<TwitchLoginUrl> urls = new LinkedList<TwitchLoginUrl>();
		urls.add(tls.getLoginUrl(this.service));
		return urls;
	}

	@Override
	public List get(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Map map, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object post(Object obj) {
	
		ObjectMapper mapper = new ObjectMapper();
		TwitchLogin TwitchLogin = null;
		try {
			TwitchLogin = mapper.readValue(((String) obj), TwitchLogin.class); //Parse json to TwitchLogin object
		} catch (IOException e) {
//			e.printStackTrace();
		}
		TwitchLoginData tld = new TwitchLoginData();
		tld.setAuth(tls.twitchLogin(TwitchLogin, this.service));
		tld.setUser(tls.getUser(tld.getAuth(), this.service));
		return tld;
	}

	@Override
	public Object patch(long id, Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class getT() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setT(Class t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Service getService() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void set(com.xel.proxy.core.jpa.Service modelService) {
		this.service = modelService;
		this.service.setTCls(getT());
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}


}


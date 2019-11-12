package com.xel.proxy.controller;

import java.util.List;
import java.util.Map;

import com.xel.proxy.core.jpa.Controller;
import com.xel.proxy.core.jpa.Service;
import com.xel.proxy.service.TwitchStreamsService;

/**
 * Custom Controller
 * @author xeldawe
 *
 */
public class TwitchStreamsController implements Controller{
	
	private TwitchStreamsService s = new TwitchStreamsService();
	
	private com.xel.proxy.core.jpa.Service service;
	
	private Class t;
	
	@Override
	public List get() {
		return s.getStreams(this.service);
	}

	@Override
	public List get(Map map) {
		return s.getStreams(map, this.service);
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
		return null;
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


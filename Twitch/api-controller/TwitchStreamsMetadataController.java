

package com.xel.proxy.controller;

import java.util.List;
import java.util.Map;

import com.xel.proxy.core.jpa.Controller;
import com.xel.proxy.core.jpa.Service;
import com.xel.proxy.service.TwitchStreamsMetadataService;

/**
 * Custom Controller
 * @author xeldawe
 *
 */
public class TwitchStreamsMetadataController implements Controller{
	
	private TwitchStreamsMetadataService sm = new TwitchStreamsMetadataService();
	
	private com.xel.proxy.core.jpa.Service service;
	
	private Class t;
	
	@Override
	public List get() {
		return sm.getStreamsMetadata(this.service);
	}

	@Override
	public List get(Map map) {
		return sm.getStreamsMetadata(map,this.service);
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


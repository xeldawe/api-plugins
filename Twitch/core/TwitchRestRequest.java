package com.xel.twitch.core;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class TwitchRestRequest {

	public Object getRequest(String url) {
		return getRequest(url, null, HttpMethod.GET);
	}
	
	public Object getRequest(String url, HttpHeaders headers, HttpMethod httpMethod) {
		return getRequest(url, headers, httpMethod, String.class);
	}
	
	public Object getRequest(String url, HttpHeaders headers) {
		return getRequest(url, headers,  HttpMethod.GET, String.class);
	}
	
	
	public Object getRequest(String url, HttpHeaders headers, HttpMethod httpMethod, Class responseType) {
		RestTemplate restTemplate = new RestTemplate();
		if (headers != null) {
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
			return restTemplate.exchange(url, httpMethod, entity, responseType).getBody();
		}else {
			return restTemplate.exchange(url, httpMethod,  new HttpEntity<>("parameters", new HttpHeaders()), responseType).getBody();
		}

	}

}

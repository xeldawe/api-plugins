package com.xel.twitch.core;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.jsoniter.output.EncodingMode;
import com.jsoniter.output.JsonStream;

public class TwitchJsonParser<T> {

	private ObjectMapper mapper = new ObjectMapper();

	private boolean isKraken = false;
	private String uniqueString = "";
	
	public TwitchJsonParser() {
		super();
	}
	
	public TwitchJsonParser(boolean isKraken, String uniqueString) {
		super();
		this.isKraken = isKraken;
		this.uniqueString = uniqueString;
	}

	public List<T> parse(String json) {
		List<T> result = new LinkedList<T>();
		if(!isKraken) {
//		System.out.println("UNPARSED JSON: " + json);
		JsonStream.setMode(EncodingMode.DYNAMIC_MODE);
		Any any = JsonIterator.deserialize(json);
		any = any.get("data");
		for (Any item : any) {
			try {
				T tmp = mapper.readValue(item.toString(), new TypeReference<T>() {
				});
				result.add(tmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}else {
//			System.out.println("UNPARSED JSON: " + json);
			JsonStream.setMode(EncodingMode.DYNAMIC_MODE);
			Any any = JsonIterator.deserialize(json);
			any = any.get(uniqueString);
			System.err.println(any.toString());
			for (Any item : any) {
				try {
					T tmp = mapper.readValue(item.toString(), new TypeReference<T>() {
					});
					result.add(tmp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public T parse(String json, Class cls) {
		JsonStream.setMode(EncodingMode.DYNAMIC_MODE);
		Any any = JsonIterator.deserialize(json);
		if (json.contains("data")) {
			any = any.get("data");
			for (Any item : any) {
				try {
					return (T) mapper.readValue(item.toString(), cls);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}else {
			try {
				return (T) mapper.readValue(json.toString(), cls);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (T) new Object();

	}

}

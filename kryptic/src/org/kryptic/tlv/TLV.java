package org.kryptic.tlv;

import java.util.HashMap;

public class TLV {
	
	private int tagSize = 3;
	private int lengthSize = 3;
	
	private HashMap<String, String> tlvMap = new HashMap<>();

	public TLV(int tagSize, int lengthSize){
		super();
		this.tagSize 	= tagSize;
		this.lengthSize = lengthSize;
	}
	
	public void put(String key, String value){
		tlvMap.put(key, value);
	}
	
	public void get(String key){
		tlvMap.get(key);
	}
	
	public void parse(String tlvString){
		int i = 0; 
		while(i < tlvString.length()){
			try {
				String tagName = tlvString.substring(i, tagSize);
				i = i + tagSize;
				int tagLength = Integer.parseInt(tlvString.substring(i, lengthSize));
				i = i + tagSize;
				tlvMap.put(tagName, tlvString).substring(i, tagLength);
				i = i + tagLength;
			}
			catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public String build(){
		StringBuilder tlvBuilder = new StringBuilder("");
		tlvMap.forEach((key,value)-> {
			tlvBuilder.append(key);
			tlvBuilder.append(String.format("%0"+lengthSize+"d", value.length()));
			tlvBuilder.append(value);
		});
		return tlvBuilder.toString();
	}
	
	public static void main(String[] args) {
		TLV tlv = new TLV(3, 3);
		tlv.parse("001001100200300000300512345");
	}
}

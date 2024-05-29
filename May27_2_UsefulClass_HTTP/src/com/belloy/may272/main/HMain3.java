package com.belloy.may272.main;

import java.io.InputStream;

import com.belloy.http.client.BelloyHttpClient;

public class HMain3 {
	public static void main(String[] args) {
		try {
			InputStream is = BelloyHttpClient.download("https://www.naver.com");
			String result = BelloyHttpClient.convert(is, "UTF-8");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}

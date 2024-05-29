package com.belloy.may281.main;

import java.io.InputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.belloy.http.client.BelloyHttpClient;

// AJAX - JavaScript에서 XML 파싱
// JavaScript를 사용한 비동기 통신, 클라이언트와 서버 간에 XML 데이터를 주고 받는 기술 
//		=> 요즘 추세로는 XML이 많이 안 쓰임
//		=> JavaScript에 친화된 형태가 없을까...?

// JSON (JavaScript Object Notation)
//		DB에 있는 데이터를 JavaScript형태로 표현한 것

// Java 배열 	: { 1, 2, 3 }
// JS 배열 	: [ 1, 2, 3 ]

// Java 객체 	: Dog d = new Dog();
//				d.setName("갱얼쥐");
//				d.setAge(3);
// JS 객체 	: { name : "갱얼쥐", age : 3 }

// 4f626857416f6c6c3632586a416843
// http://openapi.seoul.go.kr:8088/sample/json/TbSeoulmetroStOrigin/1/275/

public class SubwayMain {
	public static void main(String[] args) {
		try {
			String address = "http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/json/TbSeoulmetroStOrigin/1/275/";
			InputStream is = BelloyHttpClient.download(address);
			String str = BelloyHttpClient.convert(is, "UTF-8");
//			System.out.println(str);
			
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(str); // 형변환 사용
//			System.out.println(jo);
			
			JSONObject metro = (JSONObject) jo.get("TbSeoulmetroStOrigin"); // 형변환 사용
//			System.out.println(metro);
			
			JSONArray row = (JSONArray) metro.get("row"); // 형변환 사용
			System.out.println(row);
			
			JSONObject data = null;
			for (int i = 0; i < row.size(); i++) { // .size() 사용
				data = (JSONObject) row.get(i); // 형변환
				System.out.println(data.get("STATION_NAME"));
				System.out.println(data.get("LINE"));
				System.out.println(data.get("ORIGIN"));
				System.out.println("-----------------");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}

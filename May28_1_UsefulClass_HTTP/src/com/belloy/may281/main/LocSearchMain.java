package com.belloy.may281.main;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.belloy.http.client.BelloyHttpClient;

// REST API 키 : 651b9143fecae45b955721c5e612edf3
// 지도 중심점	: 37.483869 / 127.084032 (y / x)
// https://dapi.kakao.com/v2/local/search/keyword.JSON
public class LocSearchMain {
	public static void main(String[] args) {
		try {
			Scanner k = new Scanner(System.in);
			System.out.print("검색 : ");
			String search = k.next();
			search = URLEncoder.encode(search, "UTF-8");
			
			// 기준점 주변 반경 5km 이내에 검색한 키워드(입력)가 포함된 가게들을
			// 거리 기준으로 정렬
			String address = "https://dapi.kakao.com/v2/local/search/keyword.json";
			address += "?query=" + search; 			// 검색어
			address += "&x=127.084032&y=37.483869"; // 중심 좌표
			address += "&radius=5000";				// 5km 반경
			address += "&sort=distance";			// 거리순 정렬
			
			// Authorization: KakaoAK 651b9143fecae45b955721c5e612edf3
			
			HashMap<String, String> headers = new HashMap<String, String>(); 
			headers.put("Authorization", "KakaoAK 651b9143fecae45b955721c5e612edf3");
			
			InputStream is = BelloyHttpClient.download(address, headers);
			String str = BelloyHttpClient.convert(is, "UTF-8");
//			System.out.println(str);
			
			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(str);
			
			// 총 검색 결과 수
			JSONObject meta = (JSONObject) jo.get("meta");
			System.out.printf("총 검색 결과 수 : %d개\n", meta.get("total_count"));
			
			// 현재 페이지 결과 수
			System.out.printf("페이지 내 결과 수 : %d개\n", meta.get("pageable_count"));
			System.out.println("-----------------------");

			// 주소
			// 전화번호
			// 상호명
			// 기준점과의 거리
			JSONArray ja = (JSONArray) jo.get("documents");
			JSONObject data = null;
			for (int i = 0; i < ja.size(); i++) {
				data = (JSONObject) ja.get(i);
				System.out.printf("주소 : %s\n", data.get("address_name"));
				System.out.printf("전화번호 : %s\n", data.get("phone"));
				System.out.printf("상호명 : %s\n", data.get("place_name"));
				System.out.printf("거리 : %sm\n", data.get("distance"));
				System.out.println("-----------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

package com.belloy.may281.main;

import java.io.InputStream;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.belloy.http.client.BelloyHttpClient;

// 42008a8c8e7402a3fc9d3b1a7df8fee9		
public class WeatherMain {
	public static void main(String[] args) {
		try {
			// 도시의 이름을 콘솔에서 입력 (영어로 ex: seoul)
			Scanner k = new Scanner(System.in);
			System.out.print("City : ");
			String cityName = k.next();
			
			String address = "https://api.openweathermap.org/data/2.5/weather";
			address += "?q=" + cityName;
			address += "&appid=42008a8c8e7402a3fc9d3b1a7df8fee9";
			address += "&units=metric";
			address += "&lang=kr";
			
			InputStream is = BelloyHttpClient.download(address);
			String str = BelloyHttpClient.convert(is, "UTF-8");
			
			JSONParser jp = new JSONParser();
			
			JSONObject jo = (JSONObject) jp.parse(str);
			
			// 나라 이름
			JSONObject sys = (JSONObject) jo.get("sys");
			String country = (String) sys.get("country");
			System.out.println(country);
			
			// 도시 이름
			String cityName2 = (String) jo.get("name");
			System.out.println(cityName2);
			
			// description
			JSONArray ja = (JSONArray) jo.get("weather");
			JSONObject jo2 = (JSONObject) ja.get(0);
			String description = (String) jo2.get("description");
			System.out.println(description);
			
			JSONObject main = (JSONObject) jo.get("main");
			// 기온
			double temp = (double) main.get("temp");
			System.out.println(temp);
			// 체감온도
			double feelslike = (double) main.get("feels_like");
			System.out.println(feelslike);
			// 최저기온
			double tempMin = (double) main.get("temp_min");
			System.out.println(tempMin);
			// 최고기온
			double tempMax = (double) main.get("temp_max");
			System.out.println(tempMax);
			// 기압
			long pressure = (long) main.get("pressure");
			System.out.println(pressure);
			// 습도
			long humidity = (long) main.get("humidity");
			System.out.println(humidity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// https://api.openweathermap.org/data/2.5/weather
		// ?q={city name}&appid=42008a8c8e7402a3fc9d3b1a7df8fee9
		// &units=metric&lang=kr
	}
}

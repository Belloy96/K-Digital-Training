package com.belloy.may273.main;

import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.belloy.http.client.BelloyHttpClient;

// https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168072000

// 시간 : hour
// 온도 : temp
// 날씨 : wfKor
// 바람 방향 : wdKor
// 콘솔 출력

public class WeatherMain {
	public static void main(String[] args) {
		try {
			String address = "https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168072000";
			InputStream is = BelloyHttpClient.download(address);
			
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "UTF-8");
			
			int type = xpp.getEventType();
			String tagName = null;
			
			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
				} else if (type == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						System.out.printf("%s시 | ", xpp.getText());
					} else if (tagName.equals("temp")) {
						System.out.printf("%s°C | ", xpp.getText());
					} else if (tagName.equals("wfKor")) {
						System.out.printf("%s | ", xpp.getText());
					} else if (tagName.equals("wdKor")) {
						System.out.printf("%s풍\n", xpp.getText());
						System.out.println("============================");
					}
				}else if (type == XmlPullParser.END_TAG) {
					tagName = "";
				}
				xpp.next();
				type = xpp.getEventType();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}

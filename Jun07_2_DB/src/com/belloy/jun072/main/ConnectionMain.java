package com.belloy.jun072.main;

import java.sql.Connection;
import java.sql.DriverManager;

// Socket 통신
// HTTP 통신

// DB서버와 통신 : Java에 내장되어 있음 (미완성상태)
//		DB 메이커가 많기 때문에... => 메이커 별로 통신이 조금씩 달라서
//		연결할 DB에 맞춰서 조금씩 손을 봐줘야!!

// JDBC (Java Database Connectivity) - 자바에서 DB 프로그래밍을 하기 위해 사용하는 API
//	Oracle DB 사용중! => 여기에 맞춰서 손을 봐줘야
//		=> 그 기능은 ojdbc8.jar에 다 있음

// 		ojdbc8.jar 넣기만 하면 알아서 사용할 수 있음
public class ConnectionMain {
	public static void main(String[] args) {
		Connection con = null;
		try {
			// 연결할 DB서버 주소 (메이커별로 형식이 다름..)
			//	Data Source Explorer - 서버 이름 쪽에 오른쪽 마우스 버튼 클릭
			//		- Properties - Driver Properties - Connection URL 값을 복사!
			
			String addr = "jdbc:oracle:thin:@192.168.0.77:1521:xe";
			
			con = DriverManager.getConnection(addr, "kg", "8230");
			System.out.println("Success !");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			con.close();		// close 철저히 하세요!!
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
















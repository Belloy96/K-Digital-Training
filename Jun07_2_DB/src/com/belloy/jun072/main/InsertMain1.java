package com.belloy.jun072.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMain1 {
	public static void main(String[] args) {
		// SQL문을 사용해서
		// 	=> DB서버로 전송
		//	=> DB서버에서 실행해서
		//	=> 그 결과를 잘 받아올 수 있어야!
		Connection con = null;
		try {
			// 연결할 DB서버 주소 (메이커별로 형식이 다름..)
			//	Data Source Explorer - 서버 이름 쪽에 오른쪽 마우스 버튼 클릭
			//		- Properties - Driver Properties - Connection URL 값을 복사!
			
			String addr = "jdbc:oracle:thin:@192.168.0.77:1521:xe";
			
			con = DriverManager.getConnection(addr, "kg", "8230");
//			System.out.println("Success !");
			
			// 주의할 점 2가지!!!
			String sql = "insert into jun07_product "		// 1. 띄어쓰기 주의!!!!!
					+ "values(jun07_product_seq.nextval, "	//	띄어쓰기 안하면
															// 	productvalues(...)가 됨
					+ "'테스트', 10, 10, 3)";					// 2. ) 뒤에 ';' 쓰지 말 것!!
			
			// 서버에 전송/실행/결과 받아오는 작업을 하는 총괄 매니저
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(); // 서버에 전송/실행/결과받기
			
			pstmt.close();
			
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

package com.belloy.jun072.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMain2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			String addr = "jdbc:oracle:thin:@192.168.0.77:1521:xe";
			con = DriverManager.getConnection(addr, "kg", "8230");
			
			// 연결이 되면 입력받기(Scanner)
			Scanner k = new Scanner(System.in);
			System.out.print("마트 이름: ");
			String name = k.next();
			System.out.print("지점명: ");
			String location = k.next();
			System.out.print("몇 평: ");
			int land = k.nextInt();
			System.out.print("주차 가능 대수 : ");
			int parking = k.nextInt();
			
			// SQL
			// Java변수에 있는 값 들어갈 자리에 '?' 로
			String sql = "insert into jun07_market "
					+ "values(jun07_market_seq.nextval, "
					+ "?, ?, ?, ?)";
			
			pstmt = con.prepareStatement(sql);
			
			// ?에 값 채우기 : pstmt.setXXX(물음표번호, 값)
			// XXX : 자료형, 물음표번호는 1부터 시작 !
			pstmt.setString(1, name);
			pstmt.setString(2, location);
			pstmt.setInt(3, land);
			pstmt.setInt(4, parking);
			
			// 전송/실행/결과받기
			//	이 작업 때문에 영향을 받은 데이터의 개수가 몇 개인지 리턴
//			int dateCount = pstmt.executeUpdate();
//			if (dateCount == 1) {
//				System.out.println("Success !");
//			}
			
			if (pstmt.executeUpdate() == 1) {
				System.out.println("Success !");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


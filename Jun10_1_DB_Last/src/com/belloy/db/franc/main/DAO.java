package com.belloy.db.franc.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.belloy.db.franc.reservation.Reservation;
import com.belloy.db.franc.restaurant.Restaurant;
import com.belloy.db.manager.BelloyDBManager;

public class DAO {
	// MVC패턴의 M
	//		DAO / DTO 패턴
	//		DAO (Data Access Object)
	//			: M 중에서 DB관련한 작업을 전담하는 클래스
	//		DTO (Data Transfer / Temp Object)
	//			: DAO의 작업결과를 표현하는 클래스 (Reservation / Restaurant)
	
	//	java.util.Date - 주력 (Spring에서는 이걸 원함)
	//	java.sql.Date - JDBC에서는 이걸 원함
	
	// 	java.util.Date => java.sql.Date
	//	   	: new Date(클래스명.get날짜관련멘버변수명().getTime());
	
	// 	java.sql.Date => java.util.Date : 알아서 바꿔줌
	
	// 1. 예약하기
	public static String book(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = BelloyDBManager.connect();
			String sql = "insert into Reservation values(Reservation_seq.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getName());
			pstmt.setDate(2, new Date(rsv.getWhen().getTime()));
			pstmt.setString(3, rsv.getPhonenum());
			pstmt.setString(4, rsv.getLocation());
			
			if (pstmt.executeUpdate() == 1) {
				return "예약 성공";
			}
			return ""; // Java문법상 필요해서 억지로 넣은 것!
			
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 실패";
		} finally {
			BelloyDBManager.close(con, pstmt, null);
		}

	}
	
	// 2. 매장 등록
	public static String registerRst(Restaurant rst) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BelloyDBManager.connect();
			String sql = "insert into Restaurant values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rst.getLocation());
			pstmt.setString(2, rst.getOwner());
			pstmt.setInt(3, rst.getSeat());
			
			if (pstmt.executeUpdate() == 1) {
				return "등록 성공";
			}
			return ""; // Java문법상 필요해서 억지로 넣은 것!
			
		} catch (Exception e) {
			e.printStackTrace();
			return "등록 실패";
		} finally {
			BelloyDBManager.close(con, pstmt, null);
		}

	}
	
	// 3. 전체 예약 확인 (예약번호 오름차순 정렬)
	public static ArrayList<Reservation> checkTotalReservation(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = BelloyDBManager.connect();
			String sql = "select * from Reservation order by rsv_no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			Reservation r = null;
			
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			
			while (rs.next()) {
				// Reservation 클래스의 멤버변수 X
				//	DB의 컬럼명 - O
				r = new Reservation();
				r.setNo(rs.getInt("rsv_no"));
				r.setName(rs.getString("rsv_name"));
				r.setWhen(rs.getDate("rsv_time"));
				r.setPhonenum(rs.getString("rsv_phoneNum"));
				r.setLocation(rs.getString("rst_location"));
				rsvs.add(r);
//				System.out.println(rs.getInt("rsv_no"));
//				System.out.println(rs.getString("rsv_name"));
//				System.out.println(rs.getDate("rsv_time"));
//				System.out.println(rs.getString("rsv_phoneNum"));
//				System.out.println(rs.getString("rst_location"));
//				System.out.println("==========================");
			}
			return rsvs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			BelloyDBManager.close(con, pstmt, rs);
		}

	}
	
	// 4. 전체 매장 확인 (지점명 오름차순 정렬)
	public static ArrayList<Restaurant> checkTotalRestaurant(Restaurant rst) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BelloyDBManager.connect();
			String sql = "select * from Restaurant order by rst_location";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			Restaurant r = null;
			
			while (rs.next()) {
				r = new Restaurant();
				r.setLocation(rs.getString("rst_location"));
				r.setOwner(rs.getString("rst_owner"));
				r.setSeat(rs.getInt("rst_seat"));
				rsts.add(r);
//				System.out.println(rs.getString("rst_location"));
//				System.out.println(rs.getString("rst_owner"));
//				System.out.println(rs.getInt("rst_seat"));
//				System.out.println("==========================");
			}
			return rsts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			BelloyDBManager.close(con, pstmt, rs);
		}

	}
	
	// 5. 매장 찾기 (입력한 좌석 수 이상을 가지고 있는 매장, 지점명 오름차순 정렬)
	public static ArrayList<Restaurant> searchRestaurant(Restaurant rst) { // int로 했으면 int 넣기(Restaurant 대신)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BelloyDBManager.connect();
			String sql = "select * from Restaurant where rst_seat >= ? order by rst_location";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rst.getSeat());
			rs = pstmt.executeQuery();
			
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			
			while (rs.next()) {
				rsts.add(new Restaurant(rs.getString("rst_location"),
						rs.getString("rst_owner"), rs.getInt("rst_seat")));
			}
			return rsts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			BelloyDBManager.close(con, pstmt, rs);
		}
	}
	
	// 6. 예약 찾기 (예약자의 이름으로 찾기, 예약번호 오름차순 정렬)
	public static ArrayList<Reservation> searchReservtion(Reservation rsv) { 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BelloyDBManager.connect();
			String sql = "select * from Reservation where rsv_name like '%'||?||'%' order by rsv_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getName());
			rs = pstmt.executeQuery();
			
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			
			while (rs.next()) {
				rsvs.add(new Reservation(rs.getInt("rsv_no"), rs.getString("rsv_name"), 
						rs.getDate("rsv_time"), rs.getString("rsv_phonenum"), 
						rs.getString("rst_location")));
			}
			return rsvs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			BelloyDBManager.close(con, pstmt, rs);
		}
	}
	
	// 7. 예약정보수정 (예약자의 전화번호 수정하기)
	public static String updateReserve(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BelloyDBManager.connect();
			String sql = "update RESERVATION set rsv_phonenum = ? "
					+ "where rsv_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getPhonenum());
			pstmt.setInt(2, rsv.getNo());
			
			if (pstmt.executeUpdate() == 1) {
				return "예약수정 성공";
			}
			return "예약정보 없음";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약수정 실패";
		} finally {
			BelloyDBManager.close(con, pstmt, null);
		}
	}
	
	// 8. 예약취소 (예약 번호로 취소하기)
	public static String deleteReserve(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BelloyDBManager.connect();
			String sql = "delete from RESERVATION where rsv_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rsv.getNo());
			
			if (pstmt.executeUpdate() == 1) {
				return "예약취소 성공";
			}
			return "예약정보 없음";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약취소 실패";
		} finally {
			BelloyDBManager.close(con, pstmt, null);
		}
	}
	
	// 9. 종료
	
}

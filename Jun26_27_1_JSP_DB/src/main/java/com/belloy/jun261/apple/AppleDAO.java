package com.belloy.jun261.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.belloy.db.manager.BelloyDBManager;

import oracle.jdbc.proxy.annotation.Pre;

public class AppleDAO {
	private int allAppleCount;
	
	private static final AppleDAO APPLEDAO = new AppleDAO();
	
	public AppleDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static AppleDAO getAppledao() {
		return APPLEDAO;
	}
	
	// 모든 사과 데이터 다 가져오기
	public void getAllApples(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BelloyDBManager.connect("belloyPool");
			
			// sql문 작성
			String sql = "select * from Apple order by a_price";
			pstmt = con.prepareStatement(sql);
			
			// C / U / D : pstmt.executeUpdate()로 실행
			//		=> 데이터 몇 개 영향을 받았는지
			// R : pstmt.executeQuery()로 실행
			//		=> select 결과를 ResultSet으로 보냄
			rs = pstmt.executeQuery();
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			
			while (rs.next()) {
				apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				apples.add(apple); // 이 데이터들을 전부 ArrayList에 넣기
			}
			request.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	// 등록하기
	public void reg (HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BelloyDBManager.connect("belloyPool");
			
			// 데이터 입력한거 받아오기(post방식에서 받아옴)
			request.setCharacterEncoding("UTF-8"); // 한글 처리!
			String location = request.getParameter("a_location");
			String color = request.getParameter("a_color");
			String flavor = request.getParameter("a_flavor");
			int price = Integer.parseInt(request.getParameter("a_price"));
			String introduce = request.getParameter("a_introduce");
			
			// <textArea>에서 엔터친거 : \r\n
			// 웹페이지에서 줄바꾸기 : <br>
			// String introduce = request.getParameter("a_introduce").replace("\r\n", "<br>");
			
			// sql문 작성
			String sql = "insert into Apple values(?, ? ,? ,? ,?)";
			
			// DB관련 총괄매니저
			pstmt = con.prepareStatement(sql);
			
			// sql완성
			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, flavor);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);
			
			// 실행 + 결과처리
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[등록 성공]");
				allAppleCount++; // 등록에 성공하면 카운팅 해야해서 추가!
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[등록 실패]");
		}
		BelloyDBManager.close(con, pstmt, null);
	}

	// 총 데이터가 몇 개 인지
	public void countApples() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BelloyDBManager.connect("belloyPool");
			
			String sql = "select count(*) from Apple";
			pstmt = con.prepareStatement(sql);  // 수행하게함
			rs = pstmt.executeQuery();			// 결과가 여기에 담김!
			rs.next();	// 반복문을 쓸 필요 x
			allAppleCount = rs.getInt("count(*)"); // 위에 설정한 변수에 값 담기
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		BelloyDBManager.close(con, pstmt, rs); // 일 끝났으면 close하기
	}
	
	// DB에 데이터가 100개 있다 ? => 해당 페이지 번호에 맞는 데이터만 가져오기
	public void getApples(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BelloyDBManager.connect("belloyPool");
			
			// allAppleCount : 전체 사과 데이터 수
			int applePerPage = 4; // 한 페이지당 보여줄 사과 데이터 수
			
			// 페이지 개수 가져오기(소수점의 값을 버려서는 안되는 부분임!! ex. 10 / 4 = 2.5)
			// Math.ceil : 숫자 올림 (반올림 X) // 올림처리를 할때는 int, 나눌때는 double
			int pageCount = (int)Math.ceil(allAppleCount / (double)applePerPage);
			request.setAttribute("pageCount", pageCount);
			/////////////////////////////////////////////////////////////////////
			int start = (applePerPage * (pageNo - 1)) + 1;
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);
			
			
			String sql = "select * from ( "
					+ "select rownum as rn, a_location, a_color, a_flavor, a_price, a_introduce "
					+ "from ( "
					+ 		"select * "
					+ 		"from Apple "
					+ 		"order by a_price"
					+ 		") "
					+ 	") "
					+ "where rn >= ? and rn <= ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			
			while (rs.next()) {
				apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				apples.add(apple);
			}
			request.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BelloyDBManager.close(con, pstmt, rs);
	}
	
	// 상세정보 가져오기(Primary Key)
	// 제대로 데이터를 가져왔으면 : true
	// 실패했으면 : false
	
	public boolean getAppleDetail(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = BelloyDBManager.connect("belloyPool");
			
			String location = request.getParameter("a_location"); // 지역을 파라미터로 가져옴
			
			String sql = "select * from Apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Apple apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				request.setAttribute("apple", apple);
				return true;
			} 
			return false;	// ex) 다른 사람이 그 데이터를 지웠으면 : 데이터 없음
		} catch (Exception e) {
			e.printStackTrace();
			return false;	// DB서버 상태가 안 좋음 (ex : 서버가 안켜짐)
		} finally {
			BelloyDBManager.close(con, pstmt, rs);
		}
	}
	
	public boolean update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BelloyDBManager.connect("belloyPool");
			
			request.setCharacterEncoding("UTF-8");
			String location = request.getParameter("a_location");
			String color = request.getParameter("a_color");
			String flavor = request.getParameter("a_flavor");
			int price = Integer.parseInt(request.getParameter("a_price"));
			String introduce = request.getParameter("a_introduce");
			
			String sql = "update Apple set "
					+ "a_color = ?, "
					+ "a_flavor = ?, "
					+ "a_price = ?, "
					+ "a_introduce = ? "
					+ "where a_location = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, color);
			pstmt.setString(2, flavor);
			pstmt.setInt(3, price);
			pstmt.setString(4, introduce);
			pstmt.setString(5, location);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[수정 성공]");
				return true;
			} else {
				request.setAttribute("r", "[수정 실패]");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[수정 실패]");
			return false;
		} finally {
			BelloyDBManager.close(con, pstmt, null);
		}
	}
	
	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = BelloyDBManager.connect("belloyPool");
			
			String location = request.getParameter("a_location");			
			String sql = "delete from Apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[삭제 성공]");
				allAppleCount--;
			} else {
				request.setAttribute("r", "[삭제 실패]");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[삭제 실패]");
		}
		BelloyDBManager.close(con, pstmt, null);
	}
	
}

package com.belloy.jun283.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.belloy.db.manager.BelloyDBManager;

public class MemberDAO {

	private static final MemberDAO MEMBERDAO = new MemberDAO();

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getMemberdao() {
		return MEMBERDAO;
	}

	public void register(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = BelloyDBManager.connect("belloyPool");
			
			
			// multipartrequest 추가해서 img 처리!!!
			
			
			
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("m_id");
			String pw = request.getParameter("m_pw");
			String name = request.getParameter("m_name");
			String number = request.getParameter("m_number");
			int birth = Integer.parseInt(request.getParameter("m_birth"));
			String photo = request.getParameter("m_photo");

			String sql = "insert into jun_member values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, number);
			pstmt.setInt(5, birth);
			pstmt.setString(6, photo);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[회원가입 성공]");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[회원가입 실패]");
		}
		BelloyDBManager.close(con, pstmt, null);
	}

	public static void login(HttpServletRequest req, HttpServletResponse res) {

		try {
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("m_id");
			String pw = req.getParameter("m_pw");
			String name = req.getParameter("m_name");
			String number = req.getParameter("m_number");
			int birth = Integer.parseInt(req.getParameter("m_birth"));
			String photo = req.getParameter("m_photo");

			if (id.equals("저장된 id 값") && pw.equals("저장된 id값의 pw")) {
				Member m = new Member(id, pw, name, number, birth, photo);
				req.getSession().setAttribute("m", m);
			}

			Cookie c = new Cookie("lastLoginId", pw);
			res.addCookie(c);
		} catch (Exception e) {
		}

	}

	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("m");
		return (m != null);
	}

}

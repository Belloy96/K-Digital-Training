package com.belloy.jun241.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class NBGameEngine {
	private int turn;
	private int strike;
	private int ball;
	
	public static final NBGameEngine NBG = new NBGameEngine();
	
	public NBGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public static NBGameEngine getNbg() {
		return NBG;
	}

	public static String pickAns() {
		int a = new Random().nextInt(976) + 12;
		String ans = String.format("%03d", a);

		if (ans.charAt(0) == ans.charAt(1) || ans.charAt(0) == ans.charAt(2) || ans.charAt(1) == ans.charAt(2)) {
			return pickAns();
		}
		return ans;
	}

	public static void main(String[] args) {
		String ans = pickAns();
		System.out.println(ans);
	}

	public void doNB(HttpServletRequest request) {
		int userNum = Integer.parseInt(request.getParameter("userNum"));

		String strUserNum = String.format("%03d", userNum);

		if (strUserNum == pickAns()) {
			request.setAttribute("c", "정답");
			turn++;
		} else if (strUserNum.charAt(0) == pickAns().charAt(0) || strUserNum.charAt(1) == pickAns().charAt(1)
				|| strUserNum.charAt(2) == pickAns().charAt(2)) {
			strike ++;
			turn++;
		} else if (strUserNum.charAt(0) == pickAns().charAt(0) && strUserNum.charAt(1) == pickAns().charAt(1)
				&& strUserNum.charAt(2) != pickAns().charAt(2)
				|| strUserNum.charAt(0) == pickAns().charAt(0) && strUserNum.charAt(1) != pickAns().charAt(1)
						&& strUserNum.charAt(2) == pickAns().charAt(2)
				|| strUserNum.charAt(0) != pickAns().charAt(0) && strUserNum.charAt(1) == pickAns().charAt(1)
						&& strUserNum.charAt(2) == pickAns().charAt(2)) {
			strike = strike + 2;
			turn++;
		} else if (strUserNum.charAt(0) == pickAns().charAt(1) || strUserNum.charAt(0) == pickAns().charAt(2)
				|| strUserNum.charAt(1) == pickAns().charAt(0) || strUserNum.charAt(1) == pickAns().charAt(2)
				|| strUserNum.charAt(2) == pickAns().charAt(0) || strUserNum.charAt(2) == pickAns().charAt(1)) {
			ball++;
			turn++;
		} else if (strUserNum.charAt(0) == pickAns().charAt(1) && strUserNum.charAt(1) == pickAns().charAt(2)
				|| strUserNum.charAt(0) == pickAns().charAt(2) && strUserNum.charAt(1) == pickAns().charAt(0)
				|| strUserNum.charAt(1) == pickAns().charAt(0) && strUserNum.charAt(2) == pickAns().charAt(1)
				|| strUserNum.charAt(1) == pickAns().charAt(2) && strUserNum.charAt(2) == pickAns().charAt(0)
				|| strUserNum.charAt(2) == pickAns().charAt(1) && strUserNum.charAt(0) == pickAns().charAt(1)
				|| strUserNum.charAt(2) == pickAns().charAt(2) && strUserNum.charAt(0) == pickAns().charAt(2)) {
			ball = ball + 2;
			turn++;
		} else if (strUserNum.charAt(0) == pickAns().charAt(1) && strUserNum.charAt(1) == pickAns().charAt(2)
				&& strUserNum.charAt(2) == pickAns().charAt(0)
				|| strUserNum.charAt(1) == pickAns().charAt(2) && strUserNum.charAt(2) == pickAns().charAt(0)
						&& strUserNum.charAt(0) == pickAns().charAt(1)
				|| strUserNum.charAt(2) == pickAns().charAt(1) && strUserNum.charAt(0) == pickAns().charAt(2)
						&& strUserNum.charAt(1) == pickAns().charAt(0)) {
			ball = ball + 3;
			turn++;
		} else {
			turn++;
		}
		
		request.setAttribute("t", turn);
		request.setAttribute("s", strike);
		request.setAttribute("b", ball);
		
	}
	
	public void reset(HttpServletRequest request) {
		turn = 0;
		strike = 0;
		ball = 0;
		request.setAttribute("t", turn);
		request.setAttribute("s", strike);
		request.setAttribute("b", ball);
		request.setAttribute("c", "시도횟수 초기화");
	}
}

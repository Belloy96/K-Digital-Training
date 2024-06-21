package com.belloy.jun213.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class HJGameEngine {
	private int win;
	private int lose;
	private int turn;
	private String pp;
	
	public static final HJGameEngine HJ = new HJGameEngine(); 
	
	public HJGameEngine() {
		// TODO Auto-generated constructor stub
	}
	
	public static HJGameEngine getHj() {
		return HJ;
	}

	public void doHJ(HttpServletRequest request) {
		
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		request.setAttribute("uh", + userHand + ".png");
		
		int comHand = new Random().nextInt(10) + 1;
		request.setAttribute("q", comHand + "개");
		
		// String gameAns = (coin % 2 == 0) ? "짝" : "홀";
		// request.setAttribout("r", gameAns);
		
		// if (userAns == (coin % 2)){
		//	t++;
		//	win++;
		// } else {
		//	 t++;
		//	 lose++;
		// }
		
		if (comHand % 2 == 0) {
			comHand = 2;
		} else {
			comHand = 1;
		}
		request.setAttribute("ch", + comHand + ".png");
		
		// 판정 프로그램!!!
		
		int resultUh = userHand % 2;
		int resultCh = comHand % 2;
		
		if (resultUh == resultCh) {
			request.setAttribute("r", "승");
			win ++;
			turn ++;
		} else {
			request.setAttribute("r", "패");
			lose ++;
			turn ++;
		}
		
		request.setAttribute("t", turn + "트");
		request.setAttribute("w", win + "승");
		request.setAttribute("l", lose + "패");
		double p = (win / (double) turn) * 100;
		pp = String.format("%.2f", p);
		request.setAttribute("p", "(승률 : " + pp + "%)");
	}
	
	// 초기화
	public void reset(HttpServletRequest request) {
		win = 0;
		lose = 0;
		turn = 0;
		pp = "0";
		request.setAttribute("t", turn + "트");
		request.setAttribute("w", win + "승");
		request.setAttribute("l", lose + "패");
		request.setAttribute("p", "(승률 : " + pp + "%)");
		request.setAttribute("r", "전적 초기화 완료");
	}
	
}


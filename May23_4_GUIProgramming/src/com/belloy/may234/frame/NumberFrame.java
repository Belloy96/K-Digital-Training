package com.belloy.may234.frame;

import java.awt.Color;
import java.awt.LayoutManager;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// JFrame 생성(500, 500)
// JPenel안에 1 ~ 30까지의 숫자가 랜덤한 위치에 나오게

// 숫자를 여러 개 뽑을 때 >> 반복문
// array[]
// 글자가 표현되게 하려면 => JLabel을 이용

// set~~
// 배경색도 바꿔보고..
// 글자색도 바꿔보고..
// Color.XXX

public class NumberFrame extends JFrame{
	JPanel p = new JPanel();
	JLabel[] l = new JLabel[30];
	
	public NumberFrame() {
		p.setLayout(null);
		p.setBackground(Color.WHITE);
		Random r = new Random();
		int x = 0;
		int y = 0;
		int rr = 0; // RGB값
		int gg = 0; // RGB값
		int bb = 0; // RGB값
		int aa = 0; // 투명도
		Color c = null;
		for (int i = 0; i < 30; i++) {
			l[i] = new JLabel("" + (i + 1));
			x = r.nextInt(500) + 1;
			y = r.nextInt(500) + 1;
			rr = r.nextInt(256);
			gg = r.nextInt(256);
			bb = r.nextInt(256);
			aa = r.nextInt(256);
			c = new Color(rr, gg, bb, aa);
			l[i].setForeground(c);
			l[i].setLocation(x, y);
			l[i].setSize(50, 50);
			p.add(l[i]);
		}
		add(p);
		setTitle("뒤죽박죽 숫자");
		setSize(500, 500);
		setVisible(true);
	}
}

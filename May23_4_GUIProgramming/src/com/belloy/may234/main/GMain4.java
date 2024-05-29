package com.belloy.may234.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.belloy.may234.frame.BMIFrame;


public class GMain4 {
	public static void main(String[] args) {
		// 제목이 BMI검사인 JFrame
		JFrame jf = new JFrame("BMI 검사");
		
		// 3행 2열짜리 GridLayout
		GridLayout gl = new GridLayout(3, 2);
		
		// JFrame의 레이아웃 속성을 gl로 사용
		jf.setLayout(gl);
		
		JLabel heightLB = new JLabel("키(cm)입력 : ");
		jf.add(heightLB);
		
		JTextField heightTf = new JTextField();
		jf.add(heightTf);
		
		JLabel weightLb = new JLabel("몸무게(kg)입력 : ");
		jf.add(weightLb);
		
		JTextField weightTf = new JTextField();
		jf.add(weightTf);
		
		JLabel resultLb = new JLabel("결과 : ");
		jf.add(resultLb);
		
		JButton okay = new JButton("확인");
		jf.add(okay);
		
		BMIFrame bf = new BMIFrame(heightTf, weightTf, resultLb);
		okay.addActionListener(bf);
		
		jf.setSize(450, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
}

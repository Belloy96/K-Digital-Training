package com.belloy.may234.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

// 계산
// String => double
//		=> Double.parseDouble();

// BMI : xx.x이고, 당신은 xx입니다.
// System.out.printf(); = String.format();
// String을 형식 잡아서 만들기

public class BMIFrame implements ActionListener{
	private JTextField htf;
	private JTextField wtf;
	private JLabel rlb ;
	
	public BMIFrame() {
		// TODO Auto-generated constructor stub
	}

	public BMIFrame(JTextField htf, JTextField wtf, JLabel rlb) {
		super();
		this.htf = htf;
		this.wtf = wtf;
		this.rlb = rlb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("계산");
		double h = Double.parseDouble(htf.getText());
		double w = Double.parseDouble(wtf.getText());
		h /= 100;
		double bmi = w / (h * h);
		String result = "저체중";
		if (bmi >= 40) {
			result = "고도비만";
		} else if (bmi >= 35) {
			result = "중증도비만";
		} else if (bmi >= 30) {
			result = "경도비만";
		} else if (bmi >= 25) {
			result = "과체중";
		} else if (bmi >= 18.5) {
			result = "정상";
		} 
		
		String finalResult = String.format("BMI : %.2f, 당신은 %s입니다.",
				bmi, result);
		rlb.setText(finalResult);
		
		
	}
	
}

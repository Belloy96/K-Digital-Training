package com.belloy.may282.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// 통신
//		일반적인 통신 (요청하면 답 오는 것)
//			- HTTP 통신 (단방향 연결이 이루어지는 통신 / 요청하면 => 응답하는)
//		실시간 통신 (냅다 답 오는 것)
//			- Socket 통신 (양방향 연결이 이루어지는 통신)

// 서버 - 서비스를 제공하는 컴퓨터
// 클라이언트 - 서비스를 이용하는 컴퓨터

// IP주소 - 네트워크 통신을 할 때 사용하는 전화번호 같은 느낌
//		확인 : 시작 - cmd - ipconfig
//		IPv4 주소 : 192.168.0.xxx

// 포트번호 - 무슨 서비스를 이용하러...
//		0 ~ 65535
//		웹서비스 	 : 80번
//		OracleDB : 1521번
//		이미 약속된 포트번호가 있어서 4자리 넘게 지정(May28Socket포트번호값)

public class SSMain2 {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(); // 포트번호 지정
			System.out.println("...");
			
			Socket s = ss.accept();
			System.out.println("연결됨 !");
			Scanner k = new Scanner(System.in);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			//
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			JFrame jf = new JFrame();
			JTextArea jta = new JTextArea();
			jf.add(jta);
			jf.setSize(500, 500);
			jf.setVisible(true);
			
			// Thread는 프로그램 내에서 동신에 여러 작업을 처리할 수 있게 해주는 기능
			Thread t = new Thread() {
				@Override
				public void run() {
					super.run();
					while (true) {
						try {
							jta.append("상대] " + br.readLine() + "\r\n");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			t.start();
			while (true) {
				System.out.print("나] ");
				String msg = k.nextLine();
				bw.write(msg + "\r\n");
				jta.append("나] " + msg + "\r\n");
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ss.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}

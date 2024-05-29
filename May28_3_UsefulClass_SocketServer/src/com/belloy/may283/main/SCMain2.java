package com.belloy.may283.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SCMain2 {
	public static void main(String[] args) {
		Socket s = null;
		try {
			s = new Socket("192.168.0.9", 7777); // 상대 ip주소(서버), 포트번호
			System.out.println("연결됨 !");
			Scanner k = new Scanner(System.in);
			
			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			while (true) {
				System.out.printf("상대] %s\n", br.readLine());
				
				System.out.print("나] ");
				String msg = k.nextLine();
				bw.write(msg + "\r\n");
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

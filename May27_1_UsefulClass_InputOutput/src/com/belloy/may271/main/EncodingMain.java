package com.belloy.may271.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class EncodingMain {
	
	// Encoding : 정보의 형태나 형식을 변환하는 처리방식
	// 컴퓨터 : 전자기계 (전기가 흐르거나, 안 흐르거나)
	// 'ㅋ' => 전기의 흐름으로 표현 (ex : 모스부호) => encoding
	
	// Decoding : 인코딩 된 데이터 통신 전송 및 파일을 원래의 상태로 변환
	// 전기의 흐름 => 'ㅋ' : decoding
	
	// encoding 방식은 여러 종류가 있음 !
	// 추석 -A-> 1010 -A-> 추석 (Encoding과 Decoding은 같은 방식으로 처리되어야 함)
	// 추석 -B-> 0101 -C-> 설날 (Encoding과 Decoding이 다른 방식으로 처리되면..)
	// 추석 -C-> 0001 -???-> ?!?!?!
	
	// 전세계적으로 주력 : UTF-8 (Unicode Transform Format)
	// 한국만 타겟 : EUC-KR
	// MS전용 : MS949
	
	public static void main(String[] args) {
//		FileOutputStream fos = null;	// 파일저장 경로설정
//		try {																			// true = 이어붙이기 , false = 덮어쓰기
//			fos = new FileOutputStream("C:\\Users\\tpgns\\OneDrive\\바탕 화면\\Test/belloy.txt", true);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		OutputStreamWriter osw = null;	
//		try {
//			osw = new OutputStreamWriter(fos, "UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		BufferedWriter bw = new BufferedWriter(osw);
//		try {
//			bw.write("asdfsafsd");
//			bw.append("\r\n"); // \n으로만 해도 요즘에는 파일처리가 ok
//			bw.append("으아아아아아악" + "\r\n");
//			bw.append("5월이 끝나간다고!!!" + "\r\n");
//			bw.flush(); // append 작업이 끝나면 flush 넣기
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			bw.close(); // bw작업이 끝나면 close 넣기
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\tpgns\\OneDrive\\바탕 화면\\Test\\belloy.txt");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			br = new BufferedReader(isr);
			
			String line = null;
			while (( line = br.readLine() ) != null) {
				System.out.println(line);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

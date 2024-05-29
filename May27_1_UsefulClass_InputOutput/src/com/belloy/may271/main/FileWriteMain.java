package com.belloy.may271.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// CPU		: 연산장치
// RAM		: 저장장치(임시) - 재부팅하면 날아감
//			static / stack - 프로그램을 끄면(종료하면) 날아감
//			heap - 자동으로 날아감 X (GC있으면 자동으로 날아감)
// HDD(SSD)	: 저장장치(영구) - 파일
// GPU 		: 그래픽처리용 ( CPU + RAM + HDD / 보조적인 역할을 해줄 수 있음)

// 프로그램에서는 데이터를 외부에서 읽고, 다시 외부로 출력하는 작업 자주 발생
// 데이터는 사용자로부터 키보드를 통해서 입력될 수도 있고,
//					(Scanner의 System.in에 해당하는 내용)
// 파일.네트워크에서도 입력될 수 있다 (???) => (Input)

// 반대로 데이터는 모니터를 통해서 출력될 수도 있고, 
//				(System.out.println)
// 파일.네트워크에서도 출력될 수 있다 (???) => (Output)

// System.in => InputStream (이라는 클래스)
// System.out => PrintStream (이라는 클래스)
// #그림판 참조#

// 'Stream' : '빨대' - '나'와 '음료'를 연결하는... <= 선생님 비유
//		기본형
//			InputStream			: 장치 => 프로그램으로 입력 (1byte씩)
//			InputStreamReader	: 빨대 크기 Up!, 2byte씩 + 인코딩방식
//			BufferedReader		: (1String - line), 빨대 크기 Up! 

//			OutputStream		: 프로그램의 결과를 => 장치로 출력 (1byte식)
//			OutputStreamWriter	: 2byte씩 + 디코딩방식
//			BufferedWriter		: 1 line

//		개조형 (특수목적에 맞게)
//			PrintStream (OutputStream 개조) 		- 쓰기 편하게 유용한 메소드들 추가
//			FileReader	(IntputStream 개조) 		- 파일에서 데이터를 읽어오기 편하게
//			FileWriter	(OutputStreamWriter 개조)	- 데이터 출력하기 편하게
//			...
public class FileWriteMain {
	public static void main(String[] args) {
		
		Scanner k = new Scanner(System.in);
		System.out.print("입력 : ");
		String cmt = k.next();
		System.out.println("------------");
		
		
		// FileWriter
		//		프로그램 => 파일
		//		파일이 없으면 만들어주기도 함
		//		폴더는 안 만들어줌 (반드시 폴더가 존재해야함)
		// Linux의 경로 	: C:/Users/tpgns/OneDrive/바탕 화면/Test/belloy1.txt
		//		=> /로 경로 설정
		// Windows의 경로 	: C:\\Users\\tpgns\\OneDrive\\바탕 화면\\Test\\belloy1.txt
		//		=> \\로 경로 설정 + / 하나로도 가능!
		// Java의 \는 : \t, \r, \n, \0, ... (이스케이프 문자) 에 사용
		// 권한, 폴더명 오타, ... => 예외처리! (e.printStackTrace가 알려줌)
		
		
		// fw 위에 bw 덧씌운 상태
		// bw를 close로 닫았는데, 굳이 fw를 닫지 않은 이유는 
		// 연관된 것들 중에서 하나만 닫으면 다 처리를 해줌
		BufferedWriter bw = null;
		try {
			// 지정한 파일이 없으면 새로 만들어주고,
			// 파일이 이미 존재하고 있으면 덮어쓰기 때문에
			// 기존에 있던 파일의 내용은 사라지게 됨
			// 기존의 내용 뒤에 덧붙이고 싶으면 (데이터를 추가하고 싶다면)
			// 두번째 파라미터의 값으로 true를 주면 됨(덮어쓰기 = false)
			
			// Encoding 방식을 지정하는 영역은 없음 => ANSI로 인코딩 됨 <FileWriter
			FileWriter fw = new FileWriter("C:\\Users\\tpgns\\OneDrive\\바탕 화면\\Test/belloy1.txt", true);
			
			// 한 바이트씩(1byte) 입출력하기도다는
			// '버퍼'를 이용해서 한 번에 여러 바이트를 입출력하는 것이 빠름
			//		=> 대부분의 입출력 작업에서 사용
			// 버퍼 	: CPU와 HDD 사이에서 사용되는 임시 저장 공간
			// 버퍼링 	: <데이터>를 버퍼로 저장하는 동작
			//		=> 실행성능 향상 시킬 수 있음
			// #그림판 참조# - Buffer에 데이터를 담아놓았다가
			//		일정 이상이 되면 CPU로 보내고, CPU는 한 번에 처리하게 됨 => 효율적
			bw = new BufferedWriter(fw);
			bw.write(cmt + "\r\n");
			bw.write("--------------\r\n");
			bw.flush(); // 버퍼 용량이 다 안채워져도 강제적으로 내보내기 (flush 설명)
						// 버퍼의 모든 데이터 다 보내기 			  (flush 설명)
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}

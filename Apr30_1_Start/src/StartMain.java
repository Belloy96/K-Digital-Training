
public class StartMain {
	public static void main(String[] args) {
		// 주석 (Comment) : 필기, 기능설명 용도
		// / : Slash
		// \ : BackSlash
		
		// 한 줄 주석
		
		/*
		 * 여러 줄 주석 처리하는 방법입니다!
		 */
		
		/**
		 * 다른 사람들에게 보여주기 위한 설명서
		 * @author Belloy
		 * @version 1.1.10
		 */
		
		// 외국인들이랑 대화를 나누려면 그 나라의 언어를 공부하듯이
		// 컴퓨터로 코드를 짜려면 프로그래밍 언어를 공부해야함
		// Java !
		// 프로그램 만들 때 사용하는 프로그래밍 언어 중 하나
		// 세심하게 하나하나 개발자가 손을 봐줘야함!
		// 상대적으로 저급언어
		// => 먼저 Java를 공부하고 나중에 다른 언어 (Python)을
		// 습득할 때 좀 더 쉬울 것 !
		// 전 세계적으로 많이 쓰는 언어 중 하나 !
		// => 개발자들이 작업한 자료들을 공개 / 공유하는 문화가 존재 !
		
		// OpenJDK
		// .msi / .zip
		// 설치버전 : 한 컴퓨터에서 Eclipse를 여러개 사용 O
		// 압축버전 : 한 컴퓨터에서 Eclipse를 하나만 사용 O
		
		// Java를 사용하려면 JDK(Java Development Kit)가
		// 설치되어 있어야 하는데
		// JDK = JRE + 실행 키트를 합쳐놓은 개념
		// JRE (Java Runtime Environment)
		// : Java로 만든 프로그램을 실행할 수 있게 하는 것
		// Oracle JDK vs OpenJDK
		// Sun마이크로시스템즈에서 만든 제품 - Java
		// Sun사가 Oracle에 인수를 당함
		// Oracle의 제품 - Java
		// Oracle JDK(OpenJDK + 추가 기능) : 유료
		// OpenJDK : 무료
		
		// 많은 회사들이 이미 OpenJDK를 사용 !
		// LTS (Long Term Support)
		
		// javac.exe : JDK에 포함이 되어있는 주요한 Java의 "컴파일러"
		// (Compiler)
		// 텍스트 파일(Hello)을 ByteCode(실행을 하기 위한 이진 표현법)
		// 로 변환, 이엇을 Compile이라고 함
		// 이 컴파일 과정 해주는게 javac !
		// 텍스트 파일을 javac로 실행하면,
		// .class파일이 생성된 것을 볼 수 있음 !
		
		// java.exe : 컴파일 된 .class파일을 실행시켜주는 프로그램
		
		// 결론!
		// javac.exe : 영어, 한국어... -번역 -> 기계어
		// java.exe : 기계어 -실행 -> 
		
		// Eclipse
		// 통합 개발 환경
		// IntelliJ(유료, 돈값은 함), VSCode, ...
		// 무료(Eclipse 선택한 이유)
		
		// Developer vs Enterprise
		// 기본적인 서비스만 제공 vs 기본 서비스 + 추기 가능
		
		// Encoding
		// 사람이 입력한 글자를 컴퓨터가 사용할 수 있게
		// 특정한 전기 신호로 바꿔주는 것
		// MS949, UTF-8(Eclipse 기본설정 되어있음), EUC-KR, ...
		
		// 유용한 단축키!
		// 1. ctrl + s : 저장(항상 하기)
		// 2. ctrl + a : (코드) 전체 선택
		// 3. ctrl + m : 화면 비율
		// 4. ctrl + shift + / : 여러 줄 주석처리
		// 5. ctrl + alt + 방향키(위/아래) :
		//		커서가 있는 줄을 기준으로 (위/아래로) 복사
		// 6. alt + 방향키(위/아래) :
		//		그 줄을 위/아래로 이동
		// 7. ctrl + shift + +/- (숫자키 옆) :
		//		글자 크기를 키우거나 / 줄일 때
		// 8. ctrl + d : 그 줄 삭제(유용함)
		// 9. ctrl + spacebar : 자동완성(유용함)
		// 10. ctrl + shift + f : 줄 정리 기능(유용함)
		// 11. ctrl + f11 : 실행 기능
	}
}

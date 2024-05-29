import java.util.Random;

public class FMain1 {
	
	// B : 함수명 / 기능이 대충이라도 보이게, 동사같은 작명,
	//			  낙타체 or 뱀체
	// C : 파라미터 / 함수를 호출하는 쪽(main 함수)에서 해당 함수로
	//			   데이터를 보낼 때
	//			   ( 자료형 변수명, 자료형 변수명, ... )
	// A : 리턴타입 / 해당 함수에서 작업한 결과를 호출한 쪽(main)
	//				으로 보낼 때
	//			   return 예약어와 한 쌍 # void => 리턴할게 없음 #
	
	// public static A B (C) {
	//		내용
	//		return
	// }
	
	// 랜덤한 정수 하나를 구하는 함수
	public static int getNum() {
		Random r = new Random();
		int i = r.nextInt();
		return i;
	}
	
	// 두 정수를 더한 값을 출력하는 함수
	public static void printSum (int a, int b) {
		System.out.println(a + b);
		
	}
	
	// 정수 두개를 넣으면, 그 중에서 큰 숫자를 출력해주는 함수
	//	(두 숫자가 같으면 뒤의 숫자 출력)
	
	public static void printBigger (int a, int b) {
		int bigNum = (a > b) ? a : b;
		System.out.println(bigNum);
		
	}
	
	// 실수 두개를 넣으면, 그 중에서 큰 숫자를 구해주는 함수
	//	(두 숫자가 같으면 뒤의 숫자 구하기)
	public static double getBigger (double a, double b) {
		double bigNum = (a > b) ? a : b;
		return bigNum;
	}
	
	public static void main(String[] args) {
		// 랜덤한 정수 2개를 구해서...
		int x = getNum();
		int y = getNum();
		// 그 2개의 수를 더한 값을 출력
		printSum(x, y);
		printBigger(x, y);
		double bigNum = getBigger(1.3, 4.5);
		System.out.println(bigNum); 
		// bigNum 대신 (getBigger(x, y)) 가능하나, 다른 곳에서 쓸 수 없음, 편의성?
		
	}
	
}

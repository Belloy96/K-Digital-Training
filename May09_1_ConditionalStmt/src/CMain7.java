import java.util.Scanner;

public class CMain7 {
	// f1 : 정수를 하나 입력 받아서
	// 그게 양수면 "양" / 0이면 "0" / 음수면 "음"
	
	// f2 : 정수를 하나 입력 받아서
	//	3의 배수면 "3의 배수"
	//	4의 배수면 "4의 배수" -> 공배수 생각
	//	둘다 아니면 "몰라!!!"
	//	를 판정해주는 함수
	
	public static void getF1() {
		Scanner k = new Scanner(System.in);
		System.out.print("f1 : ");
		int i = k.nextInt();
		if (i > 0) {
			System.out.println("양");
		} else if (i == 0) {
			System.out.println("0");
		} else {
			System.out.println("음");
		}
	}
	
	public static void getF2() {
		Scanner k = new Scanner(System.in);
		System.out.print("f2 : ");
		int x = k.nextInt();
		if (x % 3 ==0 && x % 4 ==0) {
			System.out.println("3과 4의 공배수");
		} else if (x % 3 == 0) {
			System.out.println("3의 배수");
		} else if (x % 4 == 0) {
			System.out.println("4의 배수");
		} else if (x % 3 !=0 && x % 4 !=0) {
			System.out.println("몰라!!!");
		}
		
//		if (x % 12 == 0) {
//			return "3의 배수 + 4의 배수";
//		} else ...
	}
	
	
	
	public static void main(String[] args) {
		getF1();
		getF2();
		
	}
	
}

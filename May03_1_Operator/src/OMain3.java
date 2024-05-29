import java.util.Scanner;

// 논리연산자
//		결과가 boolean (true / false)
//		> (초과), >= (이상), < (미만), <= (이하), == (같다), != (다르다)

public class OMain3 {
	public static void main(String[] args) {
		// 놀이공원에서 놀이기구를 타도 되는지 판정해주는 프로그램
		// 키(cm), 나이를 입력받아서 출력
		
		// 나이가 10살이 넘는 사람만 탈 수 있음
		// 나이가 5살 미만만 탈 수 있음
		// 나이가 20살만 탈 수 있음
		// 나이가 1살이 아니면 탈 수 있음
		// 나이가 홀수면 탈 수 있음
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("키 :");
		double height = k.nextDouble();
		System.out.print("나이 :");
		int age = k.nextInt();
		System.out.println("-------------------");
		System.out.printf("키는 %.1fcm\n, 나이는 %d살\n", height, age);
		System.out.println("-------------------");
		
		boolean ride1 = (age > 10);
		System.out.printf("ride1 탑승 가능 ? : %b\n", ride1);
		boolean ride2 = (age < 5);
		System.out.printf("ride2 탑승 가능 ? : %b\n", ride2);
		boolean ride3 = (age == 20);
		System.out.printf("ride3 탑승 가능 ? : %b\n", ride3);
		boolean ride4 = (age != 1);
		System.out.printf("ride4 탑승 가능 ? : %b\n", ride4);
		boolean ride5 = (age % 2 != 0);
		// boolean ride5 = (age % 2 == 1);
		System.out.printf("ride5 탑승 가능 ? : %b\n", ride5);
		System.out.println("-------------------");
		
		// 업그레이드 !
		//		~고 (and)	: &&
		//		~거나 (or)	: || (shift + \)
		//		XOR			: ^
		//				(eXclusive(배타적) OR)
		//				=> 두 입력이 서로 다를 때
		//					'1' 결과값을 출력
		//		NOT			: ! 	=> 결과를 뒤집을 때
		
		// 나이가 3살이 넘고, 키가 2m 넘어야 탈 수 있음
		
		// 나이가 3살이 넘어야		키가 2m 넘어야
		//		95% 				5%
		//				=> 95%이상의 확률로 2번 검사해야 함
		
		// 키가 2m 넘어야			나이가 3살이 넘어야
		// 		5%					95%	
		//				=> 95%의 확률로 1번만 검사해도 됨
		// 즉, 낮은 확률을 먼저 쓰는 연습을 해보도록 하자
		
		// boolean ride6 = (age > 3) && (height > 200);
		// boolean ride6 = ((age > 3) && (height / 100) > 2); => m로 변환
		boolean ride6 = ((height / 100) > 2 && (age > 3));
		System.out.printf("ride6 탑승 가능 ? : %b\n", ride6);
		
		// 키가 1.9m가 넘거나, 나이가 50살 미만 탈 수 있음
		// boolean ride7 = ((age < 50) || (height / 100) > 1.9); => m로 변환
		boolean ride7 = (age < 50) || (height > 190);
		System.out.printf("ride7 탑승 가능 ? : %b\n", ride7);
		
		// 10 < 나이 < 40 이면 탈 수 있음
		boolean ride8 = (age < 40) && (age > 10);
		System.out.printf("ride8 탑승 가능 ? : %b\n", ride8);
		
		// 나이가 10살 이상이던지, 키가 1.5m 이상이던지 하나만 만족해야 !
		// boolean ride9 = ((age >= 10) ^ (height/100) >= 1.5); =>m로 변환
		boolean ride9 = (age >= 10) ^ (height >= 150);
		System.out.printf("ride9 탑승 가능 ? : %b\n", ride9);
		
		// ride9를 탈 수 있는 사람은 못 타고,
		//	ride9를 탈 수 없는 사람만 탈 수 있음
		boolean ride10 = !ride9;
		System.out.printf("ride10 탑승 가능 ? : %b\n", ride10);
		
		
		
		
		
	}
	
	
}

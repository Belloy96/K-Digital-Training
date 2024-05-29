import java.util.Iterator;

public class RMain3 {
	public static void main(String[] args) {
		// 별찍기
		
		// ㅋ
		// ㅋㅋ
		// ㅋㅋㅋ
		// ㅋㅋㅋㅋ
		// ㅋㅋㅋㅋㅋ
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("ㅋ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		// ㅋ
		//  ㅋ
		//   ㅋ
		//    ㅋ
		//     ㅋ
		
		// 1번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == j) {
					System.out.print("ㅋ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		// 2번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" "); // j가 i보다 작은 공간은
									   // 띄어쓰기로 메꿔줌
			}
			System.out.println("ㅋ");
		}
		System.out.println("-------------");
		
		// 3번째 방법
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++) {
					System.out.print((i == j) ? "ㅋ" : " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		// ㅋㅋㅋㅋㅋ
		// ㅎㅎㅎㅎ
		// ㅋㅋㅋ
		// ㅎㅎ
		// ㅋ
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (5 - i); j++) {
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
//				System.out.print("Z");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		for (int i = 4; i >= 0 ; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		// ㅋ
		// ㅎㅎㅎ
		// ㅋㅋㅋㅋㅋ
		// ㅎㅎㅎㅎㅎㅎㅎ
		// ㅋㅋㅋㅋㅋㅋㅋㅋㅋ
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= (i * 2); j++) {
				System.out.print((i % 2 == 0) ? "ㅋ" : "ㅎ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		//	   *
		//	  ***
		//	 *****
		//	*******
		// *********
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= (i * 2); j++) {
				System.out.print("*");
			}
			System.out.println();	
		}
		System.out.println("-------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < (i + 6); j++) {
				System.out.print((i + j >= 5) ? "*" : " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
		
	}	
}

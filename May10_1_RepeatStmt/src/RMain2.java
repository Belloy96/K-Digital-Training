

// 이중 for문 >> for문안에 for문 >> 중첩 for문

public class RMain2 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			System.out.printf("i값 : %d--------\n", i);
			for (int j = 1; j < 6; j++) {
				System.out.printf("j값 : %d\n", j);
			}
		}
		System.out.println("--------------------");
		
		// 구구단
		// <2단>
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// 9 x 9 = 81
		for (int dan = 2; dan < 10; dan++) {
			System.out.printf("<%d단\n>", dan);
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d x %d = %d\n",dan, j, dan * j);
			}
		}
		System.out.println("--------------------");
		
//		int mul = 1;
//		for (int i = 1; i <= 9; i++) {
//			System.out.printf("<%d단>\n", i);
//			for (int j = 1; j <= 9; j++) {
//				mul = i * j;
//				System.out.printf("%d x %d = %d\n",i, j, mul);
//			}
//		}
//		System.out.println("--------------------");
		
		// 구구단 출력을 가로로 ! => 새로운 단수가 나오면 \n대신 무언가?
		for (int i = 2; i <= 9; i++) {
			System.out.printf("<<< %d단 >>>\t", i);
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int dan = 2; dan < 10; dan++) {
				System.out.printf("%d x %d = %d\t", dan, i, dan * i);
			}
			System.out.println();
			}
		System.out.println("-------------");
	}
}




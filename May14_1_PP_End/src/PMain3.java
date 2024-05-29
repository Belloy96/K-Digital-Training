
public class PMain3 {
	// 정수 두개 넣으면 그 합을 출력하는 함수
	public static void printSum(int a, int b) {
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.println("-------------");
	}

	// 정수 세개 넣으면 그 합을 출력하는 함수
	// *** 오버로딩 : 본질이 같다면 굳이 함수의 이름을 다르게 할 필요 없다!
	// printSum / printSum2 => printSum
	public static void printSum(int a, int b, int c) {
		System.out.printf("%d + %d + %d = %d\n", a, b, c, a + b + c);
		System.out.println("-------------");
	}

	// 정수를 n개 넣으면 그 곱을 출력하는 함수 (파라미터가 몇 개인지 모름...)
	// 함수 파라미터로 개수 무제한
	// (자료형...변수명) <- 새로운 지식!
	public static void printMul(int... n) {
		int mul = 1;
		// 함수 내에서 사용할 때는 배열처럼!!
		for (int i = 0; i < n.length; i++) {
			mul *= n[i];
		}
		System.out.println(mul);
	}

	public static void main(String[] args) {
		printSum(1, 2);
		printSum(2, 4, 6);
		printMul(1, 3, 4, 6, 10);
	}

}


public class FMain4 {
	
	// *** 고급기술 !!!
	// 오버로딩(Overloading)
	//	함수명 같게, 파라미터를 다르게 하는 기술
	//	호출할 때 어떤 값을 넣었느냐에 따라 함수가 불러지게 하는 기술
	
	// 같은 자료형을 써도, 파라미터의 갯수가 다르면 오버로딩 O
	// 파라미터의 갯수가 같아도, 다른 자료형을 사용하면 오버로딩 O
	//	=> ** '그 함수들이 같은 기능을 하고있다' 전제조건!
	
	// 정수 2개를 넣으면 그 합을 출력해주는 함수 \
	// 정수 3개를 넣으면 그 합을 출력해주는 함수	 => printSum1,2,3 으로 했지만 printSum하나로도 가능
	// 실수 3개를 넣으면 그 합을 출력해주는 함수 /
	
	public static void printSum(int a, int b) {
		System.out.println(a + b);
	}
	
	public static void printSum(int a, int b, int c) {
		System.out.println(a + b + c);
	}	
	
	public static void printSum(double a, double b, double c) {
		System.out.println(a + b + c);
	}	
	
	// 정수 1개를 넣으면 => 윽! 출력
	// 문자열 1개를 넣으면 => 악! 출력
	// 실수 1개를 넣으면 => 으아아악! 출력
	// 아무것도 넣지 않으면 => ... 출력
	
	public static void tired (int qwer) {
		System.out.println("윽!");
	}
	
	public static void tired (String asdf) {
		System.out.println("악!");
	}
	
	public static void tired (double zxcv) {
		System.out.println("으아아악!");
	}
	
	public static void tired () {
		System.out.println("...");
	}
	
	public static void main(String[] args) {
		printSum(1, 2);
		printSum(3, 4, 5);
		printSum(6.6, 7.7, 8.8);
		tired(1);
		tired("아");
		tired(1.1);
		tired();
		
		// 사실 우리는 첫날부터 이 오버로딩을 사용하고 있었습니다 !
		// o0o !
		// System.out.println();
		
	}
}


public class FMain2 {
	public static void test(int b) {
		// 파라미터 값을 불러오고 그 다음 함수 안에 있는
		// 내용이 진행이 되어서 b가 먼저 stack에 쌓이게 됨
		int a = 123;
		System.out.println(b);		// 30
		System.out.println(a + b);	// 153
	}
	
	public static void main(String[] args) {
		int a = 10; // 지역변수 (local variable)
		int b = 20; //	: 함수 내에서 만든 변수
		int c = 30; //	  그 함수 안에서만 사용이 가능 O
		
		// => 같은 공간 안에서는 같은 이름의 변수를 만들 수 없다!
		// int a = 100; => 에러 !
		// 그림판 사용
		
		test(c);
		System.out.println(b); 		// 20 
	}
	
}

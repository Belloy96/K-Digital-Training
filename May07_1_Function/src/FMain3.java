
public class FMain3 {
	public static void test(int q) { // q (blue) : 파라미터
		System.out.println(q); // 10 (q/blue)
		q = 20;
		System.out.println(q); // 20 (q/blue)
		// test 영역으로 넘어온 이상
		// 이쪽 내용을 다 끝내고 다시 main 영역으로 돌아감
	}
	
	public static void main(String[] args) {
		int q = 10; // q (red) : 지역변수 / 그림판 사용
		System.out.println(q); // 10 (q/red)
		test(q); // test함수가 호출, q (blue) 변수 생성
				 // q (blue)에 q (red)에 있는 값을 복사해서 넣어주기
		
		System.out.println(q); // 10 (q/red)
		// 더 이상 내용이 없으니 프로그램이 종료 ! 
		// 나오는 순서는 main의 q -> test의 q -> main의 q
		
	}
}

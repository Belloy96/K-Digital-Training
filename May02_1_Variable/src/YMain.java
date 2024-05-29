
public class YMain {
	public static void main(String[] args) throws InterruptedException {
		// 예제
		// 학원 오는데 얼마나 걸렸는지 (시간) : 1.5시간
		// 어제 저녁 메뉴 ? : ???
		// 어제 뭐하셨나요 ? : ???
		// 취침 시간 : ?시 ?분
		// 첫 수업 소감 : ???
		// 수업 성취도 : ?.?%
		// 출력
		
		// => 5초 정도 딜레이 걸어서 => .bat로 실행까지!
		
		System.out.printf("학원 오는데 걸린 시간 : %.1f시간\n", 1.5);
		System.out.printf("어제 저녁 메뉴 : %s\n", "어머니 집밥");
		System.out.printf("어제 뭐하셨나요 : %s\n", "가족들과 시간보냄");
		System.out.printf("취침 시간 : %d시 %d분\n", 1, 30);
		System.out.printf("첫 수업 소감 : %s\n", "잘 따라가고 싶어요");
		System.out.printf("수업 성취도 : %.1f%%\n", 70.5);
		
		Thread.sleep(5000);
		
		
		
	}
}

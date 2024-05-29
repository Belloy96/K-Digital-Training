
public class VMain2 {
	public static void main(String[] args) {
		// 이름, 오늘 날짜 (연도.월.일), 사는 곳(지역),
		// 시력, java경험의 유무(%b) 를 변수에 담아서 출력
		
		String myName = "김세훈";
		int year = 2024;
		int month = 5;
		int day = 2;
		String area = "서울";
		double sight = 0.1;
		boolean experienced = false;
		
		System.out.println("이름 : " + myName);
		System.out.printf("오늘 날짜 : %d.%02d.%02d\n", year, month, day);
		System.out.println("지역 : " + area);
		System.out.printf("시력 : %.1f\n", sight);
		System.out.printf("자바 경험의 유무 : %b\n", experienced);
		
		// System.out.printf("이름 : %s\n", name);
		// System.out.printf("지역 : %s\n", area);
		// System.out.println("자바 경험 유무 : " + experienced);
		// 문자로 출력되기 떄문에 두 값(%s/%b) 전부 가능
		
		// 섬유향수
		String name = "섬유향수";
		System.out.printf("이름 : %s\n", name);
		// 1000원
		int price = 1000;
		System.out.printf("가격 : %d원\n", price);
		// 80ml
		int volume = 80;
		System.out.printf("가격 : %dml\n", price);
		// 체리블라썸
		String incense = "체리블라썸";
		System.out.printf("향 : %s\n", incense);
		// 향균은 99.9%
		double antibacterial = 99.9;
		System.out.printf("향균력 : %.1f%%\n", antibacterial);
		// 무색
		String color = "무";
		System.out.printf("색 : %s색\n", color);
		// 다이소
		String company = "다이소";
		System.out.printf("구입 장소 : %s\n", company);
		// 재활용 해야함
		boolean recycle = true;
		System.out.printf("재활용 유무 : %b\n", recycle);
		
		
		
		
		
		
		
		
		
		
		
	}
}

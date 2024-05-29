
public class CMain1 {
	public static void main(String[] args) {
		// 신발
		// 나이키 홈페이지
		
		// 이름 : ???
		// 사이즈 : 260
		// 가격 : 110000
		// 브랜드 : 나이키
		// 정보 출력
		// ---------
		// 이름 : ???
		// 사이즈 : 260
		// 가격 : 110000
		// 브랜드 : 나이키
		// 정보 출력
		// ---------
		Shoes s1 = new Shoes();
		s1.name = "에어 베이퍼맥스 2023 플라이니트";
		s1.price = 249000; 
		s1.size = 265;
		s1.printInfo();
		
		Shoes s2 = new Shoes();
		s2.name = "에어 맥스 Dn";
		s2.price = 189000;
		s2.size = 270;
		s2.printInfo();
		
		// 생성자 오버로딩
		Shoes s3 = new Shoes("신발", 250, 3000);
		s3.printInfo();
		
		s2.test(s2.name);
		System.out.println("----------");
		s2.test("zzz");
		System.out.println("----------");
		
		// 커피
		// 커피 이름 / 가격
		// 출력
		Coffee c1 = new Coffee("스타벅스 에스프레소 더블 샷 & 크림 ", 1600);
		c1.printInfo();
		System.out.println("----------");
		
	}
}

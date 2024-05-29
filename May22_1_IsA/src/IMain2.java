// A is a B : 상속관계
// 쇼핑몰 - '상품'에 대한 정보를 게시하고 싶음
public class IMain2 {
	public static void main(String[] args) {
		// 신발 (이름, 가격, 사이즈)
		// 출력
		Shoes s = new Shoes("슬리퍼", 3000, 250);
		s.printInfo();
		System.out.println("-------------");
		
		// 컴퓨터 (이름, 가격, cpu, ram, hdd)
		// 출력
		Computer c = new Computer("컴퓨터", 500000, "i7-2345", 16, 500);
		c.printInfo();
		System.out.println("-------------");
		
		// 노트북 (이름, 가격, cpu, ram, hdd, 무게, 배터리 지속시간)
		// 출력
		Laptop l = new Laptop("노트북", 800000, "i5-1234", 16, 500, 2.3, 8.5);
		l.printInfo();
		System.out.println("-------------");
		
	}
}

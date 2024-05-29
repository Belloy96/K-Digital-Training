// Java : Perfect 객체지향언어 (구조가)
// C++, Python : Hybrid 객체지향언어 (구조가)

// 실생활을 묘사하자 => 보기가 쉬워질 것 => 유지보수에 용이해짐 !

// main()있는 클래스 : XXXMain
public class OMain2 {
	public static void main(String[] args) {
		// 버스를 Java로 표현해보자
		//	=> 표현하고 싶을 때는 항상! 클래스를! 새로! 만들자!
		// 버스번호 / 차종 / 버스회사 / 기사님이름 / 시작점 => 출력
		// int, double, String, ... : ?!, Java를 모르는 사람한테 설명하기 어렵다
		// 주석을 달 필요가 없다는게 장점 !
		//		=> 뭘 표현하고자 하는지 알 수 있기 때문에 !
		// b1 : 객체, instance 라고 부름
		
		Bus b1 = new Bus(); // 버스 한 대가 완성!
		b1.no = 461;
		b1.brand = "대우 대형";
		b1.company = "솔데스크운수";
		b1.driver = "김버스";
		b1.startPoint = "신논현역";
//		System.out.println(b1.no);
//		System.out.println(b1.brand);
//		System.out.println(b1.company);
//		System.out.println(b1.driver);
//		System.out.println(b1.startPoint);
		b1.printInfo();
		b1.go();
		System.out.println("-------------------");
		// 핸드폰
		//		모델명
		//		제조사
		//		가격
		//		정보를 출력
		//		전화가 왔을 때 - 벨소리 출력
		Cellphone c1 = new Cellphone();
		System.out.println(c1); // 기본형이 아닌 것들은 다 참조형 !!
		c1.printInfo(); // 각 자료형들의 기본값 
		c1.model = "Galaxy S20 Ultra";
		c1.manufacture = "삼성전자";
		c1.price = 190;
		c1.printInfo();
		c1.getCall();
		// c1과 똑같은 속성 값을 가진 c2 생성 - 불가능!!!(47번줄의 방법으로는)
		//	=> 무조건 new ~~ 로 생성해야 !!!!(*결론)
		Cellphone c2 = c1; // c1의 별명이 하나 더 추가된 상황 !
		System.out.println(c2); // 번지 값이 같다.
								// 핸드폰 하나를 2명이 공유하고 있는 상황!
		c2.price = 85;
		c2.printInfo(); // #그림판 사용#
		c1.printInfo(); // 위에서 c2 가격을 850000으로 변경 => c2 = c1이라 공유
		
		
	}
}

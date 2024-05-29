// 생성자 (Java)
//	1. 클래스에 생성자가 하나도 없으면
//		자바 컴파일러가 생성자를 만들어 줌 !
//	2. 하위클래스 객체를 만들면(Pen)
//		상위클래스 기본생성자(Product2)를 자동 호출

public class Pen extends Product2{
	String color;
	
	public Pen() {
		// TODO Auto-generated constructor stub
		// 2. 가 발동
	}

	public Pen(String color) {
		// super(); // 2. 을 명시해 놓은 것 (super();는 없어도 무방. 알아서 불러올 것)
		this.color = color;
	}

	public Pen(String name, int price, String color) {
		super(name, price); // 2. 발동(X) <- 여기서 super는 생략불가
							// Product2(이름, 가격)
							// 파라미터를 가진 super는 
							// 기본생성자가 생성되지 않기 때문에 생략을 사용할 수 없음
		this.color = color;
	}
	
}

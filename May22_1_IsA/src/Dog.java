// A is a B : 상속관계
// 개는 동물 '이다'
public class Dog extends Animal{ // Animal의 기능을 받아옴
	// Animal 안에 Dog가 '상속'되어있다
	// 상속 : Inheritance(영어로는 저 뜻이지만, 왜 extends를 쓸까?)
	// 확장 : extends (상속 + 확장의 기능)
	
	String inhabit;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	// 오버로딩 시, 옵션을 변경함. 
	// super의 객체 확인 -> super쪽 커서 올리고 ctrl누른채로 살짝 내린 후
	// Open declaration 클릭
	public Dog(String sort, int age, String inhabit) {
		super(sort, age); 
		this.inhabit = inhabit;
	}

	// @XXX : Annotation => 어떤 기능을 자동으로 연결해준다
	@Override	// 상속받아온 method의 기능을 바꾸는 것
	public void printInfo() {
		// override를 사용하려면...
		//	상속받은 Class에서의 method명과 같아야!!!
		// TODO Auto-generated method stub
		super.printInfo(); // (dog클래스 기준) 상위클래스.printInfo();
		System.out.println(inhabit);
	}
	
	// VS
	// Overloading
	//		메소드를 만들 때 같은 기능이라면 메소드명을 같게 !
	//		파라미터의 자료형이 다르거나,
	//		파라미터의 개수가 달라야 함
	
	
}

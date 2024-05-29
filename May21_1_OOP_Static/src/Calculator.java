// 변수 왜 만드나요? : 데이터 저장하려고 => Memory상의 공간에!
//		변수 : 데이터를 저장하는 공간(그릇)

// 객체 왜 만드나요 ? : 실생활스러운 변수(속성)를 만들어서 알아보기 편하게!
//			=> static 없는 method 가지고 오려고


public class Calculator {
	// 멤버변수가 없음(강사님은 필요 없다고 판단함) => 저장할게 없음
	//		=> 계산기 객체를 만들 필요가 없음
	//		=> static 메소드 기반(으로 만드는게 어떨까)
	
	
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
	
	public void sum(int a, int b, int c) {
		System.out.println(a + b + c);
	}
	
}

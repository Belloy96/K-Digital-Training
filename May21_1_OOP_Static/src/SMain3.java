// static => 적재적소에 사용할 수 있어야!
//			=> 이걸 다루는거 자체가 고급!

// 콘솔창에 어떻게 출력될지 생각해보기!
class Number {
	static int num = 0; // static 멤버변수 : 객체들의 공통속성
	int num2 = 0;
}

public class SMain3 {
	public static void main(String[] args) {
		Number number1 = new Number();
		Number number2 = new Number();
		number1.num++;
		number1.num2++;
		System.out.println(number1.num);		// 1
		System.out.println(number1.num2);		// 1
		System.out.println(number2.num);		// 1 => static (O)
		System.out.println(number2.num2);		// 0 => static (X)
	}
}

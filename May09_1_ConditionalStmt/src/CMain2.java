import java.util.Scanner;

public class CMain2 {
	// 숫자 하나를 입력
	// 입력받은 정수 값이 5보다 크면 새로운 변수 y에 정수 10을 담아서 출력
	// 입력받은 정수 값이 3보다 크면 새로운 변수 y에 정수 20을 담아서 출력
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("숫자 : ");
		int x = k.nextInt();
		
		// if문 안에 변수를 만들면
		// if문이 돌아가면서 계속해서 int y 를 생성하고 있음 !
		//		=> 효율적이지 않다 !
		
		if (x > 5) {
			int y = 10;
			System.out.println(y);
		} else if (x > 3) {
			int y = 20;
			System.out.println(y);
		}
		
		// if문 바깥에다가 변수를 생성하고
		// if문 안에서 값을 '변경' 할 수 있께 하는 것이 효율적 !
		
		int y = 0;
		if (x > 5) {
			y = 10;
			System.out.println(y);
		} else if (x > 3) {
			y = 20;
			System.out.println(y);
		}
		
	}
	
	
}

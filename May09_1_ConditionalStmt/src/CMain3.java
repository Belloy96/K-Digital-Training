import java.util.Scanner;

public class CMain3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("x : ");
		int x = k.nextInt();
//		System.out.println(x);
		
		// 조건문 : if, switch
		// switch - case ('sw' + 자동완성)
		
		// switch문 : 비교 조건이 특정한 값이나 문자열인 경우
		//	break; 를 이용해서 각 조건이 만족하면 switch문이 깨지도록
		
//		switch (변수 or 식) {
//		case 값 A:
//			변수 or 식의 값이 A일때, 이 부분을 실행
//			break;
//		case 값 B:
//			변수 or 식의 값이 B일때, 이 부분을 실행
//			break;	
//		default:
//			A값도 아니고, B값도 아닐 때 이 부분이 실행
//			break;
//		}
		
		// x 가 1일때 "ㅋㅋ"를 출력 / 2일때 "ㅎㅎ" / 3일때 "ㅠㅠ"
		//	위의 세 조건이 아니면 "배고파.." 를 출력
		
		switch (x) {
		case 1:
			System.out.println("ㅋㅋ");
			break;
		case 2:
			System.out.println("ㅎㅎ");
			break;
		case 3:
			System.out.println("ㅠㅠ");
			break;	
		default:
			System.out.println("배고파..");
			break;
		}
		
		
	}
}

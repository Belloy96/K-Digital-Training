import java.util.Scanner;

// 어떤 숫자를 콘솔창에 입력
//	그 숫자의 약수를 구해서 출력해주는 프로그램
//	main 에서 진행 => 음수 값은 무시
//	ex) 12의 약수 : 1, 2, 3, 4, 6, 12
//	계속 입력하면 약수를 계속 출력해서 보여주고
//		=> 콘솔창에 0을 입력하면 프로그램이 종료되게!
//	배열 사용 X
public class PMain1 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.print("숫자 입력(0 입력하면 종료) : ");
			num = k.nextInt();
			if (num == 0) {
				System.out.println("종료합니다");
				break;
			}
			System.out.printf("[%d]의 약수는 : ", num);
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					System.out.printf("%d ", i);
				}
			}
			System.out.println();
		}
	}
}

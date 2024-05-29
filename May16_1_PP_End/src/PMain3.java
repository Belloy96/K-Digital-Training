import java.util.Scanner;

// 현재 시간을 밀리초로 나타내주는 함수 : System.currentTimeMillis();
// 절대값 구하기 : Math.abs();

// nextLine()은 Enter를 치기 전까지 쓴 문자열 모두 반환함
// next()는 공백(Space) 전까지 입력받은 문자열 반환함
// 	next()는 개행문자를 무시하고 입력받고,
//	nextLine()는 한 줄 단위로 입력을 받기 때문에 개행문자(Enter)도 포함됨

public class PMain3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);

		System.out.print("첫 번째 도전자님 이름을 임력하세요 > ");
		String user1 = k.next(); // Enter의 기능이 없음 k.nextLine 두 번 쓴 이유

		System.out.println(user1 + "님 시작하려면 <Enter>를 누르세요.");
		k.nextLine(); // Enter처리 한 번 진행
		k.nextLine();

		long a = System.currentTimeMillis();

		System.out.println("10초가 된 것 같으면 <Enter>를 누르세요.");
		k.nextLine();
		long b = System.currentTimeMillis();

		double result1 = (double) ((b - a) * 0.001); // 밀리초를 초로 계산
		System.out.printf("종료시간 : %.3f초\n", result1);

		System.out.print("두 번째 도전자님 이름을 임력하세요 > ");
		String user2 = k.next();

		System.out.println(user2 + "님 시작하려면 <Enter>를 누르세요.");
		k.nextLine();
		k.nextLine();

		long c = System.currentTimeMillis();

		System.out.println("10초가 된 것 같으면 <Enter>를 누르세요.");
		k.nextLine();
		long d = System.currentTimeMillis();

		double result2 = (double) ((d - c) * 0.001);
		System.out.printf("종료시간 : %.3f초\n", result2);

		if (Math.abs(result1 - 10) < Math.abs(result2 - 10)) {
			System.out.printf("%s님이 %.3f초 차이로 승리하셨습니다 !", user1, Math.abs(result1 - result2));
		} else if (Math.abs(result1 - 10) > Math.abs(result2 - 10)) {
			System.out.printf("%s님이 %.3f초 차이로 승리하셨습니다 !", user2, Math.abs(result1 - result2));
		} else {
			System.out.println("무승부");
		}

	}
}

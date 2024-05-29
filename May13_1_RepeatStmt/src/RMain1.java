import java.util.Random;
import java.util.Scanner;

public class RMain1 {

	// Up & Down 게임 (main에)
	// 1 ~ 100 사이의 숫자 맞추는 게임
	// 컴퓨터 vs 나 => 같은 숫자 내면 종료
	// 숫자(컴이 뽑은)가 나보다 낮으면 Down!
	// 숫자(컴이 뽑은)가 나보다 높으면 Up!
	// 몇 턴만에 정답을 찾았는지 출력

	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(100) + 1;
		Scanner k = new Scanner(System.in);

		for (int turn = 1; true; turn++) { // 몇 번 반복할지 모르기 때문에
											// 조건을 지정할 수 없음
											// true로 자리를 메워줌
			System.out.print("입력 : ");
			int myNum = k.nextInt();

			if (num < myNum) {
				System.out.println("Down !");
			} else if (num > myNum) {
				System.out.println("Up !");
			} else {
				System.out.println("정답 !");
				System.out.printf("%d번 만에 정답을 맞췄습니다.\n", turn);
				break; // 반복문을 깨버림
			}
			System.out.println("****************");
		}

	}
}

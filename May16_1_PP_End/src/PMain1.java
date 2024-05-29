import java.util.Random;
import java.util.Scanner;

public class PMain1 {
	// 베스킨라빈스 31게임 !
	// 유저 먼저 시작 ! (1 ~ 3 사이 정수)
	// main함수에
	public static void main(String[] args) {
		int userAnswer = 0;
		int comAnswer = 0;
		int number = 0;
		int win = 0;
		int lose = 0;

		Scanner k = new Scanner(System.in);
		Random r = new Random();

		System.out.println("*** 베스킨라빈스 31 ***");
		System.out.println("*** Game Start! ***");
		System.out.println("=====================");

		while (true) {
			System.out.print("숫자(1~3) : ");
			userAnswer = k.nextInt();
			number += userAnswer;
			if (number == 1) {
				System.out.printf("☆ 유저 숫자 ☆\n=> %d\n", userAnswer);

			} else if (number == 2) {
				System.out.printf("☆ 유저 숫자 ☆\n=> %d, %d\n", uA1, userAnswer);

			} else if (number == 3) {
				System.out.printf("☆ 유저 숫자 ☆\n=> %d, %d, %d\n", uA2, uA1, userAnswer);

			} else {
				System.out.println("다시 입력하세요");
				break;
			}

			comAnswer = r.nextInt();
			if (number < comAnswer && comAnswer <= number + 3) {
				break;
			} else {
				comAnswer = r.nextInt();
			}
			System.out.printf("★ 컴퓨터 숫자 ★\n=> %d\n", comAnswer);
			number = comAnswer;

			System.out.println();
		}

	}
}

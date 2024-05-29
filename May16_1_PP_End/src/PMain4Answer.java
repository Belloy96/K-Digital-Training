import java.util.Random;
import java.util.Scanner;

public class PMain4Answer {
	// 게임 시작하면서 룰 설명
	public static void printStart(String[] h) {
		System.out.println("<< 가위바위보 게임 시작 ! >>");
		System.out.println("=================");
		for (int i = 1; i < h.length; i++) {
			System.out.printf("∥ %d. %s\t\t∥\n", i, h[i]);
		}
		System.out.println("=================");
	}

	// 컴퓨터가 뭐 냈는지
	public static int getComHand() {
		Random r = new Random();
		int comHand = r.nextInt(3) + 1;
		return comHand;
	}

	// 유저가 뭐 냈는지
	public static int getUserHand() {
		Scanner k = new Scanner(System.in);
		System.out.print("뭐낼래 ? : ");
		int userHand = k.nextInt();
		if (userHand < 1 || userHand > 3) {
			System.out.println("喝!!!!!");
		}
		return (userHand >= 1 && userHand <= 3) ? userHand : getUserHand();
	}

	// 각자 뭐 냈는지 출력해주는 함수
	public static void printHand(int user, int com, String[] hand) {
		System.out.println("=================");
		System.out.printf("∥ 유저\t: %s\t∥\n", hand[user]);
		System.out.printf("∥ 컴퓨터\t: %s\t∥\n", hand[com]);
		System.out.println("=================");
	}

	// 게임 한 판에 대한 판정
	public static int judge(int user, int com) {
		int game = user - com;
		if (game == 0) {
			System.out.println("무승부");
			return 0;
		} else if (game == -1 || game == 2) {
			System.out.println("패배");
			return -123123; // 아무 값이나 리턴함. why? 상관없기 때문. 즉, 0&1만 아니면 ok
		} else {
			System.out.println("승리");
			return 1;
		}
	}

	// 유저가 한 번 질 때까지 진행한 후에 몇 승 했는지 그 결과를 받아옴
	public static int getResult(String[] hand) {
		int com = 0;
		int user = 0;
		int win = 0;
		int result = 0;

		while (true) {
			com = getComHand();
			user = getUserHand();
			printHand(user, com, hand);
			result = judge(user, com);
			if (result == -123123) {
				break;
			}
			win += result; // 이겼을 때는 1값, 비겼을 때는 0값 받아서 계산
							// (무승부를 0, 승리를 1로 한 이유)
		}
		return win;
	}

	// 연승에 대한 결과 출력
	public static void printResult(int win) {
		System.out.println("=================");
		System.out.printf("∥ %d연승으로 종료!\t∥\n", win);
		System.out.println("=================");
	}

	// 다 모은 함수
	public static void activate() {
		String[] hand = { "ㅋ", "가위", "바위", "보" }; // ㅋ는 의미는 없고 자리만 채움
		printStart(hand); // why? 0부터 시작하기 때문에
							// 1, 2, 3이 가위, 바위, 보와 일치
		int win = getResult(hand);
		printResult(win);
	}

	public static void main(String[] args) {
		activate();
	}
}

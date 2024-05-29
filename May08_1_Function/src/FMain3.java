import java.util.Random;
import java.util.Scanner;

public class FMain3 {
	// 홀짝 게임 (함수.ver)
	
	// 랜덤한 동전 갯수 가져오기 1~10개
	public static int shakeCoin() {
//		Random r = new Random();
//		int coin = r.nextInt(10) + 1;
//		return coin;
		return new Random().nextInt(10) + 1;
	}
	
	// 질문 & 답 입력
	public static String askUserAns() {
//		Scanner k = new Scanner(System.in);
		System.out.print("홀 ? 짝 ? : ");
//		String userAns = k.next();
//		return userAns;
		return new Scanner(System.in).next();
	}
	
	// 동전 갯수가 홀수면 '홀', 짝수면 '짝'
	public static String getAnswer(int coin) {
		String answer = (coin % 2 == 0) ? "짝" : "홀";
		return answer;
	}
	
	// 비교해서 결과 내기
	public static String getResult(String ua, String a) {
		String result = (ua.equals(a)) ? "정답" : "땡";
		return result;
	}
	
	// 출력
	public static void printResult(int coin, String ua, String a, String r) {
		System.out.printf("동전은 %d개 !\n", coin);
		System.out.printf("내가 입력한 답 : %s !\n", ua);
		System.out.printf("결과 : %s이라서 %s !\n", a, r);
	}
	
	// 함수들 모으기
	public static void start() {
		int coin = shakeCoin();
		String userAns = askUserAns();
		String answer = getAnswer(coin);
		String result = getResult(userAns, answer);
		printResult(coin, userAns, answer, result);
	}
	
	public static void main(String[] args) {
		start();
	}
}

import java.util.Random;
import java.util.Scanner;

public class FMain4 {
	// 동전 맞추기 게임
	// 10개
	
	// 시작
	public static void introduce() {
		System.out.println("==========");
		System.out.println("게임을 시작하지");
		System.out.println("==========");
	}
	
	// 동전 랜덤하게 10개 뽑기
	public static int shakecoin() {
//		Random r = new Random();
//		int coin = r.nextInt(10) + 1;
//		return coin;
		return new Random().nextInt(10) + 1;
	}
	
	// 질문 & 답 입력
	public static int askUserAns () {
//		Scanner k = new Scanner(System.in);
		System.out.print("동전은 몇개일까요?(1에서 10사이) : ");
//		int userAns = k.nextInt();
//		return userAns;
		return new Scanner(System.in).nextInt();
	}
	
	// 답 맞춰보기
	public static String getResult (int coin, int userAns) {
//		String result = (coin == userAns) ? "정답" : "땡";
//		return result;
		return (coin == userAns) ? "정답" : "땡";
	}
	// 출력
	public static void printResult(int coin, int userAns, String result) {
		System.out.println("------------------------");
		System.out.printf("컴퓨터가 뽑은 동전의 갯수는 %d 개 !\n", coin);
		System.out.printf("당신이 선택한 동전의 갯수는 %d 개 !\n", userAns);
		System.out.printf("따라서 결과는 [%s] !!\n", result);
		System.out.println("------------------------");
	}
	// 함수 모으기
	public static void start() {
		introduce();
		int coin = shakecoin();
		int userAns = askUserAns();
		String result = getResult(coin, userAns);
		printResult(coin, userAns, result);
	}	
	// main 출력

	public static void main(String[] args) {
		start();
	}	
	
}

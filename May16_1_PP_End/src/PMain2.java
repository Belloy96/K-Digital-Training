import java.util.Random;
import java.util.Scanner;

// UP&DOWN 게임(함수 사용 O)
// 컴퓨터 1 ~ 100 사이의 숫자를 뽑음 (ex : 34)
// 유저가 입력
//		1트 : 50 => down !
//		2트 : 20 => up !
//		...
//		10트 : 34 => 정답 !

public class PMain2 {

	public static int getComNum(){
		Random r = new Random();
		int comNum = r.nextInt(100) + 1;
		return comNum;
	}
	
	public static int getUserAnswer(){
		Scanner k = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int userAnswer = k.nextInt();
		System.out.println("==================");
		if (userAnswer > 100 || userAnswer < 0) {
			System.out.println("다시 입력하세요.");
			getUserAnswer();
		}
		return userAnswer;
	}
	
	public static void judgeAnswer(int userAnswer, int comNum) {
		if (userAnswer > comNum) {
			System.out.println("down !");
			System.out.println("==================");
		} else if (userAnswer < comNum) {
			System.out.println("up !");
			System.out.println("==================");
		} else if (userAnswer == comNum) {
			System.out.println("정답 !");
			System.out.println("==================");
		}
		
	}
	
	public static void start() {
		int comNum = getComNum();
		int userAnswer = getUserAnswer();
		int turn = 0;
		while (true) {
			turn++;
			userAnswer = getUserAnswer();
			if (judgeAnswer(userAnswer, comNum)) {
				break;
			} else {
				getUserAnswer();
			}
		}
		
	}
	
	public static void main(String[] args) {
		start();
	}
	
	
}

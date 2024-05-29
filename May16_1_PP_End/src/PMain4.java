import java.util.Random;
import java.util.Scanner;

// 가위바위보 게임 (함수 사용 O)
//	1. 가위 => 콘솔창에 1을 입력하면 가위
//	2. 바위 => 콘솔창에 2을 입력하면 바위
//	3. 보 => 콘솔창에 3을 입력하면 보
// 컴퓨터와 가위바위보를 해서 1번 질동안 몇 승 하는지 출력까지!

public class PMain4 {
	// 번호입력을 뽑아내는 함수
	public static int userAnswer() {
		Scanner k = new Scanner(System.in);
		System.out.print("숫자 입력(1~3)> ");
		int answer = k.nextInt();
		if (answer > 3 || answer < 1) {
			System.out.println("다시 입력하세요");
			userAnswer();
		}
		return answer;
	}
	
	// 입력된 번호를 가위or바위or보로 바꿔주는 함수
	public static String changeNum(int num) {
		Scanner k = new Scanner(System.in);
		String result = null;
		if (num == 1) {
			result = "가위";
		} else if (num == 2) {
			result = "바위";
		} else if (num == 3) {
			result = "보";
		}
		return result;
	}
	
	// 컴퓨터가 랜덤한 숫자를 뽑아내는 함수
	public static int comNum() {
		Random r = new Random();
		int num = r.nextInt(3) + 1;
		return num;
	}
	
	// 승 무 패 결정함수
	public static String judgeResult(int userAnswer, int comNum){
		String result2 = null;
		if (userAnswer == comNum) {
			result2 = "무승부";
		} else if (userAnswer == 1) {
			result2 =(userAnswer + comNum) % 2 == 0 ? "승리" : "패배";
		} else if (userAnswer == 2) {
			result2 =(userAnswer - comNum) > 0 ? "승리" : "패배";
		} else if (userAnswer == 3) {
			result2 =(userAnswer + comNum) % 2 == 1 ? "승리" : "패배";
		}
		String answer = changeNum(userAnswer);
		String num = changeNum(comNum);
		System.out.printf("당신의 선택은 [%s]\n컴퓨터의 선택은 [%s]\n", answer, num);
		System.out.println("당신의 " + result2);
		return result2;
	}
	
	public static void repeatGame(String result) {
		int turn = 0;
		while (true) {
			if (result == "패배") {
				System.out.printf("당신의 연승은 %d회 입니다", turn);
				break;
			} else {
				turn++;
			}
			
		}
		
	}
	
	public static void printResult() {
		int answer = userAnswer();
		int num = comNum();
		String result = judgeResult(answer, num);
	}
	
	public static void main(String[] args) {
		printResult();
		
	}
}

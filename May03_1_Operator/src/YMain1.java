import java.util.Scanner;

public class YMain1 {
	public static void main(String[] args) {
		
		// 오늘 기분은 어떤가요 ?
		// 오늘 컨디션 점수는 ?
		// 대중교통 몇 번 갈아타고 오셨는지 ?
		// 밤에 푹 주무셨는지 (잘 잤으면 true / 아니면 false)
		// 몇 시간 주무셨나요 ? (ex : 6.0시간)
		
		// Scanner로 입력을 받아서 출력까지 !
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("오늘 기분 :");
		String feelings = keyboard.next();
		// String feelings = k.next();
		System.out.print("오늘 컨디션 점수 :");
		int conditionScore = keyboard.nextInt();
		System.out.print("대중교통 갈아탄 횟수 :");
		int transfer = keyboard.nextInt();
		System.out.print("밤에 푹 잤는지 :");
		boolean wellSleep = keyboard.nextBoolean();
		System.out.print("몇 시간 잤는지 :");
		double sleepingHour = keyboard.nextDouble();
		
		System.out.printf("오늘 기분 : %s\n", feelings); 
		// System.out.prinfln("오늘 기분 :" + feelings);
		System.out.printf("오늘 컨디션 점수 : %d점\n", conditionScore);
		System.out.printf("대중교통 갈아탄 횟수 : %d회\n", transfer);
		System.out.printf("밤에 푹 잤는지 : %b\n", wellSleep);
		System.out.printf("몇 시간 잤는지 : %.1f시간\n", sleepingHour);
		
		
		
	}

}

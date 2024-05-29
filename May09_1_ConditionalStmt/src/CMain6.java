import java.util.Scanner;

public class CMain6 {
	// 1년 = 12달
	// 각 달마다 며칠인지 다릅니다
	// 몇 월인지 입력 받아서
	// 31일 / 30일 / 28일
	// 14월 -> 없는 달입니다 출력
	
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("월 입력 : ");
		int month = k.nextInt();
		
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.printf("%d월은 31일까지 있습니다\n", month);
			break;
		case 4: case 6: case 9: case 11:
			System.out.printf("%d월은 30일까지 있습니다\n", month);
			break;
		case 2:
			System.out.printf("%d월은 28일까지 있습니다\n", month);
			break;
		default:
			System.err.printf("%d월은 없는 달입니다.\n", month);
			break;
			// out 대신 err => 빨간글씨로 나오며 강조하기 위함
		}
		
		
		
	}
}

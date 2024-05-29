import java.util.Scanner;

public class PMain2 {

	// ATM기능을 하는 프로그램
	//	1을 고르면 입금 / 2를 고르면 출금 / 3을 고르면 잔액 확인
	//	4를 고르면 프로그램 종료
	//	입금, 출금 돈 값을 입력 받을 것!
	//	main함수에
	
	public static void main(String[] args) {
		int choice = 0;
		int money = 0;
		Scanner k = new Scanner(System.in);
		
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔액 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.print("선택> ");
			choice = k.nextInt();
			
			if (choice == 1) {
				System.out.print("예금액> ");
				int plusMoney = k.nextInt();
				System.out.printf("\t%,d원을 예금합니다.\n", plusMoney);
				money += plusMoney;
				
			} else if (choice == 2) {
				System.out.print("출금액> ");
				int minusMoney = k.nextInt();
				System.out.printf("\t%,d원을 출금합니다.\n", minusMoney);
				money -= minusMoney;
				if (money < 0) { // 마이너스 통장처리할지는 자유지만 강의에서는 불가로 진행
					System.out.println("\t...");
					System.out.println("\t잔고가 모자랍니다.");
					System.out.println("\t출금에 실패했습니다.");
					money += minusMoney;
				}
				
			} else if (choice == 3) {
				System.out.printf("\t%,d원이 남아있습니다.\n", money);
				
			} else if (choice == 4) {
				System.out.println("\t프로그램 종료 !");
				System.out.println("--------------------------------");
				break;
			}
			
		}
		
	}
}	
	
//	public static void main(String[] args) {
//		Scanner k = new Scanner(System.in);
//		int num = 0;
//		int deposit = 0;
//		int withdraw = 0;
//		while (true) {
//			System.out.print("1 = 입금, 2 = 출금, 3 = 잔액 확인, 4 = 프로그램 종료\n"
//					+ "번호를 입력해주세요 : ");
//			num = k.nextInt();
//			int balance = deposit - withdraw;
//			if (num == 4) {
//				System.out.println("프로그램을 종료합니다");
//				break;
//			}else if (num == 1) {
//				System.out.print("입금할 금액을 입력해주세요 : ");
//				deposit = k.nextInt();
//				balance = deposit - withdraw;
//				System.out.printf("입금하신 금액은 %,d원이며\n"
//						+ "남은 잔액은 %,d원입니다.\n", deposit, balance);
//				System.out.println("------------------");
//				
//			}else if (num == 2) {
//				System.out.print("출금할 금액을 입력해주세요 : ");
//				withdraw = k.nextInt();
//				balance = deposit - withdraw;
//				System.out.printf("출금하신 금액은 %,d원이며\n"
//						+ "남은 잔액은 %,d원입니다.\n", withdraw, balance);
//				System.out.println("------------------");
//				
//			}else if (num == 3) {
//				System.out.printf("남은 잔액 : %,d원\n", balance);
//				System.out.println("------------------");
//				
//			}
//			
//		}
		
		
	


import java.util.Random;
import java.util.Scanner;

// 주사위 게임 (main함수만 사용 O)
//	유저와 컴퓨터가 각각 주사위를 3개씩 굴려서 그 합이 높은 숫자가
//		나온 쪽이 이기는 게임
//	1번 메뉴
//		유저와 컴퓨터는 각각 주사위 3개씩 굴릴 것
//		유저는 굴린 주사위의 값을 확인한 후 (주사위의 합까지)
//		돈을 배팅할 수 있게 해서
//		이기면 그 돈 만큼 따고, 지면 잃게 됨
//		소지금보다는 많이 배팅할 수 없고, 기본 소지금은 10000원으로 시작
//		한 판 끝내면 재도전 의사를 물을 것
//		소지금 다 잃으면 메뉴로 돌아가기
//	2번 메뉴
//		전적확인 (승 / 무 / 패 / 소지금)
//	3번 메뉴
//		대출 기능
//	4번 메뉴
//		상환 기능
//	5번 메뉴
//		프로그램 종료

public class PMain8 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Random r = new Random();

		int myMoney = 10000;
		int choice = 0;
		int retry = 0;
		int userAns = 0;
		int loan = 0;
		int repayment = 0;

		while (true) {
			System.out.println("=========================================");
			System.out.println("1. 주사위게임 | 2. 전적확인 | 3. 대출 | 4. 상환 | 5. 종료");
			System.out.println("=========================================");
			System.out.print("선택> ");
			choice = k.nextInt();

			a: if (choice == 1) {
				int ca = r.nextInt(6) + 1;
				int cb = r.nextInt(6) + 1;
				int cc = r.nextInt(6) + 1;
				int comNum = ca + cb + cc;

				int ua = r.nextInt(6) + 1;
				int ub = r.nextInt(6) + 1;
				int uc = r.nextInt(6) + 1;
				int userNum = ua + ub + uc;

				System.out.printf("당신의 값은 %d, %d, %d로\n" + "총합은 %d입니다\n", ua, ub, uc, userNum);
				System.out.println("=========================================");
				if (myMoney <= 0) {
					System.out.println("소지금이 0원입니다");
					System.out.println("대출을 받거나 프로그램을 종료해주세요");
					break a;
				}

				System.out.printf("소지금 : %d원\n", myMoney);
				System.out.print("배팅 금액 : ");
				int betMoney = k.nextInt();

				if (betMoney > myMoney) {
					System.out.println("소지금보다 크게 배팅할 수 없습니다");
					System.out.println("다시 배팅해주세요");
					System.out.println("=========================================");
					System.out.printf("소지금 : %d원\n", myMoney);
					System.out.print("배팅 금액 : ");
					betMoney = k.nextInt();
					System.out.println("=========================================");
				}

				if (userNum > comNum) {
					System.out.printf("당신의 합 : %d | 컴퓨터의 합 : %d\n", userNum, comNum);
					System.out.println("=========================================");
					System.out.printf("승리! %d원을 획득합니다\n", betMoney);
					myMoney += betMoney;
					System.out.printf("소지금 : %d원\n", myMoney);
					if (myMoney > 0) {
						System.out.print("재도전하시려면 1을 입력해주세요 : ");
						retry = k.nextInt();
						if (retry != 1) {
							break a;
						}
					}

				} else if (userNum < comNum) {
					System.out.printf("당신의 합 : %d | 컴퓨터의 합 : %d\n", userNum, comNum);
					System.out.println("=========================================");
					System.out.printf("패배! %d원을 상실합니다\n", betMoney);
					myMoney -= betMoney;
					System.out.printf("소지금 : %d원\n", myMoney);

				} else {
					System.out.println("무승부! 다시 게임을 시작합니다");

				}

			} else if (choice == 2) {

			} else if (choice == 3) {
				System.out.print("대출을 받으시려면 1을 입력해주세요 : ");
				userAns = k.nextInt();
				if (userAns == 1) {
					System.out.print("대출받을 금액 : ");
					loan = k.nextInt();
					myMoney += loan;
					System.out.println("=========================================");
					System.out.printf("소지금 : %d원\n", myMoney);
				} else {
					break;
				}

			} else if (choice == 4) {
				System.out.print("상환할 금액 : ");
				repayment = k.nextInt();
				myMoney -= repayment;
				System.out.println("=========================================");
				System.out.printf("남은 상환액은 %d원입니다\n", loan - repayment);
				System.out.printf("소지금 : %d원\n", myMoney);

			} else if (choice == 5) {
				System.out.println("프로그램 종료");
				System.out.println("=========================================");
				break;

			}

		}

	}
}

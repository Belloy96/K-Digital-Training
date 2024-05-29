import java.util.Random;
import java.util.Scanner;

public class PMain8Answer {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Random r = new Random();
		int money = 10000; // 기본 소지금
		int select = 0; // 메뉴 고르기
		int win = 0; // 이긴 횟수
		int lose = 0; // 진 횟수
		int draw = 0; // 비긴 횟수
		int userDice1, userDice2, userDice3 = 0; // 유저 주사위 3
		int comDice1, comDice2, comDice3 = 0; // 컴퓨터 주사위 3
		String bettingChoice = null; // 배팅의사
		String reTryChoice = null; // 재도전의사
		int bettingMoney = 0; // 배팅금액
		int loan = 0; // 대출금
		int accumulateLoan = 0; // 대출쌓인금액
		int payback = 0; // 상환금
		int userSum = 0; // 유저주사위 합
		int comSum = 0; // 컴퓨터주사위 합

		// 메뉴 보여주기
		a: while (true) {
			System.out.println("====== 주사위 게임 ======");
			System.out.println("1. Game Start");
			System.out.println("2. Game Score");
			System.out.println("3. Beaver Loan");
			System.out.println("4. Pay Back");
			System.out.println("5. End Game");
			System.out.println("======================");

			// 메뉴 선택하기
			System.out.print("선택> ");
			select = k.nextInt();
			System.out.println("======================");

			// if문 or switch문 사용

			switch (select) {
			case 1:
				if (money <= 0) { // 게임을 하려 했는데 돈이 없는 경우...
					System.out.println("\t 돈 없는 너가 뭘 할 수 있는데 ?");
					break;
				}

				while (true) {
					System.out.println("<< Game Start >>");
					userDice1 = r.nextInt(6) + 1;
					userDice2 = r.nextInt(6) + 1;
					userDice3 = r.nextInt(6) + 1;
					comDice1 = r.nextInt(6) + 1;
					comDice2 = r.nextInt(6) + 1;
					comDice3 = r.nextInt(6) + 1;

					System.out.println("1번째 주사위 값 : " + userDice1);
					System.out.println("2번째 주사위 값 : " + userDice2);
					System.out.println("3번째 주사위 값 : " + userDice3);
					System.out.println("======================");

					userSum = userDice1 + userDice2 + userDice3;
					System.out.println("내 주사위 총 합 : " + userSum);

					System.out.print("배팅 하시겠습니까 ? [Y / N] : ");
					bettingChoice = k.next();
					System.out.println("======================");

					if (bettingChoice.equals("y") || bettingChoice.equals("Y")) {
						System.out.println("얼마를 배팅하시겠습니까 ?");
						System.out.printf("현재 소지금 : %,d원\n", money);
						System.out.print("입력 : ");

						while (true) {
							bettingMoney = k.nextInt();
							System.out.println("======================");
							if (bettingMoney < 0) { // 배팅금액이 -일 경우
								System.out.println("돈을 어떻게 0으로 걸 수가 있냐고");
								System.out.println("다시 입력하세요.");
								System.out.println("얼마를 배팅하시겠습니까 ?");
								System.out.printf("현재 소지금 : %,d원\n", money);
								System.out.print("입력 : ");
								continue;
							} else if (money < bettingMoney) { // 소지금액 < 배팅금액
								System.out.println("금액이 부족합니다.");
								System.out.println("다시 입력하세요.");
								System.out.println("얼마를 배팅하시겠습니까 ?");
								System.out.printf("현재 소지금 : %,d원\n", money);
								System.out.print("입력 : ");
								continue;
							}
							break; // 정상적으로 입력한 경우 해당 반복문 깨버림
						}

						System.out.println("컴퓨터 1번째 주사위 값 : " + comDice1);
						System.out.println("컴퓨터 2번째 주사위 값 : " + comDice2);
						System.out.println("컴퓨터 3번째 주사위 값 : " + comDice3);

						comSum = comDice1 + comDice2 + comDice3;
						System.out.println("컴퓨터 주사위 총 합 : " + comSum);
						System.out.println("======================");

						System.out.println("<< 결과 >>");
						if (userSum > comSum) {
							System.out.println("\t승리 !");
							System.out.printf("\t%,d원이 소지금에 추가되었습니다.\n", bettingMoney);
							money += bettingMoney;
							win++;
						} else if (userSum < comSum) {
							System.out.println("\t패배 !");
							System.out.printf("\t%,d원이 소지금에 차감되었습니다.\n", bettingMoney);
							money -= bettingMoney;
							lose++;

							if (money <= 0) { // 지고나서 소지금 다 떨어진 경우
								System.out.println("======================");
								System.out.println("\t거지는 안 받아요 ~ ㅎ");
								System.out.println("\tNAGA!");
								break;
							}

						} else {
							System.out.println("대충 비겼다는 내용");
							draw++;
						}
						System.out.println("======================");

						System.out.print("한 번 더 하시겠습니까 ? [Y / N] : ");
						reTryChoice = k.next();

						if (reTryChoice.equals("y") || reTryChoice.equals("Y")) {
							continue;
						} else { // y나 Y가 아닌거 입력하면 재시도 안하는 걸로 간주
							break;
						}

					} else if (bettingChoice.equals("n") || bettingChoice.equals("N")) {
						break;

					} else if (!bettingChoice.equals("y") || !bettingChoice.equals("Y") || !bettingChoice.equals("n")
							|| !bettingChoice.equals("N")) {
						System.out.println("잘못 입력하셨네요 ?");
						System.out.println("처음부터 다시 하세요 ?");
						break;
					}

				}
				break;
			case 2:
				System.out.println("<< 당신의 전적 >>");
				System.out.printf("Win : %d회\n", win);
				System.out.printf("Draw : %d회\n", draw);
				System.out.printf("Lose : %d회\n", lose);
				System.out.printf("내 소지금 : %,d원\n", money);
				break;
			case 3:
				System.out.println("★ 월 금리 57% 대출 OPEN ☆");
				System.out.println("☆ 못 갚을 시 친절히 찾아갑니다 ★");
				System.out.print("얼마나 빌려드릴까 ? : ");
				loan = k.nextInt();
				System.out.printf("%,d원 여기 있으니까 많이 따시고 사장님 ~\n", loan);
				money += loan;
				accumulateLoan += loan;
				System.out.printf("여태까지 총 %,d원 빌렸으니 알아두시고 ~\n", accumulateLoan);
				break;
			case 4:
				System.out.println("아이고 사장님 ~");
				System.out.printf("%,d원 주시면 됩니다 ~\n", accumulateLoan);
				System.out.print("얼른 줘 봐유 : ");
				payback = k.nextInt();

				if (payback > accumulateLoan) {
					System.out.println("에이 사장님? 나도 낭만이 있어 ~ 이건 아니지 ! ");
					break;
				}

				money -= payback;
				accumulateLoan -= payback;

				if (accumulateLoan > 0) {
					System.out.printf("이제 %,d원 남으셨어요 사장님 ~\n", accumulateLoan);
					System.out.println("조금만 더 힘내시고 ~");
				} else if (accumulateLoan == 0) {
					System.out.println("아이고 사장님 욕보셨네 !");
					System.out.println("조심히 가요 ~ 멀리 안 나갑니다 ~");
				}
				break;
			case 5:
				System.out.println("게임을 종료합니다.");
				System.out.println("======================");
				break a;
			default:
				System.out.println("잘못 입력하셨네요?");
				break;
			}
		}
	}
}

import java.util.Random;

public class Computer {
	int coin = 20;
	Random cpu = new Random();
	
	public int askHowManyCoin(User u) {
		System.out.print("동전을 몇 개로 설정하시겠습니까?(2 ~ 20) : ");
		coin = u.answerHowManyCoin();
		if (coin < 2 || coin >= 21) {
			System.out.println("개수 설정 똑바로 하세요");
		}
		return (coin >= 2 || coin <= 20) ? coin : askHowManyCoin(u); 
	}
	
	public int shakeCoin(int userCoin) {
		return cpu.nextInt(userCoin) + 1;
	}
	
	public String askHJ(User u) {
		System.out.print("홀 or 짝? : ");
		String userAns = u.answerHJ();
		return (userAns.equals("홀") || userAns.equals("짝"))
				? userAns : askHJ(u);
	}
	
	public String judgeCoin(int shakeCoin) {
		return (shakeCoin % 2 == 0) ? "짝" : "홀";
	}
	
	public String getResult (String userAns, String comAns) {
		return userAns.equals(comAns) ? "정답" : "오답";
	}
	
	public void printResult(int shakeCoin, String result) {
		System.out.printf("동전은 %d개 뽑았고, %s이야!\n", shakeCoin, result);
	}
	
	public void start(User u) {
		int userCoin = askHowManyCoin(u);
		int shakeCoin = shakeCoin(userCoin);
		String userAns = askHJ(u);
		String comAns = judgeCoin(shakeCoin);
		String result = getResult(userAns, comAns);
		printResult(shakeCoin, result);
	}
	
}


public class Referee {
	
	// 나 부르기
	public Me callMe() {
		System.out.println("Referee : Ya! Nawa!");
		System.out.println("Me : 이 몸 등장 ㄴㅇㄱ");
		return new Me();
	}
	
	// 친구에게 답 요구
	public int askFriAns(Friend f) {
		int friAns = f.writeFriAns();
		return friAns;
	}
	
	// 나에게 답 요구
	public int askMyAns(Me mm) {
		int myAns = mm.tellMyAns();
		if (myAns < 1 || myAns > 100) {
			System.out.println("喝 !!!!");
		}
		return (myAns >= 1 && myAns <= 100) ? myAns : askMyAns(mm);
	}
	
	// 판정
	public boolean judge(int answer, int myAnswer) {
		if (answer == myAnswer) {
			System.out.println(". . . !");
		}else if (answer > myAnswer) {
			System.out.println("Up !");
		}else {
			System.out.println("Down !");
		}
		return (answer == myAnswer);
	}
	
	// 시도 횟수
	public void countTry(int turn) {
		System.out.println("=====================");
		System.out.printf("%d번째 시도만에 정답 !\n", turn);
		System.out.println("=====================");
	}
	
	
	
	public void start(Friend f) {
		Me mm = callMe();
		int answer = askFriAns(f);
		int myAnswer = 0;
		boolean endGame = false;
		int turn = 0;
		while (true) {
			myAnswer = askMyAns(mm);
			turn++;
			endGame = judge(answer, myAnswer);
			if (endGame) {
				countTry(turn);
				break;
			}
		}
	}
	
}


public class Judge {
	String[] rulebook = new String[] { " ", "가위", "바위","보" };
	
	public void readRulebook() {
		System.out.println("=================");
		for (int i = 1; i < rulebook.length; i++) {
			System.out.printf("%d. %s\n", i , rulebook[i]);
		}
		System.out.println("=================");
	}
	
	// 마루한테 뭐 낼지 물어보기
	// Overloading...!
	public int askAns(Maru m) {
		System.out.printf("마루 뭐 낼래 ? : ");
		int maruAns = m.fire();
		return (maruAns >= 1 && maruAns <= 3) ? maruAns : askAns(m);
	}

	// 남동생한테 물어보기
	public int askAns(Brother b) {
		int broAns = b.fire();
		return broAns;
	}
	
	// 누가 뭐 냈는지
	public void printHand(Maru m, Brother b) {
		System.out.printf("마루는 %s\n", rulebook[m.hand]);
		System.out.printf("동생은 %s\n", rulebook[b.hand]);
	}
	
	// 판정
	public boolean judgeWin(Maru m, Brother b) {
		int result = m.hand - b.hand;
		if (result == 0) {
			System.out.println("비겼다 !");
			m.draw++;
		} else if (result == -1 || result == 2) {
			System.out.println("동생이 이겼다 !");
		} else {
			System.out.println("마루가 이겼다 !");
			m.win++;
		}
		return (result == -1 || result == 2);
	}
	
	public void sayMaruWin(Maru m) {
		System.out.printf("마루는 %d번 비겼고, %d개의 간식을 얻을거야 !\n",
				m.draw, m.win);
	}
	
	public void start(Maru m, Brother b) {
		readRulebook();
		while (true) {
			m.hand = askAns(m);
			b.hand = askAns(b);
			printHand(m, b);
			System.out.println("=================");
			if (judgeWin(m, b)) {
				sayMaruWin(m);
				break;
			}
			System.out.println("=================");
		}
	}
}

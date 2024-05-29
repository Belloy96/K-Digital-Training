
// 연산자
//	shift 연산자
//	3 << 1
//		앞의 숫자를 이진수로 바꿔서 : 11(2)
//		왼쪽으로 뒤의 숫자만큼 밀고, 빈칸에는 0 채워넣기 : 110(2)
//		이진수(110)를 다시 십진수로 : 6

public class PMain2 {
	
	// 24시간 : 1 << 0
	// 주차장	: 1 << 1
	// WIFI : 1 << 2
	// 흡연실 : 1 << 3
	
	public static void main(String[] args) {
		int button1 = 10;
		if (button1 >= (1 << 3)) {
			System.out.println("흡연실");
			button1 -= (1 << 3);
		}
		
		// 남아있는 값으로 또 비교/계산을 해야하니 else if는 X!
		if (button1 >= (1 << 2)) {
			System.out.println("WIFI");
			button1 -= (1 << 2);
		}
		if (button1 >= (1 << 1)) {
			System.out.println("주차장");
			button1 -= (1 << 1);
		}
		if (button1 >= (1 << 2)) {
			System.out.println("24시간");
			button1 -= (1 << 2);
		}
		System.out.println(button1);
		System.out.println("-------------");
		
		int button2 = 13;
		String[] option = { "24시간", "주차장", "WIFI", "흡연실" };
		for (int i = option.length - 1; i >= 0; i--) {
			if (button2 >= (1 << i)) {
				System.out.println(option[i]);
				button2 -= (1 << i);
			}
		}
		System.out.println(button2);
		
	}
}

// Java로만 프로그램을 짠다면 유용한 기능이 될 수 있는데,
// 우리는 나중에 DB도 배울거라 거기서 조건 검색을 하는게 훨씬 쉬움
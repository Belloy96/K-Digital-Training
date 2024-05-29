
// 가위바위보
//	1. 등장인물 누구 ? => 심판 / ???(입력) / ???(랜덤)
//		=> 다 같이 한 자리에 있음
//		=> 심판한테는 룰북이 있음
//		1을 입력하면 가위 / 2를 입력하면 바위 / 3을 입력하면 보
//	2. 각 객체들의 속성? 행동?
//	3. 입력한 인물이 한 판 질 동안 몇 승 / 몇 무 했는지

public class OMain1 {
	public static void main(String[] args) {
		Judge j = new Judge();
		Maru m = new Maru();
		Brother b = new Brother();
		
		j.start(m, b);
		
	}
	
	
	
	
}

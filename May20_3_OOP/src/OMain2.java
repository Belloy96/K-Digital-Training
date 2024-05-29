// 게임 캐릭터 하나 생성 !
//	속성 : 닉네임 / 레벨 / 직업 / 무기
//	출력하는 기능까지 !
//	main에서 객체를 만들고 닉네임 값만 넣어서 출력

public class OMain2 {
	public static void main(String[] args) {
//		GameCharacter g1 = new GameCharacter();
//		g1.nickname = "비버";
//		g1.printInfo();
		
		GameCharacter g = new GameCharacter("비버:)");
		g.printInfo();
		
	}
}

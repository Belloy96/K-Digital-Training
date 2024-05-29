// ???
//		???
// Stack
//		변수를 만들 때마다 아래에서부터 차곡차곡 쌓임
//		프로그램이 종료되면 알아서 다 정리
// Heap
//		컴퓨터가 적당하다고 판단한 위치에 만든다
//		자동정리 X (핸드폰 메모리 정리하는 느낌으로.. 정리해야...)
// Garbage Collection : Heap영역 자동정리 시스템 (*** 면접)
// C나 C++에서는 Garbage Collection이 없어서 개발자가 수동으로
//		메모리 할당과 해제를 일일이 해줘야 했는데
// Java는 JVM에 탑재되어 있는 가비지 컬렉터(Garbage Collector)가
//		메모리 관리를 대행해주기 때문에
// 개발자 입장에서 메모리 관리, 메모리 누수(Memory Leak) 문제에 대해
// 완벽하게 관리하지 않아도 개발에만 집중할 수 있다
//		언제 ? - 그 번지에 더 이상 접근할 방법이 없어지면 발동(GC) !
//		단점 : 직접 눈으로 확인할 방법이 없음
//		System.gc(); 라는 기능으로 정리를 할 수는 있지만,
//		호출해서 사용하는 것 자체가 시스템 성능에 영향을 많이 줌 => 사용 X

public class OMain5 {
	public static void main(String[] args) {
		// 과자
		//	이름
		//	구매처
		// 	가격
		//	정보 출력
		
		Snack s1 = new Snack();
		s1.name = "자바칩";
		s1.shop = "솔데스크";
		s1.price = 120;		
		s1.printInfo();
		System.out.println("------------");
		Snack s2 = s1; // Snack s1은 s2라는 별명이 하나 더 생김 #그림판 참조#
		s1 = null;
		System.out.println(s1); // 아무 번지도 안가리킴 ** (null)
		System.out.println(s2);
		s2 = null; 
		////////////////////////// 과자의 정보가 사라지는 시점.
		//						   Garbage Collector가 발동 !
		System.out.println(s2);
		
		s2.printInfo(); // s2의 정보를 출력하는게 불가능
		// GC가 발동이 안 되면 다 끝나서야 날아감
	}
}
// 프로그램이 종료되면 Stack영역이 날아가고
//		=> Heap 영역에 접근을 못 하게 되니 GC 발동 !


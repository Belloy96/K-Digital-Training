import java.util.Scanner;

// Coder : 개발자
// Programmer : Coder + 설계 ***

// OOD (Object Oriented Design) - 객체 지향 디자인
//	실생활을 디자인

public class OMain1 {
	public static void main(String[] args) {
		// 의사 (이름, 나이)
		Doctor d = new Doctor();
		d.name = "김자바";
		d.age = 120;
		d.printDoctor();
		
		// 손님 (이름, 나이)
		Guest g = new Guest();
		g.name = "박이선";
		g.age = 11;
		g.printGuest();
		
		d.start(g);
	}
}

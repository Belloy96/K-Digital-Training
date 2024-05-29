import java.util.Scanner;

// Part1 : 절차지향 프로그래밍(순서대로 잘 써서 결과를 잘 내자) - 이과스럽다..
// Part2 : 객체지향 프로그래밍 - 문과스럽다..
// Part3 : 기타 등등.. 외부 라이브러리

// 조건문
// 반복문
// 배열
// -------------------------
// Part2
public class RMain4 {
	public static void main(String[] args) {

		// 누구 :
		// 매니저
		// 시스템관리
		// 학생관리
		// 수업관련 업무
		// 강사
		// 학생관리
		// 수업관련 업무
		// 학생
		// 수업관련 업무
		// 를 반복하다가 "끝"이라고 입력하면 프로그램이 종료!
		Scanner k = new Scanner(System.in);
		String role = null;
		a: while (true) {
			// 반복문에 이름 붙이기 => 반복문 앞에 [이름] [:]
			System.out.print("누구 : ");
			role = k.next();
			System.out.println("===========");
			System.out.println(role);
			switch (role) {
			case "매니저":
				System.out.println("시스템 관리");
			case "강사":
				System.out.println("학생 관리");
			case "학생":
				System.out.println("수업관련 업무");
				break;
			case "끝":
				// break; // 무조건 가까운거(switch)를 종료
				break a; // break 뒤에 반복문의 이름을 붙이면 반복문이 종료 !
			}

//			if (role.equals("끝")) {
//				break;
//			}
//			System.out.println("===========");
//			
		}
		System.out.println("----------------");

		bb: for (int i = 0; i < 3; i++) {
			aa: for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					System.out.printf("%d %d %d\n", i, j, j2);
					if (i == 1) {
						System.out.println("중단 !");

						break; // ?
//						break aa;	// ?
//						break bb;	// ?
					}
				}
			}
		}

	}

}

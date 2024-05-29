import java.util.Scanner;

public class KIMain1 {
	public static void main(String[] args) {
		// Scanner : Java에 내장되어있는 기능 중 하나 !
		// 이 기능을 사용하기 위해서 'import' 라는 것이 사용됨
		// 이 Scanner라는걸 사용하려면 조건이 하나 필요한데...
		//	new ~~~ : 객체
		
		// Scanner는 화면(이클립스의 콘솔창)으로부터
		//		데이터를 입력 받는 기능
		
		Scanner keyboard = new Scanner(System.in);
		// System.out.println();
		
		// 이름을 콘솔창에 입력받아서 출력
		
		System.out.print("이름 : ");
		String name = keyboard.next();
		
		// 예제3
		// 키, 몸무게, 신발사이즈, 여행가고싶은곳,
		// 좋아하는 숫자, 퇴근하고싶은지 유무
		// 를 입력받아서 변수에 담아서 출력!
		
		// 예제4
		// bat파일 생성 =>
		// '끄고 싶으면 아무거나 입력하세요 : '
		// 뭔가를 입력해서 엔터 치면
		// 1초마다 .이 나온 후 (3번)
		// '프로그램을 종료합니다' 라는 메시지가 출력되고
		// 0.5초 후에 프로그램이 종료
		
		
		
	}
}

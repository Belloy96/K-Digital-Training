import java.util.Scanner;

public class OMain5 {
	public static void main(String[] args) {
		// 키(cm), 몸무게(kg)를 입력받아서
		//		=> 비만도 검사 프로그램
		
		// 표준체중 = (키 - 100) * 0.9
		// 비만도 = (실제 체중 / 표준 체중) * 100
		// 비만도가 120을 넘으면 "비만"
		//	아니면 "안비만" 문구를 출력
		// 아무 키나 입력했을 때 프로그램이 종료되게 !
		
		Scanner k = new Scanner(System.in);
		
		System.out.print("키 : ");
		double height = k.nextDouble(); 
		System.out.print("몸무게 : ");
		double weight = k.nextDouble(); 
		
		double standard = (height - 100) * 0.9;
		double bmi = (weight / standard) * 100;
		
		String word = bmi > 120 ? "비만" : "안비만";
		
		System.out.printf("당신은 키가 %.1fcm, "
				+ "몸무게가 %.1fkg으로 "
				+ "비만도가 %.1f라서 %s입니다.\n"
				, height, weight, bmi, word);
		
		System.out.print("아무 키나 입력하세요 : ");
		String bye = k.next();
		System.out.println("프로그램을 종료합니다.");
		
	}
}

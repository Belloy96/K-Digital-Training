import java.util.Scanner;

public class YMain2 {
	public static void main(String[] args) {
		// 국어, 수학, 영어 점수를 각각 입력받아서 출력
		// + 총점과 평균점수까지 출력
		
		Scanner keyboard = new Scanner(System.in);
		// keyboard가 아닌 k로 지정하면 조금 더 수월함. ex) int kor = k.nextInt();
		System.out.print("국어 :");
		int korean = keyboard.nextInt();
		System.out.print("수학 :");
		int math = keyboard.nextInt();
		System.out.print("영어 :");
		int english = keyboard.nextInt();
		
		System.out.printf("국어 : %d점\n", korean);
		System.out.printf("수학 : %d점\n", math);
		System.out.printf("영어 : %d점\n", english);
		
		System.out.println("-------------------");
		int total = korean + math + english;
		System.out.printf("총점 : %d점\n", total);
		System.out.printf("평균 : %.1f점\n", (double) (total/3));
		
		// System.out.prinf("총점 : %d점\n", kor + math + eng);
		// System.out.prinf("총점 : %.1f점\n", 
		//		 (double) (kor + math + eng) / 3);
		
		// int / int = int 정수 나누기 정수는 반드시 정수값으로 나오게 되어있음
		// 따라서 (double) ()값을 사용하면 가능
		
	}

}

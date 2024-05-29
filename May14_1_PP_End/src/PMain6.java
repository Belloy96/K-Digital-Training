import java.util.Scanner;

// main함수에서 진행
// 1을 입력하면 학생 수 값을 입력 받을 수 있게
// 2를 입력하면 각 학생들의 점수를 입력 받을 수 있게 (점수 범위 고려 X)
// 3을 입력하면 학생들의 점수리스트를 출력할 수 있게 (ex: 1번 학생 점수 : 50점)
// 4를 입력하면 최고점수와 평균점수를 분석해서 출력할 수 있게
// 5를 입력하면 프로그램 종료

public class PMain6 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		int selectNo = 0;
		int studentNum = 0;
		// 배열의 기본값 = null
		int[] scores = null;

		a: while (true) {
			System.out.println("===============================");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 |" + " 4. 분석 | 5. 종료");
			System.out.println("===============================");
			System.out.print("선택> ");
			selectNo = k.nextInt();
			// if문 사용해도 무방
			switch (selectNo) {
			case 1:
				System.out.print("학생 수 : ");
				studentNum = k.nextInt();
				scores = new int[studentNum]; // 작성한 수를 배열로 옮기는 작업 !!
				break;
			case 2:
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("%d번 학생 점수 입력 : ", i + 1);
					scores[i] = k.nextInt(); // 작성한 수를 배열로 옮기는 작업 !!
				}
				break;
			case 3:
				int index = 1;
				for (int i : scores) {
					System.out.printf("%d번 학생 점수 : %d점\n", index++, i);
				}
				break;
			case 4:
				int max = 0;
				int sum = 0;
				double avg = 0;
				for (int i : scores) {
					sum += i;
					max = (max < i) ? i : max;
				}
				avg = (double) sum / scores.length; // (double) => avg는 double이기 때문
				System.out.printf("최고 점수 : %d점\n", max);
				System.out.printf("평균 점수 : %.2f점\n", avg);
				break;
			case 5:
				System.out.println("종료합니다");
				System.out.println("===============================");
				break a; // break;는 sw문을 깨버리는임 따라서 while에 이름(a) 붙이고
							// break a;가 된다
			default:
				System.out.println("===============================");
				System.out.println("잘못 입력했으니 다시 입력하세요");
				break;
			}

		}

	}
}

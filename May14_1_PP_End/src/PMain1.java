import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PMain1 {
	public static void main(String[] args) {
		// 10개의 숫자를 랜덤으로 뽑아서 (1 ~ 100)
		// 배열에 담고 => 출력
		int[] num = new int[10];
		Random r = new Random();
		int a = 0;
		for (int i = 0; i < num.length; i++) {
			a = r.nextInt(100) + 1;
			num[i] = a;
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
		System.out.println("------------");

		// 10개의 숫자를 직접 입력해서
		// 배열에 담고 => 출력
		int[] num2 = new int[10];
		Scanner k = new Scanner(System.in);
		int b = 0;
		for (int i = 0; i < num2.length; i++) {
			System.out.printf("%d번째 숫자? : ", i + 1);
			b = k.nextInt();
			num2[i] = b;
		}
		for (int i = 0; i < num2.length; i++) {
			System.out.print(num2[i] + " ");
		}
		System.out.println();
		System.out.println("------------");

		// 배열 (Random으로 받아온)의 최대값, 최소값 => 출력
//		Arrays.sort(num);
//		System.out.println(num[0]);
//		System.out.println(num[9]); => 이렇게 하면 편함

		int min = num[0]; // 배열의 0번째 숫자가 최소값이라고 가정
		int max = num[0]; // 배열의 0번째 숫자가 최대값이라고 가정

		for (int i = 0; i < num.length; i++) {
			if (min > num[i]) { // min의 숫자보다 num[i]의 숫자가 더 작다면
				min = num[i];
			} else if (max < num[i]) { // max의 숫자보다 num[i]의 숫자가 더 크다면
				max = num[i];
			}
		}
		System.out.println("최소값 : " + min);
		System.out.println("최대값 : " + max);

	}
}

import java.util.Scanner;

// 평일 스케쥴 출력해주는 프로그램

// 시간을 입력받아서 (24시간 단위) => 해당시간에 속하는 내용을 출력
//	=> (입력한 시간이) 시간 범위가 아니면 다시 입력

// 오전 9시 ~ 오후 6시 : 학원에서 공부
// 오전 9시, 오후 2시, 오후 6시 : QR찍기
// 오후 1시 ~ 오후 2시 전까지 : 점심시간
// 오후 6시 넘어서 ~ 오후 8시 : 집에가는 시간
// 오전 6시 ~ 오전 9시 전까지 : 기상 + 씻기 + 학원가기
// 오후 8시 ~ 오전 6시 전까지 : 여가시간 + 취침

public class YMain1 {
	
	// 시간 입력받기
	public static int getHour() {
		Scanner k = new Scanner(System.in);
		System.out.print("시간 입력(00 ~ 23) : ");
		int hour = k.nextInt();
		if (!(hour >= 0 && hour <= 23)) {
			System.err.printf("%02d시는 없습니다. 다시 입력하세요. \n", hour);
		}
		return (hour >= 0 && hour <= 23) ? hour : getHour();
	}
	
	// 시간을 출력하는 함수
	public static void printHour(int asdf) {
		System.out.println("-------------");
		System.err.printf("%02d시 ! \n", asdf);
		System.out.println("-------------");
	}
	
	//결과를 출력하는 함수
	public static void printResult(int hour) {
		if (hour >= 9 && hour <= 18) {
			System.out.println("학원에서 공부를 합니다.");
			if (hour == 9 || hour == 14 || hour == 18) {
				System.out.println("QR!!!!!!!!!!!!!!!!!!!");
			} else if (hour >= 13 && hour < 14) {
				System.out.println("점심 빠아아아아압~");
			}
		} else if (hour > 18 && hour <= 20) {
			System.out.println("침대가 기다려요 !!!!");
		} else if (hour >= 6 && hour < 9) {
			System.out.println("일어나기 + 씻기 + 학원가기...;;;;;");
		} else {
			System.out.println("여가시간 + 취침");
		}
		
	}
	
	
	// 해당시간 판단
	// 09 ~ 18 : 학원에서 공부
	// 09, 14, 18 : QR찍기
	// 13 ~ 14시 전까지 : 점심시간
	// 18시 넘어서 ~ 20 : 집에 가는 시간
	// 06 ~ 09시 전까지 : 기상 + 씻기 + 학원가기
	// 20 ~ 06시 전까지 : 여가시간 + 취침
	
	public static void main(String[] args) {
		int hour = getHour();
//		System.out.println(hour);
		printHour(hour);
		printResult(hour);
	}
	
}






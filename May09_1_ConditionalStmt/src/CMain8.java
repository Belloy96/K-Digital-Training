import java.util.Scanner;

// BMI 검사 프로그램 (함수.ver)

// 이름, 키(cm), 몸무게(kg) 입력
// BMI(체질량지수) : 몸무게 / (키 * 키) : m단위
//	18.5미만이면 저체중
//	18.5이상이면 정상
//	25이상이면 과체중
//	30이상이면 경도비만
//	35이상이면 중증도비만
//	40이상이면 고도비만
//	결과를 출력 (각 결과에 따른 코멘트 작성)하고,
//	Y를 입력하면 프로그램이 종료

public class CMain8 {
	// 이름 입력
	public static String getName() {
		Scanner k = new Scanner(System.in);
		System.out.print("성함을 입력해주세요 : ");
		String name = k.next();
		return name;
	}
	
	// 키 입력
	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키를 입력해주세요 : ");
		double height = k.nextDouble();
		return height;
	}
	
	// 체중 입력
	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("체중을 입력해주세요 : ");
		double weight = k.nextDouble();
		return weight;
	}
	
	// bmi 구하기
	public static double calcBMI(double w, double h) {
		double bmi = w / ((h/100) * (h/100));
		return bmi;
	}
	
	// 비만도분류
	public static String judgeBMI(double bmi) {
		if (bmi >= 40) {
			return "고도비만";
		} else if (bmi >= 35) {
			return "중증도비만";
		} else if (bmi >= 30) {
			return "경도비만";
		} else if (bmi >= 25) {
			return "과체중";
		} else if (bmi >= 18.5) {
			return "정상";
		} else {
			return "저체중";
		}
		
	}
	
	// 결과를 출력
	public static void printResult(String n, double h, 
			double w, double b, String r ) throws InterruptedException {
		System.out.println("=-=-=-=-=-=-=-=-=");
		System.out.printf("%s님의 BMI 테스트 시작합니다.\n", n);
		System.out.printf("키는 %.1fcm이고 체중은 %.1fkg으로\n", h, w);
		System.out.printf("BMI지수는 %.1f입니다.\n", b);
		System.out.println("=-=-=-=-=-=-=-=-=");
		
		Thread.sleep(1000);
		System.out.println("결과를 계산중입니다.");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.print(".");
		Thread.sleep(1000);
		System.out.println(".");
		Thread.sleep(3000);
		
		System.out.println("=-=-=-=-=-=-=-=-=");
		System.out.printf("%s 님은 [%s] 입니다!\n", n, r);
		
		// 각 결과에 따른 코멘트
		switch (r) {
		case "고도비만":
			System.out.println("짧고 굵게 사시길 원하시나요?\n");
			break;
		case "중증도비만":
			System.out.println("식단, 운동 당장 실시합시다.\n");
			break;
		case "경도비만":
			System.out.println("건강한 삶으로 돌아갑시다!!\n");
			break;
		case "과체중":
			System.out.println("금방 정상으로 가실 수 있어요.\n");
			break;
		case "정상":
			System.out.println("좋은 건강 상태네요.\n");
			break;
		case "저체중":
			System.out.println("너무 마르신거 아닐까요?\n");
			break;
		default:
			break;
		}
		
	}
	// Y를 입력하면 프로그램이 종료
	public static void exit() {
		Scanner k = new Scanner(System.in);
		System.out.print("프로그램을 종료하시겠습니까(Y/N)? : ");
		String answer = k.next();
		if (answer.equals("Y") || answer.equals("y")) {
			System.out.println("프로그램을 종료합니다.");
		} else {
			System.out.println("종료시켜주세요..");
			exit();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		double bmi = calcBMI(weight, height);
		String result = judgeBMI(bmi);
		printResult(name, height, weight, bmi, result);
		exit();
		
	}
	
}

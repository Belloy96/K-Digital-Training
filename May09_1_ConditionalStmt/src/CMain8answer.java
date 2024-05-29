import java.util.Scanner;

public class CMain8answer {
	
	// 프로그램 시작을 알려주는 함수
	public static void startBMI() {
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("\tBMI 검사를 시작~~~하겠습니다 !");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
	}
	
	// 이름을 입력하는 함수
	public static String getName() {
		System.out.print("이름 : ");
		return new Scanner(System.in).next();
	}
	
	// 키를 입력하는 함수
	public static double getHeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("키(cm) : ");
		double height = k.nextDouble();
		return height / 100;
	}
	
	// 몸무게를 입력하는 함수
	public static double getWeight() {
		Scanner k = new Scanner(System.in);
		System.out.print("몸무게(kg) : ");
		double weight = k.nextDouble();
		return weight;
	}
	
	// BMI를 계산해주는 함수
	public static double calcBMI(double weight, double height) {
		double bmi = weight / (height * height);
		return bmi;
	}
	// 결과를 판단(판정)해주는 함수
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
		
		/*String result = "저체중";
		if (bmi >= 40) {
			result = "고도비만";
		} else if (bmi >= 35) {
			result "중증도비만";
		} else if (bmi >= 30) {
			result "경도비만";
		} else if (bmi >= 25) {
			result "과체중";
		} else if (bmi >= 18.5) {
			result "정상";
		} else {
			result "저체중";
		}*/
	}
	
	
	// 결과를 출력해주는 함수 + 각 결과에 따른 코멘트 작성
	public static void printResult(String n, double h, double w, 
			double b, String r){
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.printf("%s님의 키는 %.1fcm, 몸무게는 %.1fkg이고..\n",
				n, h*100, w);
		System.out.printf("체질량지수(BMI) : %.1f입니다.\n", b);
		
		try {
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.println("잠시 후 결과가 나옵니다.");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.printf("\t%s님은 %s입니다 !\n", n, r);
		switch (r) {
		case "저체중":
			System.out.println("\t하루에 5끼 챙겨드세요.");
			break;
		case "정상":
			System.out.println("\t드시던 대로 드시면 됩니다.");
			break;
		case "과체중":
			System.out.println("\t먹는 양을 줄이시는게 어떨까요?");
			break;
		case "경도비만":
			System.out.println("\t하루에 2끼만 드세요.");
			break;
		case "중증도비만":
			System.out.println("\t하루에 1끼만 드세요.");
			break;
		case "고도":
			System.out.println("\t며칠 안먹는다고 안죽습니다.");
			break;

		default:
			break;
		}
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
	}
	
	// Y를 입력했을 때 프로그램을 종료해주는 함수 (ex: 종료하시겠습니까(Y/N))
	public static void exit() {
		Scanner k = new Scanner(System.in);
		System.out.print("종료하시겠습니까(Y/N)? : ");
		String answer = k.next();
		if (answer.equals("Y") || answer.equals("y")) {
			System.out.println("프로그램을 종료합니다.");
			System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		} else {
			System.out.println("무조건 종료해야하는데요 ?");
			exit();
		}
	}
	
	public static void start() {
		startBMI();
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		double bmi = calcBMI(weight, height);
		String result = judgeBMI(bmi);
		printResult(name, height, weight, bmi, result);
		exit();
		
	}
	
	public static void main(String[] args) {
		start();
	}
}

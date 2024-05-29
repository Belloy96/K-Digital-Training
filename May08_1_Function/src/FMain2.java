import java.util.Scanner;

public class FMain2 {
	// 비만도 검사 프로그램(함수.ver)
	
	// 키, 몸무게는 입력받을 것
	// 표준체중 = (키 - 100) * 0.9
	// 비만도 = (실제체중 / 표준체중) * 100
	// 비만도가 120이 넘으면 '비만' 아니면 '안비만'
	
	// 함수 : main함수에서 Java를 모르는 사람이 봐도
	//		 뭘 한건지 알아볼 수 있게 + 간결해야
	
	// 기능을 잘  분류해서 함수로 표현을 해줘야...!
	//	  => 유지보수가 편해집니다 ~
	
	// 만약에.. 표준체중을 구하는 공식이 0.9 => 0.8로 바뀌었다!
	// 다양한 기능을 함수 하나에 구현하고, 변경사항을 수정하게 됐을 때
	//	  (유지보수)
	// 한번에 잘 찾을 수 있을까...?
	
	// 어떤 기능(함수)를 만들까 설계해본 후 코드를 짤 것
	
	// 비만도 검사 시작 내용을 출력하는 함수
	public static void startBimando() {
		System.out.println("비만도 검사 시작 !");
	}
	
	// 키를 입력하는 함수
	public static double getHeight() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("키 :");
		double height = keyboard.nextDouble();
		return height;
	}
	
	// 몸무게를 입력하는 함수
	public static double getWeight() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("몸무게 :");
		double weight = keyboard.nextDouble();
		return weight;
	}
	
	// 키를 넣으면 표준체중을 구해주는 함수
	public static double calcStdWeight(double height) {
		return (height - 100) * 0.9;
	}
	
	// 실제체중과 표준체중을 넣으면
	//	비만도를 계산해서 값을 구해주는 함수
	public static double calcBimando(double weight, double stdWeight) {
		double bimando = (weight / stdWeight) * 100;
		return bimando;
	}
	
	// 비만인지 안비만인지 판정해주는 함수
	public static String judgeBimando(double bimando) {
		String result = (bimando > 120) ? "비만" : "안비만";
		return result;
	}
	
	// 결과를 출력해주는 함수
	public static void printResult(double h, double w, double std,
								double b, String r) {
		System.out.println("---------------");
		System.out.printf("키 : %.1fcm\n", h);
		System.out.printf("몸무게 : %.1fkg\n", w);
		System.out.printf("표준체중 : %.1fkg\n", std);
		System.out.printf("비만도 : %.1f\n", b);
		System.out.printf("당신은 [%s] 입니다.\n", r);
		System.out.println("---------------");
	}
	
	// 함수들 다 모아둔 함수(선택사항)
	public static void start() {
		startBimando();
		double height = getHeight();
		double weight = getWeight();
		double stdWeight = calcStdWeight(height);
		double bimando = calcBimando(weight, stdWeight);
		String result = judgeBimando(bimando);
		printResult(height, weight, stdWeight, bimando, result);
	}
	
	public static void main(String[] args) {
		start();
	}
	
}

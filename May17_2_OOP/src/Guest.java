import java.util.Scanner;

public class Guest {
	String name;
	int age;
	Scanner mouth = new Scanner(System.in);
	double height;
	double weight;
	double bmi;
	String bmiResult;
	
	public void printGuest() {
		System.out.println(" < 손님 > ");
		System.out.println(this.name);
		System.out.println(this.age);
		System.out.println("----------");
	}
	
	// 키에 대해 대답
	public double answerHeight() {
		return mouth.nextDouble();
	}
	
	// 몸무게에 대해 대답
	public double answerWeight() {
		return mouth.nextDouble();
	}
	
	
}

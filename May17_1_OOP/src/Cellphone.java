
public class Cellphone {
	String model;
	String manufacture;
	int price;
	
	public void printInfo() {
		System.out.printf("모델명\t: %s\n", model);
		System.out.printf("제조사\t: %s\n", manufacture);
		System.out.printf("가격\t: %d만원\n", price);
		System.out.println("-------------------");
	}
	
	public void getCall() {
		System.out.println("삼성 기본 벨소리 나오는 중...");
		System.out.println("-------------------");
	}
}

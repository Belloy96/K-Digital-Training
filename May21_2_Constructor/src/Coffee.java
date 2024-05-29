
public class Coffee {
	String name;
	int price;
	
	public Coffee() {
		// TODO Auto-generated constructor stub
	}
	
	public Coffee(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.printf("이름 : %s\n", name);
		System.out.printf("가격 : %,d원\n", price);
	}
}

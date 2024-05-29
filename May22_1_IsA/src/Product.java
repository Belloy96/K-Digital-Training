// 아무 상속도 받고 있지 않으면 extends Object
// Product is a Object (자바 객체)
public class Product /* extends Object */ {
	String name;
	int price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
	}
	
}

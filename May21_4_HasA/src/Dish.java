
public class Dish {
	String name;
	int price;
	Menu menu;
	
	public Dish() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Dish(String name, int price, Menu menu) {
		super();
		this.name = name;
		this.price = price;
		this.menu = menu;
	}


	public void printInfo() {
		System.out.println(name);
		System.out.println(price);
	}
}

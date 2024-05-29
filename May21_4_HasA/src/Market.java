
public class Market {
	String name;
	String location;
	Dish dish;

	public Market() {
		// TODO Auto-generated constructor stub
	}
	
	public Market(String name, String location, Dish dish) {
		super();
		this.name = name;
		this.location = location;
		this.dish = dish;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(location);
		dish.printInfo();
	}
}

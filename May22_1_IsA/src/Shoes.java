
public class Shoes extends Product {
	int size;
	
	public Shoes() {
		// TODO Auto-generated constructor stub
	}

	public Shoes(String name, int price, int size) {
		super(name, price);
		this.size = size;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(size);
	}
	
}

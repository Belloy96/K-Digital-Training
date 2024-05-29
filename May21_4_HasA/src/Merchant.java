
public class Merchant {
	String name;
	Market market;
	
	public Merchant() {
		// TODO Auto-generated constructor stub
	}
	
	public Merchant(String name, Market market) {
		super();
		this.name = name;
		this.market = market;
	}
	
	public void printInfo() {
		System.out.println(name);
		market.printInfo();
	}
}


public class Laptop extends Computer { // 컴퓨터의 상속 값을 받아올 수 있음
	double weight;
	double battery;
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	public Laptop(String name, int price, String cpu, int ram, int hdd, double weight, double battery) {
		super(name, price, cpu, ram, hdd);
		this.weight = weight;
		this.battery = battery;
	}
	
	@Override
		public void printInfo() {
			// TODO Auto-generated method stub
			super.printInfo();
			System.out.println(weight);
			System.out.println(battery);
		}
	
}


public class Computer extends Product {
	String cpu;
	int ram;
	int hdd;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}

	public Computer(String name, int price, String cpu, int ram, int hdd) {
		super(name, price);
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub << 지워도 ok
		super.printInfo();
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
	}
	
}

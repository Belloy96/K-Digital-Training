
public class Computer {
	String cpu;
	int ram;
	int hdd;
	Company manufacturer;
	
	public Computer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Computer(String cpu, int ram, int hdd, Company manufacturer) {
		super();
		this.cpu = cpu;
		this.ram = ram;
		this.hdd = hdd;
		this.manufacturer = manufacturer;
	}


	public void printInfo() {
		System.out.printf("CPU : %s\n", cpu);
		System.out.printf("RAM : %dG\n", ram);
		System.out.printf("HDD : %dG\n", hdd);
//		System.out.printf("제조사 : %s\n", manufacturer.name);
//		System.out.printf("위치 : %s\n", manufacturer.location);
//		System.out.printf("직원수 : %d\n", manufacturer.employee);
		manufacturer.printInfo();
	}
	
}

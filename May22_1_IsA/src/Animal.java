
public class Animal {
	String sort;
	int age;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(String sort, int age) {
		super();
		this.sort = sort;
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println(sort);
		System.out.println(age);
	}
}

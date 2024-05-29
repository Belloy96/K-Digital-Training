
public class Person {
	String name;
	int age;
	String affiliation;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String name, int age, String affiliation) {
		super();
		this.name = name;
		this.age = age;
		this.affiliation = affiliation;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(affiliation);
	}
	
}

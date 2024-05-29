
public class Army extends Person{
	String rank;
	
	public Army() {
		// TODO Auto-generated constructor stub
	}

	public Army(String name, int age, String affiliation, String position) {
		super(name, age, affiliation);
		this.rank = position;
	}
	
	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		super.printInfo();
		System.out.println(rank);
	}
	
}

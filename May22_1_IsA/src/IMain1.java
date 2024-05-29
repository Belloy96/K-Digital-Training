// 객체간의 관계
//	A is a B : Dog is a Animal
public class IMain1 {
	public static void main(String[] args) {
		// 동물(Animal) 객체 => sort, age + 정보 출력 기능
		Cat c = new Cat();
		c.printInfo();
		System.out.println("-----------");
		
		Dog d = new Dog("포메", 4, "우리집");
		d.printInfo();
		System.out.println("-----------");
		
	}
}

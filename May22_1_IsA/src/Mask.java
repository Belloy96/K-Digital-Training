
public class Mask extends Product2{
	public Mask() {
		// TODO Auto-generated constructor stub
	}
	
	// Product2(name, price)랑 같은 생성자를 갖고 싶음 - 직접 치는 방법 외에는 없음
	//				(오버로딩 단축키 실행시 실행 불가)
	
	public Mask(String name, int price) {
		super(name, price);
	}
	
	// mask에도 오버라이딩 썼는지 강의 확인해볼것
	
}

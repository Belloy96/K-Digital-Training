
// A has a B : 포함관계
public class HMain1 {
	public static void main(String[] args) {
		// 이름이 Andrew Kim, 남자, 핸드폰 번호가 010-1234-5678인 사람
		// 출력
		Person person = new Person("Andrew Kim", "남자", "010-1234-5678");
		person.printInfo();
		System.out.println("====================");
		
		// 강남포차, 논현동, 02-1111-2222, Andrew Kim의 식당
		// 출력(식당 주인의 정보까지)
		Restaurant restaurant = new Restaurant("강남포차", "논현동", 
				"02-1111-2222", person);
		restaurant.printInfo();
		System.out.println("====================");
		
		// 계란말이, 22000원, 강남포차에서 파는 메뉴
		// 관련된 전체 정보를 출력
		Menu menu1 = new Menu("계란말이", 22000, restaurant);
		menu1.printInfo();
		System.out.println("====================");
		
		// 석쇠불고기, 25000원, 강남포차에서 파는 메뉴
		// 관련된 전체 정보를 출력
		Menu menu2 = new Menu("석쇠불고기", 25000, restaurant);
		menu2.printInfo();
		System.out.println("====================");
		
		// 석쇠, 5000원, 석쇠불고기를 담은 접시
		// 관련된 전체 정보를 출력
		Dish dish = new Dish("석쇠", 5000, menu2);
		dish.printInfo();
		System.out.println("====================");
		
		// 가락시장, 송파구, 석쇠를 구매한 시장
		// 관련된 전체 정보를 출력
		Market market = new Market("가락시장", "송파구", dish);
		market.printInfo();
		System.out.println("====================");
		
		// 곽두팔, 가락시장을 좋아하는 상인
		// 관련된 전체 정보를 출력
		Merchant merchant = new Merchant("곽두팔", market);
		merchant.printInfo();
		System.out.println("====================");
		
		// 곽두팔의 이름만 출력
		System.out.println(merchant.name);
		System.out.println("====================");
		
		// 곽두팔이 좋아하는 시장 정보를 전체 출력
		merchant.market.printInfo();
		System.out.println("====================");
		
		// 곽두팔이 좋아하는 시장은 어디에? 출력
		System.out.println(merchant.market.location);
		System.out.println("====================");
		
		// 곽두팔이 좋아하는 시장에서 산 접시 전체정보 출력
		merchant.market.dish.printInfo();
		System.out.println("====================");
		
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴 전체 정보
		merchant.market.dish.menu.printInfo();
		System.out.println("====================");
		
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴의 가격
		System.out.println(merchant.market.dish.menu.price);
		System.out.println("====================");
		
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당 연락처
		System.out.println(merchant.market.dish.menu.where.callNum);
		System.out.println("====================");
		
		// 곽두팔이 좋아하는 시장에서 산 접시에 담긴 메뉴를 판 식당 주인 연락처
		System.out.println(merchant.market.dish.menu.where.owner.phoneNum);
		System.out.println("====================");
		
		// 계란말이를 파는 사람 연락처
		System.out.println(menu1.where.owner.phoneNum);
		System.out.println("====================");
		
		
	}
}

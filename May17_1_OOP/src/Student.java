// 라이브러리용 Class (API : Application Program Interface)
//		: 다른 Class에서 이용할 목적으로 만든 Class
// 프로그램에서 실행되는 Class가 여러 개, 단 하나를 빼고는 전부 라이브러리용 !!
//		: 제외됐던 하나의 Class => 실행용 (Main)

public class Student {
	
	// 멤버변수(Member Variable) / 필드 (Field)
	//		: 객체의 데이터가 저장되는 공간
	//		변수와 비슷하게 생겼지만 변수는 아님
	//		- 변수 : 생성자, 메소드 내부에서만 사용되고,
	//				생성자, 메소드 실행이 종료되면 이 변수는 종료와 함께 자동으로 날아감
	//		- 필드 : 생성자, 메소드 전체에서 사용이 가능
	//				객체가 소멸되지 않는 한 객체와 함께 공존
	
	// 초기 값이 지정되지 않은 멤버변수는 객체 생성 시
	// 자동으로 기본 초기값을 설정
	String studentName;
	String studentAddress;
	
	// method(메소드) : 객체의 동작에 해당하는 실행 블록
	// 메소드명은 동사스럽게 짓기
	// 메소드를 호출 시, (이 영역 안의) 모든 코드를 일괄적으로 실행!
	// 객체 간의 데이터를 전달 수단
	public void showStudentInfo() {
		System.out.println(studentName + " " + studentAddress);
	}
}

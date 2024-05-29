
public class PMain3 {
	public static void main(String[] args) {
		// print
		System.out.printf("1asdf");
		System.out.println("2asdf");
		
		// printf (Formatting - 형식 지정)
		// System.out.printf("%??, 값"); 의 형태
		
		// 정수 (decimal)
		// %d : 정수 데이터가 들어올 자리(decimal, 10진수)
		// %xd : 빈자리가 띄어쓰기로 채워져서 출력
		// %0xd : 빈자리를 0으로 채워서 x자리의 숫자로 만들어 줌
		System.out.printf("%d\n", 1);
		System.out.printf("%3d\n", 1);
		System.out.printf("%010d\n", 1);
		System.out.println("--------------");
		
		// 실수 (float)
		// %f : 실수데이터가 들어올 자리
		// %.xf : 소수점 이하의 자릿수
		//			잘리는 부분은 반올림처리
		//			빈자리는 0으로 채워줌
		System.out.printf("%f\n", 123.456789);
		System.out.printf("%.3f\n", 123.456789);
		System.out.printf("%.10f\n", 123.456789);
		System.out.println("--------------");
		
		// 문자열 (String)
		// %s : 글자데이터가 들어올 자리
		// 숫자 : 그냥 입력하면 됨
		// 문자 : 그냥 입력하게 되면 Java의 문법으로 해석하기에
		//		=> 오류가 발생
		//		=> "내용" (큰 따옴표 안에 문자 넣기 !)
		
		System.out.printf("%s\n", "헉? 내일 휴일이라고요?");
		System.out.println("------------");
		
		// 예제 1번
		// 오늘 날짜 기준으로 연도 => xxxx년
		//	월 => xx월
		//	일 => xx일
		//	연-월-일의 형태로 붙여서 ex) 날짜 : xxxx-xx-xx
		//	날씨 : 더움
		// 	기온 : 23도
		//	습도 : 20.21%
		
		 System.out.printf("%d년\n", 2024);
		 System.out.printf("%4d년\n", 2024);
		 System.out.printf("%02월\n", 4);
		 System.out.printf("%02일\n", 30);
		 System.out.printf("날짜 : %4d-%02d-%02d\n", 2024,04,30);
		 System.out.printf("날짜 : %s\n", "더움");
		 System.out.printf("기온 : %s\n", 23);
		 System.out.printf("습도 : %.2f%%\n", 20.21);
		 // %% : %를 글자로 표현하고 싶을 때 (print에서만 !)
		
	}
}


// 재귀적 호출 (recursive call)
//	함수 속에서 자기 자신(이 함수)을 또 호출 => 반복

// 함수를 호출한다 : 비교적 느린 작업

// 반복문 : ex) 'for'

// 기업에서 테스트할 때 이걸 활용한 알고리즘을 문제로 내는 경우가 있음

public class FMain5 {
	
	// 등차수열
	// 정수를 하나 넣으면
	// 1 + 2 + 3 + 4 + ... + 그 숫자까지
	// 다 더한 값을 구해주는 함수
	
	// add(1) = 1
	// add(2) = 3 => add(1) + 2 => 1 + 2
	// add(3) = 6 => add(2) + 3 => add(1) + 2 + 3 => 1 + 2 + 3
	
	public static int add(int x) {
		int answer = (x == 1) ? 1 : (x + add(x - 1));
		return answer;
//		return x * (x+1) / 2;
	}
	
	// 정수를 하나 넣으면 factorial값 구하는 함수
	// ex) 6! = 720
	//	1! = 1 
	//	2! = 2 => 2 * 1
	// 	3! = 6 => 3 * 2 * 1
	
	public static int factorial(int x){
		int answer = (x == 1) ? 1 : (x * factorial(x - 1));
		return answer;
	}
	
	// 피보나치 수열
	//	1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
	//	정수를 하나 넣으면 해당 위치에 나올 숫자값 구하기
	
	// l(1) = 1
	// l(2) = 1 = l(1)
	// l(3) = 2 = l(2) + l(1)
	// l(4) = 3 = l(3) + l(2)
	// l(5) = 5 = l(4) + l(3)
	// l(6) = 8 = l(5) + l(4)
	
	public static int fibo(int x) {
		int answer = (x < 3) ? 1 : (fibo(x - 1) + fibo(x - 2));
		return answer;
	}
	
	// 숫자 하나를 넣어서 각 자릿수의 숫자를 더한 값 구하기
	// ex) digitSum(12345) = 15
	
	public static int digitSum(int x) {
		int num = (x < 10) ? x : (x % 10 + digitSum(x / 10));
		return num;
	}
	
	public static void main(String[] args) {
		System.out.println("----------");
		int a = add(10);
		System.out.println(a);
		System.out.println("----------");
		int f = factorial(4);
		System.out.println(f);
		System.out.println("----------");
		int f2 = fibo(7);
		System.out.println(f2);
		System.out.println("----------");
		int f3 = digitSum(12345);
		System.out.println(f3);
		System.out.println("----------");
		
	}
				
		
				
		

	
	
	
	
}

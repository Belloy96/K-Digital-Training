import java.util.Scanner;

public class Me {
	
	Scanner mouth = new Scanner(System.in);
	
	public int tellMyAns() {
		System.out.print("정답은 : ");
		int myAns = mouth.nextInt();
		return myAns;
	}
	
}

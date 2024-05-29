import java.util.Random;

public class Brother {
	Random brain = new Random();
	int hand;
	
	public int fire() {
		return brain.nextInt(3) + 1;
	}
	
}

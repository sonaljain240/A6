/**
 * Created by Ali on 4/18/2016.
 */
public class Main {
	public static void main(String[] args) {
		Theatre a = new Theatre();
		for(int i = 0; i <= 26 * 29; i++) {
			System.out.println(a.getNextSeat());
		}
	}
}

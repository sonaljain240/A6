import java.util.LinkedList;
import java.util.Queue;


public class Theatre {
	private char currentSeatRow ;
	private int currentSeatNumber;
	private int tempAdder;
	private int sign;
	private Queue<String> tickets;
	private String section;

	final String house_left = "House Left";
	final String house_middle = "House Middle";
	final String house_right = "House Right";

	public  Theatre() {
		currentSeatRow = 'A';
		currentSeatNumber = 114;
		tempAdder = 1;
		sign = 1;
		
		tickets = new LinkedList<>();
		while (currentSeatRow <= 'Z') {
			if(currentSeatNumber < 108) 
				section = house_left;
			else if(currentSeatNumber > 121)
				section = house_right;
			else 
				section = house_middle;
			tickets.add(currentSeatRow + "" + currentSeatNumber + ", " + section);
			currentSeatNumber += tempAdder * sign;
			sign = -1 * sign;
			tempAdder = (tempAdder + 1) % 28;
			if(tempAdder == 1) {
				currentSeatNumber = 114;
				currentSeatRow += 1;
				sign = 1;
			}
		}
	}

	public String getNextSeat() {
		if(tickets.peek() != null)
			return tickets.poll();
		else return "no more seats";
	}
}


public class Theatre {
	private char currentSeatRow ;
	private int currentSeatNumber;
	private int tempAdder;
	private int sign;

	public  Theatre () {
		currentSeatRow = 'A';
		currentSeatNumber = 114;
		tempAdder = 1;
		sign = 1;
	}

	public String getNextSeat() {
		String output = currentSeatRow + "" + currentSeatNumber;
		if (currentSeatRow <= 'Z') {
			currentSeatNumber += tempAdder * sign;
			sign = -1 * sign;
			tempAdder = (tempAdder + 1) % 28;
			if(tempAdder == 1) {
				currentSeatNumber = 114;
				currentSeatRow += 1;
				sign = 1;
			}
		} else {
			output = "no empty seats";
		}
		return output;
	}
}

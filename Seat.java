package assignment6;

public class Seat {
	public static String[] rowLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", 
			"M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "AA"};

	public static int[] seatPriorityCtoX = {114, 115, 113, 116, 112, 117, 111, 118, 110, 119, 109, 120, 
			108, 121, 107, 122, 106, 123, 105, 124, 104, 125, 103, 126,
			102, 127, 101, 128};

	public static int[] seatPriorityAtoB = {114, 115, 113, 116, 112, 117, 111, 118, 110, 119, 109, 120, 
			108, 121, 122, 123, 124, 125, 126, 127, 128};

	public static int[] seatPriorityYtoZ = {107, 122, 106, 123, 105, 124, 104, 125, 103, 126, 102, 127, 101, 128};
	
	public static int[] seatPriorityAA = {118, 127, 117, 116, 104, 103, 102, 101, 128};
	
	private String seatLetter;
	private int seatNumber;
	
	public Seat(String letter, int number){
		this.seatLetter = letter;
		this.seatNumber = number;
	}

	public String getSeatLetter() {
		return seatLetter;
	}

	public void setSeatLetter(String seatLetter) {
		this.seatLetter = seatLetter;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
}

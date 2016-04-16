package assignment6;


public class Seat {
	public static String[] rowLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

	public static int[] seatPriorityAtoZ = {114, 115, 113, 116, 112, 117, 111, 118, 110, 119, 109, 120, 
			108, 121, 107, 122, 106, 123, 105, 124, 104, 125, 103, 126, 102, 127, 101, 128};

	
	private String seatLetter;
	private int seatNumber;
	private String seatType;
	
	final static String TYPE_MIDDLE = "M";
	final static String TYPE_LEFT = "HL";
	final static String TYPE_RIGHT = "HR";
	

	
	public Seat(String letter, int number, String type){
		this.seatLetter = letter;
		this.seatNumber = number;
		this.seatType = type;
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
	
	public String getSeatType() {

		return seatType;
	}

	public void setSeatType(String type) {
		this.seatType = type;
	}

	public String getSeatName() { return this.seatLetter + "" + this.seatNumber + "" + this.seatType;}
	
}

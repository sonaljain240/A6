package assignment6;


import java.util.ArrayList;

public class Ticket {

	private Seat mySeat;
	private boolean available;


	public Ticket(Seat mySeat, boolean available)
	{
		this.mySeat = mySeat;
		this.available = available;
	}


	public Seat getMySeat() {
		return mySeat;
	}


	public void setMySeat(Seat mySeat) {
		this.mySeat = mySeat;
	}


	public boolean isAvailable() {
		return available;
	}


	public void setAvailable(boolean available) {
		this.available = available;
	}

	public static ArrayList<Ticket> createTickets()
	{
		ArrayList<Ticket> tickets = new ArrayList<>();
		
		int j = 0;
		while(j < 26)
		{
			String[] row = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
					"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			int[] seatNumbersAtoZ = Seat.seatPriorityAtoZ;

			for(int i = 0; i < seatNumbersAtoZ.length; i++)
			{
				Seat mySeat;
				if(seatNumbersAtoZ[i] > 107 && seatNumbersAtoZ[i] < 122){
					mySeat = new Seat(row[j], seatNumbersAtoZ[i], Seat.TYPE_MIDDLE);
				}
				else if(seatNumbersAtoZ[i] <= 107 ){
					mySeat = new Seat(row[j], seatNumbersAtoZ[i], Seat.TYPE_LEFT);
				}
				else{
					mySeat = new Seat(row[j], seatNumbersAtoZ[i], Seat.TYPE_RIGHT);
				}
				Ticket myTicket = new Ticket(mySeat, true);
				tickets.add(myTicket);
			}

			j++;
		}

		return tickets;
	}

	public static Ticket getBestTicket(ArrayList<Ticket> tickets)
	{
		
		if(tickets.size() == 0){
			return null;
		}
		else{
			Ticket temp = tickets.get(0);
			tickets.remove(0);
			return temp;
		}
		
	}
	
	public String toString()
	{
		return this.mySeat.getSeatLetter() + this.mySeat.getSeatNumber() + this.mySeat.getSeatType();
	}


	
}

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
		
		//handle rows A_B
		int j = 0;
		while(j < 2)
		{
			String[] row = {"A", "B"};
			int[] seatNumbersAtoB = Seat.seatPriorityAtoB;

			for(int i = 0; i < seatNumbersAtoB.length; i++)
			{
				Seat mySeat;
				mySeat = new Seat(row[j], seatNumbersAtoB[i]);

				Ticket myTicket = new Ticket(mySeat, true);
				tickets.add(myTicket);
			}

			j++;
		}

		//handle rows C-X
		j = 0;
		while(j < 22)
		{
			String[] row = {"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X"};
			int[] seatNumbersCtoX = Seat.seatPriorityCtoX;

			for(int i = 0; i < seatNumbersCtoX.length; i++)
			{
				Seat mySeat;
				mySeat = new Seat(row[j], seatNumbersCtoX[i]);

				Ticket myTicket = new Ticket(mySeat, true);
				tickets.add(myTicket);
			}

			j++;
		}

		//handle rows Y-Z
		j = 0;
		while(j < 2)
		{
			String[] row = {"Y", "Z"};
			int[] seatNumbersYtoZ = Seat.seatPriorityYtoZ;

			for(int i = 0; i < seatNumbersYtoZ.length; i++)
			{
				Seat mySeat;
				mySeat = new Seat(row[j], seatNumbersYtoZ[i]);

				Ticket myTicket = new Ticket(mySeat, true);
				tickets.add(myTicket);
			}

			j++;
		}

		//handle row AA
		int[] seatNumbersAA = Seat.seatPriorityAA;
		for(int i = 0; i < seatNumbersAA.length; i++)
		{
			Seat mySeat;

			mySeat = new Seat("AA", seatNumbersAA[i]);

			Ticket myTicket = new Ticket(mySeat, true);
			tickets.add(myTicket);
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
		return this.mySeat.getSeatLetter() + this.mySeat.getSeatNumber();
	}


	
}

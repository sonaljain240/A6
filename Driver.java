package assignment6;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args)
	{
		ArrayList<Ticket> tickets = Ticket.createTickets();
		
		
		for(int i = 0; i < tickets.size(); i++)
		{
			System.out.println(tickets.get(i));
		}
	}
	
}

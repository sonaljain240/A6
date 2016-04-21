import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class TicketServer {
	static int PORT = 2222;
	// EE422C: no matter how many concurrent requests you get,
	// do not have more than three servers running concurrently
	final static int MAXPARALLELTHREADS = 3;

	public static void start(int portNumber) throws IOException {
		PORT = portNumber;
		Runnable serverThread = new ThreadedTicketServer();
		Thread t = new Thread(serverThread);
		t.start();
	}
}

class ThreadedTicketServer implements Runnable {

	String hostname = "127.0.0.1";
	String threadname = "X";
	String testcase;
	TicketClient sc;
	ArrayList<String> clients;
	Theatre bates;

	public ThreadedTicketServer() {
		super();
//		tickets = Ticket.createTickets();
		bates = new Theatre();
		clients = new ArrayList<>();
	}

	public void run() {
		ServerSocket serverSocket;
		try {
			String a = "";
			serverSocket = new ServerSocket(TicketServer.PORT);
			do {
				Socket clientSocket = serverSocket.accept();
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
				String clientRequest = in.readLine();
				if(clientRequest.equals("client done")) {
					clientRequest = in.readLine();
					clients.remove(find(clientRequest));
				} else if(find(clientRequest) < 0) {
					clients.add(clientRequest); 
				}
				
				a = bates.getNextSeat();
				out.println(a);
				clientSocket.close();
			} while(!a.equals("no more seats") || !clients.isEmpty());
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public int find(String s) {
		for(int i = 0; i < clients.size(); i ++) {
			if(clients.get(i).equals(s))
				return i;
		}
		return -1;
	}
}
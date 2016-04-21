import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ThreadedTicketClient implements Runnable {
	String hostname = "127.0.0.1";
	String threadname = "X";
	TicketClient sc;

	public ThreadedTicketClient(TicketClient sc, String hostname, String threadname) {
		this.sc = sc;
		this.hostname = hostname;
		this.threadname = threadname;
	}

	public void run() {
		System.out.flush();
		try {
			Socket echoSocket = new Socket(hostname, TicketServer.PORT);
			PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

			if (sc.done) {
				out.println("client done");
				out.println(threadname);
			} else {
				out.println(threadname);
				sc.result = in.readLine();
			}

			echoSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class TicketClient {
	ThreadedTicketClient tc;
	String result = "dummy";
	String hostName = "";
	String threadName = "";
	boolean done;

	TicketClient(String hostname, String threadname) {
		tc = new ThreadedTicketClient(this, hostname, threadname);
		hostName = hostname;
		threadName = threadname;
		done = false;
	}

	TicketClient(String name) {
		this("localhost", name);
	}

	TicketClient() {
		this("localhost", "unnamed client");
	}

	void requestTicket() {
		// TODO thread.run()
		tc.run();
		int run = (int) (Math.random() * (1000 - 728) + 728);
		int i = 0;
		while(!result.equals("no more seats") && i < run) {
			System.out.println(hostName + ", " + threadName + ": sold one ticket, seat " + result);
			tc.run();
			i ++;
		}
		System.out.println(hostName + ", " + threadName+ ": theatre ran out of tickets");
		System.out.println(hostName + ", " + threadName+ ": sold " + i + " tickets");
		done = true;
		tc.run();
	}

	void sleep() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

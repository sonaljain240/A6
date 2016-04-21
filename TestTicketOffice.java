/**
 * Ali Tejani, amt3639
 * Sonal Jain, sj23277
 * Thursday 9:30-11
 */

package Assignment6;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TestTicketOffice {

	public static int score = 0;

	@Test
	public void singleOfficeTest() {
		try {
			TicketServer.start(16789);
		} catch (Exception e) {
			fail();
		}
		TicketClient client = new TicketClient("Office 1");
		client.requestTicket();
	}

	@Test
	public void twoOfficeTest() {
		try {
			TicketServer.start(16790);
		} catch (Exception e) {
			fail();
		}
		final TicketClient c1 = new TicketClient("Office 1");
		final TicketClient c2 = new TicketClient("Office 2");
		Thread t1 = new Thread() {
			public void run() {
				c1.requestTicket();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				c2.requestTicket();
			}
		};
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void threeOfficeTest() {
		try {
			TicketServer.start(16792);
		} catch (Exception e) {
			fail();
		}
		final TicketClient c1 = new TicketClient("Office 1");
		final TicketClient c2 = new TicketClient("Office 2");
		final TicketClient c3 = new TicketClient("Office 3");
		Thread t1 = new Thread() {
			public void run() {
				c1.requestTicket();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				c2.requestTicket();
			}
		};
		Thread t3 = new Thread() {
			public void run() {
				c3.requestTicket();
			}
		};
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
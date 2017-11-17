import java.util.*;

public class Producer extends Thread {

	private MessageQueue mbox;

	public Producer(MessageQueue m) {
		mbox = m;

	}

	public void run() {
		Date message;

		while (true) {
			int sleeptime = (int) (Server.NAP_TIME * Math.random()); // Randomly generate leep time

			System.out.println("Producer sleeping for " + sleeptime + " seconds");

			try {
				Thread.sleep(sleeptime * 1000); // sleep for sleeptime seconds
			} catch (InterruptedException e) {

			}

			message = new Date(); // Create new message
			System.out.println("Producer produced " + message);
			mbox.send(message); // Send MEssage to the MEssageQueue mailbox
		}

	}

}

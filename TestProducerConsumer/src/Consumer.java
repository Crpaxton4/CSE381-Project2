import java.util.*;

public class Consumer extends Thread {
	
	private MessageQueue mbox;
	
	public Consumer(MessageQueue m) {
		mbox = m;
		
	}

	public void run() {
		Date message;
		
		while (true) {
			int sleeptime = (int) (Server.NAP_TIME * Math.random()); //Randomly  generate a sleep time
			
			System.out.println("Consumer sleeping for " + sleeptime + " seconds");
			
			try {
				Thread.sleep(sleeptime * 1000); // sleep for sleeptime seconds
				
			} catch (InterruptedException e) {
				
			}

			message = (Date) mbox.receive();  // Consume a message from the MessageQueue mmailbox

			// Print the message if there was a mmessage to be consumed
			if (message != null) System.out.println("Consumer consumed " + message);
		}
	}

	
}

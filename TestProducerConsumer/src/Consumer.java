import java.util.*;

public class Consumer extends Thread {
	public Consumer(MessageQueue m){
		mbox = m;
	}
	public void run() {
		Date message;
		while (true) {
			int sleeptime = (int) (Server.NAP_TIME * Math.random());
			System.out.println("Consumer sleeping for " + sleeptime + " seconds");
			try {
				Thread.sleep(sleeptime * 1000);
			} catch (InterruptedException e ) { }
			
			message = (Date) mbox.receive();
			
			if ( message != null)
				System.out.println(" Consumer consumed " + message);
		}
	}
private MessageQueue mbox;
}

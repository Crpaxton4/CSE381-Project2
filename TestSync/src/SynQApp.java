import java.util.*;
import java.util.concurrent.*;

class Producer implements Runnable {
	
	private BlockingQueue<String> drop;
	
	List<String> messages = Arrays.asList("Mares eat oats", "Does eat oats", "Little lambs eat ivy", "Wouldn't you eat ivy too?");

	public Producer(BlockingQueue<String> d) {
		this.drop = d;
		
	}

	public void run() {
		try {
			for (String s : messages) {  // Put all of the messages in 'messages' and put them in 'drop'
				drop.put(s);
			}
			drop.put("DONE"); // Stop element. Signals that there are no more elements left in the queue
			
		} catch (InterruptedException intEx) {
			System.out.println("Interrupted! Last one out, turn out the lights!");
			
		}
	}
}

class Consumer implements Runnable {
	
	private BlockingQueue<String> drop;

	public Consumer(BlockingQueue<String> d) {
		this.drop = d;
		
	}

	public void run() {
		try {
			
			String msg = null;
			
			while (!((msg = drop.take()).equals("DONE"))) { // 'DONE' is the last thing put in th e queue. Print everything put in the qqueuue before 'DONE'
				System.out.println(msg);
			}
			
		} catch (InterruptedException intEx) {
			System.out.println("Interrupted! Last one out, turn out the lights!");
		}
	}
}

public class SynQApp {
	
	public static void main(String[] args) {
		
		BlockingQueue<String> drop = new SynchronousQueue<String>(); // Create a queue to be shared
		
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
		
	}
}

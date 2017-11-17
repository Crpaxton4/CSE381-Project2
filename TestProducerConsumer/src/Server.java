
public class Server {
	
	public static final int NAP_TIME = 5;
	
	public Server() {
		MessageQueue mailBox = new MessageQueue();

		Producer producerThread = new Producer(mailBox);  // sends messages to the MessageQueue mailbox
		Consumer consumerThread = new Consumer(mailBox);  // recieves messages from the MessageQueue mailbox

		producerThread.start();
		consumerThread.start();
	}

	public static void main(String[] args) {
		Server server = new Server(); // Calls the constructor which starts the threads
		
	}

	
}


public class Server {
public Server() {
	MessageQueue mailBox = new MessageQueue();
	
	Producer producerThread = new Producer(mailBox);
	Consumer consumerThread = new Consumer(mailBox);
	
	producerThread.start();
	consumerThread.start();
}
public static void main(String[] args){
	Server server = new Server();
}
public static final int NAP_TIME = 5;
}

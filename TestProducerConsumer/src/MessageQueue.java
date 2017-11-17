import java.util.*;

public class MessageQueue {
	
	private Vector<Object> queue; // Added Object type generic to get rid of the warnings. Not really Necessary, but cleaner imo
	
	public MessageQueue() {
		queue = new Vector<Object>();
	}

	// The meaning of send and receive are in the context of the client and appear reversed in the context of the queue
	
	public void send(Object item) {
		// queue is sent a new element
		queue.addElement(item);
	}

	public Object receive() {
		// The Client recieves the oldest element from the queue
		// (queue = FIFO)
		
		Object item;
		if (queue.size() == 0)
			return null;
		else {
			item = queue.firstElement();
			queue.removeElementAt(0);
			return item;
		}
	}

	
}

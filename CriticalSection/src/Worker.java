
public class Worker extends Thread {
	private String name;
	private int id;
	private MutualExclusion shared;

	public Worker(String n, int i, MutualExclusion s) {
		name = n;
		id = i;
		shared = s;
	}

	public void run() { // Function run by a Worker Thread
		while (true) {
			shared.enteringCriticalSection(id); // Attempt to lock the Mutex
			System.out.println(name + " is in critical section"); // Has Locked the Mutex
			MutualExclusion.criticalSection(); // Method executed when Mutex is locked by [this] thread

			shared.leavingCriticalSection(id); // Unlocking the Mutex
			System.out.println(name + " is out of critical section"); // [this] Thread has unlocked the mutex
			MutualExclusion.nonCriticalSection(); // Action when Mutex is no longer locked
		}
	}

}

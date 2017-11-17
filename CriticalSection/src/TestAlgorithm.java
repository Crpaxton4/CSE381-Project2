
public class TestAlgorithm {
	
	public static void main(String[] args) {
		// Set up the Mutex
		MutualExclusion alg = new Algorithm_3();

		// Make the threads
		Worker first = new Worker("Running 0", 0, alg);
		Worker second = new Worker("Running 1", 1, alg);

		// Start the Threads
		first.start();
		second.start();
	}
	
}

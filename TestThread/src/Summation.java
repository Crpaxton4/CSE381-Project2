
public class Summation implements Runnable { // This object can be a thread

	private int upper;
	private Sum sumValue; // Simple data class

	public Summation(int upper, Sum sumValue) {
		this.upper = upper;
		this.sumValue = sumValue;
	}

	public void run() { 
		// Threads "main" function. 
		// Calculates the sum of all numbers less than or equal to upper
		int sum = 0;
		
		for (int i = 0; i <= upper; i++) {
			sum += i;
		}
		
		sumValue.setSum(sum);
	}
}

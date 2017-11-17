
public class Driver {

	public static void main(String[] args) {
		if (args.length > 0) { // Make sure there is actually cmd line input
			
			if (Integer.parseInt(args[0]) < 0) { // Make sure that the input number is workable
				
				System.err.println(args[0] + " must be >= 0");
				
			} else {
				
				Sum sumObject = new Sum();
				
				int upper = Integer.parseInt(args[0]); // Read in the input
				
				Thread thrd = new Thread(new Summation(upper, sumObject)); // Create the thread (duh)
				thrd.start(); // Start the thread (duh)
				
				try {
					
					thrd.join(); // Joins the thread back with the main thread
					System.out.println("The sum of " + upper + " is " + sumObject.getSum()); // Print the sum calculated by the thread
					
				} catch (InterruptedException ie) {
					
				}
			}
		} else {
			System.err.println("Usage: Summation <integer value>");
		}
	}

}

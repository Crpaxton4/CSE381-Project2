import java.applet.*;
import java.awt.*;

public class ClockApplet extends Applet implements Runnable {

	private Thread clockThread;

	public void run() {

		while (true) {
			try {
				Thread.sleep(1000); // Sleep for a second

			} catch (InterruptedException e) {

			}

			repaint();
		}
		
		// Every 1 second the thread repaints the Applet
	}

	public void start() {
		if (clockThread == null) {
			clockThread = new Thread(this);
			clockThread.start();
			
		} else {
			clockThread.resume();
			// If stop was called then resume execution
		}
		
		// Just creating the thread
	}

	public void stop() {
		if (clockThread != null) {
			clockThread.suspend();
		}
		
		// Stops execution
	}

	public void destroy() {
		if (clockThread != null) {
			clockThread.stop();
			clockThread = null;
			
		}
		
		// Cleans up the thread
	}

	public void paint(Graphics g) {
		g.drawString(new java.util.Date().toString(), 10, 30);
		
		// Applet Paint Function
	}
}

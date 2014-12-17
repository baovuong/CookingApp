package csc454.cookingapp.gear;

public class CookingTimer {
	private static long timerStart; // When the timer should start from or
									// resume from
	private static boolean paused; // Whether or not the timer is paused
	private static boolean running; // Whether or not the timer is running

	/**
	 * EXAMPLE USAGE public static void main(String[] args) { int hr = 0; int
	 * min = 1; int sec = 0;
	 * 
	 * long timer = (hr * 60 * 60 * 1000) + (min * 60 * 1000) + (sec * 1000);
	 * startTimer(timer);
	 * 
	 * }
	 */

	/**
	 * Method to start the timer
	 * 
	 * @param timerLength
	 *            - long, must be in milliseconds
	 */
	public static void startTimer(long timerLength) {
		timerStart = System.currentTimeMillis();
		paused = false;
		running = true;

		while ((System.currentTimeMillis() < (timerStart + timerLength))
				&& paused == false) {

		}

		running = false;
		System.out.println("DONE");

	}

	/**
	 * Method used to stop/pause the timer
	 */
	public void stopTimer() {
		if (running) {
			paused = true;
		}
	}

	/**
	 * Method used to resume the timer
	 */
	public void resumeTimer() {
		timerStart = System.currentTimeMillis();
		paused = false;
	}

}

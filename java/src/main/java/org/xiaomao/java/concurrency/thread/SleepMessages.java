package org.xiaomao.java.concurrency.thread;

public class SleepMessages {

	public static void main(String args[]) {
		String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy",
				"A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
			// Pause for 4 seconds
			try {
				Thread.sleep(4000);
				Thread.currentThread().join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Print a message
			System.out.println(importantInfo[i]);
		}

		for (int i = 0; i < importantInfo.length; i++) {
			if (Thread.interrupted()) {
				System.out.println("Current Thread is interrupted!");
				return;
			}
			// Interrupt this thread
			Thread.currentThread().interrupt();
			// Print a message
			System.out.println(importantInfo[i]);
		}
	}

}

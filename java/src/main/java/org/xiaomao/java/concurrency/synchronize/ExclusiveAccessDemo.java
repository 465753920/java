package org.xiaomao.java.concurrency.synchronize;

public class ExclusiveAccessDemo {
	
	private static Integer i = 1;

	public void count5_1() {
		synchronized (i) {
			int i = 5;
			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void count5_2() {
		synchronized (this) {
			int i = 5;

			while (i-- > 0) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		final ExclusiveAccessDemo obj = new ExclusiveAccessDemo();

		Runnable r1 = new Runnable() {
			public void run() {
				obj.count5_1();
			}
		};

		Runnable r2 = new Runnable() {
			public void run() {
				obj.count5_2();
			}
		};

		Thread t1 = new Thread(r1, "Thread_1");
		Thread t2 = new Thread(r2, "Thread_2");

		t1.start();
		t2.start();
	}

}

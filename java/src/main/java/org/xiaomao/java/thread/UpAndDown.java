package org.xiaomao.java.thread;

public class UpAndDown {

	private int balance = 0;
	
	public static void main(String[] args) {
		UpAndDown uad = new UpAndDown();
		uad.goThroughLife();
		System.out.println(Thread.currentThread().getName());
	}

	public void goThroughLife() {

		Thread t1 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				add();
			}
		}, "MyThread-1");

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				System.out.println(Thread.currentThread().getName());
				add();
			}
		}, "MyThread-2");

		t1.start();
		t2.start();
	}

	public void add() {
		this.balance++;
	}

	public void subtract() {
		this.balance--;
	}

}

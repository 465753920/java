package org.xiaomao.java.eNum;

import org.junit.Test;

public class Main {

	public static void main(String[] args) {

		System.out.println(Suit.CLUBS.name());
		System.out.println(Suit.valueOf(Suit.CLUBS.name()));

		for (Day d : Day.values()) {
			System.out.println(d.ordinal());
			// System.out.println(d.hashCode());
		}

	}

	@Test
	public void test1() {
		for (Suit s : Suit.values()) {
			//System.out.println(s.name()+": "+s.name);
			//System.out.println(s);
		}
	}

}

package org.xiaomao.java.eNum;

public enum Suit {
	CLUBS("CLUB"), DIAMONDS("DIAMONDS"), HEARTS("HEARTS"), SPADES("SPADES");

	String name;

	Suit(String name) {
		System.out.println(this.name);// 会输出null，因为this.name还未被赋值
		this.name = name;
	}

	public String toString() {
		return name;
	}

}

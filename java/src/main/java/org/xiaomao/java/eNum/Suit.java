package org.xiaomao.java.eNum;

public enum Suit {
	CLUBS("CLUB"), DIAMONDS("DIAMONDS"), HEARTS("HEARTS"), SPADES("SPADES");

	String name;

	Suit(String name) {
		System.out.println(this.name);// �����null����Ϊthis.name��δ����ֵ
		this.name = name;
	}

	public String toString() {
		return name;
	}

}

package org.xiaomao.java.inheritance;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		InstrumentedHashSet<String> hashSet = new InstrumentedHashSet<String>();
		hashSet.addAll(Arrays.asList("xiaoming", "xiaohong", "xiaomei"));
		System.out.println(hashSet.getAddCount());

	}

}

package org.xiaomao.java.inheritance.composition;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {

		InstrumentedSet<String> instrumentedSet = new InstrumentedSet<String>(new HashSet<String>());
		instrumentedSet.addAll(Arrays.asList("xiaoming", "xiaohong", "xiaolan"));
		System.out.println(instrumentedSet.getAddCount());

	}

}

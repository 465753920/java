package org.xiaomao.java;

import java.text.DecimalFormat;

import org.junit.Test;

public class TestProgram {

	/**
	 * decimal string
	 */
	@Test
	public void test1() {
		String str1 = "123.0";
		String str2 = "123.00";
		String str3 = "23.0";

		Float f1 = Float.parseFloat(str1);
		Float f2 = Float.parseFloat(str2);
		Float f3 = Float.parseFloat(str3);

		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
	}

	/**
	 * DecimalFormat
	 */
	@Test
	public void test2() {
		DecimalFormat df = new DecimalFormat("##.##");
		System.out.println(df.format(10.1));
		System.out.println(df.format(100.1));
		System.out.println(df.format(1.01));
		System.out.println(df.format(1.101));
	}

}

package org.xiaomao.java.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTest {
	@Test
	public void test() {
		// String to be scanned to find the pattern.
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}
	}

	@Test
	public void test2(){
		String REGEX = "a*b";
		String INPUT = "aabfooaabfooabfoob";
		String REPLACE = "-";

		Pattern p = Pattern.compile(REGEX);

		// get a matcher object
		Matcher m = p.matcher(INPUT);
		StringBuffer sb = new StringBuffer("hello");
		while(m.find()) {
			m.appendReplacement(sb, REPLACE);
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}

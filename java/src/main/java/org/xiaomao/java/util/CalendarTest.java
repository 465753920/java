package org.xiaomao.java.util;

import java.util.Calendar;

import org.junit.Test;

public class CalendarTest {

	/**
	 * ȥ��Calendar�е�time��Ϣ
	 */
	@Test
	public void test1() {
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		System.out.println(c.getTime());
	}

}

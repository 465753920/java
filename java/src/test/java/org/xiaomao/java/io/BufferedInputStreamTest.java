package org.xiaomao.java.io;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.junit.Test;

public class BufferedInputStreamTest {

	@Test
	public void test1() {
		BufferedInputStream bufIn = new BufferedInputStream(System.in, 5);
		try {
			int c;
			char hook = '2';
			while ((c = bufIn.read()) != -1) {
				System.out.println(c);
				if(hook == c)
					bufIn.mark(100);
			}
			bufIn.reset();
			while ((c = bufIn.read()) != -1) {
				System.out.println(c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

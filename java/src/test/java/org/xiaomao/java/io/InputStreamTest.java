package org.xiaomao.java.io;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class InputStreamTest {

	@Test
	public void test1() {
		try {
			InputStream in = System.in;
			char hook = '2';
			int i;
			while ((i = in.read()) != -1) {
				System.out.println(i);
				if (i == hook) {
					in.mark(1);
				}
			}
			System.out.println("End of first output.");
			in.reset();
			while ((i = in.read()) != -1) {
				System.out.println(i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

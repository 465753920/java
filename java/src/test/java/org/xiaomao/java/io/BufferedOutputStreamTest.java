package org.xiaomao.java.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class BufferedOutputStreamTest {

	@Test
	public void test1() {
		try {
			BufferedOutputStream bufout = new BufferedOutputStream(System.out, 5);
			for (int i = 0; i < 12; i++) {
				bufout.write(i + 97);
				if (i == 2)
					bufout.flush();
			}
			bufout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

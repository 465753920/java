package org.xiaomao.java.io;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedOutputStreamTest {

	@Test
	public void test1() {
		try {
			BufferedOutputStream bout = new BufferedOutputStream(System.out, 5);
			for (int i = 0; i < 12; i++) {
				bout.write(i + 97);
			}
			bout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

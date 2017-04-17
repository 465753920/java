package org.xiaomao.java.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Test;

public class ByteArrayOutputStreamTest {

	@Test
	public void test1(){
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		byteOut.write(48);
		try {
			byteOut.writeTo(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

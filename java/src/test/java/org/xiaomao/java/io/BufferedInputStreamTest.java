package org.xiaomao.java.io;

import java.io.BufferedInputStream;
import java.io.IOException;

import org.junit.Test;

public class BufferedInputStreamTest {

	/**
	 * 测试BufferedInputStream.mark(int readlimit)和BufferedInputStream.reset()方法
	 */
	@Test
	public void test1() {
		BufferedInputStream bufIn = new BufferedInputStream(System.in, 5);
		try {
			int c;
			char hook = '2';
			while ((c = bufIn.read()) != -1) {
				System.out.println(c);
				if (hook == c)
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

	/**
	 * 测试read()方法
	 */
	@Test
	public void test2() {
		BufferedInputStream bufIn = new BufferedInputStream(System.in, 5);
		byte[] bytes = new byte[10];
		try {
			bufIn.read(bytes, 0, bytes.length);
			for(byte b : bytes){
				System.out.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

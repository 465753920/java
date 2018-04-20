package org.xiaomao.java.io;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class InputStreamTest {

	/**
	 * InputStream.mark(int readlimit) 方法的readlimit参数 
	 */
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
	
	/**
	 * 测试read()方法
	 */
	@Test
	public void test2() {
		InputStream in = System.in;
		byte[] bytes = new byte[10];
		try {
			in.read(bytes, 0, bytes.length);
			for(byte b : bytes){
				System.out.println(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

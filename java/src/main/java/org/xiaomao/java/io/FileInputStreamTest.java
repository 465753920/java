package org.xiaomao.java.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {
	@Test
	public void test() {
		try {
			FileInputStream fin = new FileInputStream("file1.txt");
			byte[] bytes = new byte[fin.available()];
			fin.read(bytes);
			System.out.println(new String(bytes,"utf-8"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

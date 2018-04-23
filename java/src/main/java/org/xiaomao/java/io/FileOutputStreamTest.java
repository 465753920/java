package org.xiaomao.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
	@Test
	public void test() {
		try {
			FileOutputStream fout = new FileOutputStream("file1.txt");
			fout.write(65);
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		try {
			FileOutputStream fout = new FileOutputStream("file1.txt");
			fout.write("大家好".getBytes(),0,"大家好".getBytes().length);
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

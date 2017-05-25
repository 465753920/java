package org.xiaomao.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class GetStaticFields {

	public static void main(String[] args) {

		GetStaticFields gsf = new GetStaticFields();
		gsf.getStaticFields(Clazz.class);

	}

	public void getStaticFields(Class<?> clazz) {
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Class<?> c : clazz.getClasses()) {
			System.out.println(c.getName());
		}
		for (Field field : declaredFields) {
			if (Modifier.isStatic(field.getModifiers())) {
				System.out.println(field.getName());
			}
		}
	}

}

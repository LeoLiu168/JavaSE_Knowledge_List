package org.leo.demo.reflection;

import java.lang.reflect.Field;

public class FieldTest {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Person p = new Person();
		Class<Person> personClass = Person.class;
		Field nameField = personClass.getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(p, "Leo Liu");
		Field ageField = personClass.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(p, 18);
		System.out.println(p);
	}

}

class Person{
	private String name;
	private int age;
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
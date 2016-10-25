package com.elsevier.education;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * can run with gradlew clean build; java -cp build/classes/main
 * com.elsevier.education.Exercise3
 * 
 * TODO We should be able to call people.add() twice but end with only one
 * object in it.
 * 
 * SaiTej:
 * 
 * Each and every time we add a new object to Set, it generates a new hashcode because of using
 * random generator. So with the code changes as below, we can restrict that.
 * 
 * But generally whatever the values we use for hashcode generation should be used for the equals()
 * method implementation also. If we create a new object with same value like p2 with id as 1, again we will get the
 * size as 2, which should be 1.
 * 
 * For that equals() method should be like below..
 * 
 * public boolean equals(Object other) {

			Integer i1 = (Integer) (id * generator.nextInt());
			Person p = (Person) other;
			Integer i2 = (Integer) (p.id * generator.nextInt());

			return i1.equals(i2);
		}
 * 
 */
public class Exercise3 {

	public static void main(String[] args) {

		Set<Person> people = new HashSet<>();

		Person p1 = new Person(1);
		people.add(p1);
		people.add(p1);

		System.out.println(people.size());

	}

	public static class Person {

		private static Random generator = new java.util.Random();
		private Integer id;
		private Integer nextInt = generator.nextInt();

		public Person(int newId) {
			id = newId;
		}

		public int hashCode() {
			return id * nextInt;
		}

		public boolean equals(Object other) {
			return id.equals(((Person)other).id);
		}
	}
}
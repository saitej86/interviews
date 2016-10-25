package com.elsevier.education;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * TODO: Make this class immutable.
 * 
 * SaiTej:
 * 	Removed all the setter methods. But somehow we should have a way to provide the values during object creation, so provided a new constructor 
 *  and has done deep copy of all the Phone Numbers as part of the constructor code.
 *  
 *  Also, getPhoneNumbers returns an unmodifiable set in-order to prevent adding new entries to the set.
 * 
 */
public class Exercise1 {

	public final static class Person {

		private Set<String> phoneNumbers;
		private String firstName;
		private String lastName;

		public Person() {
		}

		public Person(String fname, String lname, Set<String> numbers) {
			this.firstName = fname;
			this.lastName = lname;

			phoneNumbers = new HashSet<String>();
			for (String number : numbers) {
				phoneNumbers.add(new String(number));
			}
		}

		public Set<String> getPhoneNumbers() {
			return Collections.unmodifiableSet(phoneNumbers);
		}

		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

	}

	public static void main(String[] s) {
		Set<String> s1 = new HashSet<String>();

		s1.add("123");

		Person p = new Person("abc", "xyz", s1);

		s1.add("234");

		System.out.println(p.getPhoneNumbers().size());

	}
}
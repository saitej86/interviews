package com.elsevier.education;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * TODO Is Counter thread-safe? If so, why, and if not, how can we fix it?
 * 
 * No Counter is not thread-safe. We can make it thread-safe by using AtomicInteger.
 * This class was introduced as part of JDK 1.7 and int values can be updated atomically.
 *  
 * 
 */
public class Exercise4 {

	public static class Counter {

		private AtomicInteger count = new AtomicInteger(0);

		public int increment() {
			return count.incrementAndGet();
		}

		public int getCount() {
			return count.get();
		}

		public void resetCount() {
			count.set(0);
		}

	}
}
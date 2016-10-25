package com.elsevier.education;

/**
 * 
 * TODO: Turn the "Singleton" class into an actual singleton. The main() method
 * should still call .doSomething().
 * 
 * SaiTej: Implemented Singleton design pattern using double checked locking.
 * 
 */
public class Exercise5 {

	public static class Singleton {

		private static volatile Singleton instance = null;

		public void doSomeThing() {
			System.out.println("Doing something....");
		}

		public static Singleton getInstance() {

			if (null == instance) {
				synchronized (Singleton.class) {
					if (null == instance) {
						instance = new Singleton();
					}
				}

			}

			return instance;
		}
	}

	public static void main(String a[]) {
		Singleton st = Singleton.getInstance();
		st.doSomeThing();
	}
}
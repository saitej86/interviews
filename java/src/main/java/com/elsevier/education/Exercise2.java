package com.elsevier.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 
 * TODO refactor the Car to use dependency injection of the engine TODO allow
 * use of either a gas engine or electric engine. TODO make sure we have no-op
 * implementations of both engines.
 * 
 * SaiTej:
 * 
 * Here we have Engine super class and gets extended by both GasEngine and ElectricEngine
 * We can use @Autowired to inject it to Car and based on the qualifier value we can inject
 * either GasEngine or ElectricEngine.
 * 
 */
public class Exercise2 {

	public static class Car {

		@Autowired
		@Qualifier("gasEngine")
		private Engine engine;

		public Car() {
		}

		public void moveForward() {
			engine.spinWheels();
		}
	}

	@Component
	public static class Engine {
		public void spinWheels() {
			
		}
	}

	@Component("gasEngine")
	public static class GasEngine extends Engine {
		public void spinWheels() {
			super.spinWheels();
			System.out.println("Gas Engine spin wheels");
		}
	}

	@Component("electricEngine")
	public static class ElectricEngine extends Engine {
		public void spinWheels() {
			super.spinWheels();
			System.out.println("Electric Engine spin wheels");
		}
	}
}

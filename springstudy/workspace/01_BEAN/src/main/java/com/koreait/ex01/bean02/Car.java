package com.koreait.ex01.bean02;

public class Car {

	// field
	private String model;
	private Engine engine;
	
	// constructor
	public Car() {
		
	}
	public Car(String model, Engine engine) {
		super();
		this.model = model;
		this.engine = engine;
	}
	
	// getter/setter
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
}

package com.jspiders.builderpattern.object;

public class Mobile {
	
	private String brand;
	private String model;
	private int ram;
	private int memory;
	private int front_cam;
	private int rear_cam;
	private double price;
	private int battery;
	private String color;
	private double processor;
	
	public Mobile(String brand, String model, int ram,
			int memory, int front_cam, int rear_cam,
			double price,int battery, String color,
			double processor) {
		super();
		this.brand = brand;
		this.model = model;
		this.ram = ram;
		this.memory = memory;
		this.front_cam = front_cam;
		this.rear_cam = rear_cam;
		this.price = price;
		this.battery = battery;
		this.color = color;
		this.processor = processor;
	}

	@Override
	public String toString() {
		return "=====Mobile=====\n"
				+ "Brand : " + this.brand + "\n"
				+ "Model : " + this.model + "\n"
				+ "Ram : " + this.ram + "\n"
				+ "Memory : " + this.memory + "\n"
				+ "Front Camera : " + this.front_cam + "\n"
				+ "Rear Camera : " + this.rear_cam + "\n"
				+ "Price : " + this.price + "\n"
				+ "Battery : " + this.battery + "\n"
				+ "Color : " + this.color + "\n"
				+ "Processor : " + this.processor;
	}
	
	
	
	

}

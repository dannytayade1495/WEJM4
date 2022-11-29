package com.jspiders.builderpattern.builder;

import com.jspiders.builderpattern.object.Mobile;

public class MobileBuilder {
	
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
	
	public MobileBuilder brand(String brand) {
		this.brand = brand;
		return this;
	}
	
	public MobileBuilder model(String model) {
		this.model = model;
		return this;
	}
	
	public MobileBuilder ram(int ram) {
		this.ram = ram;
		return this;
	}
	
	public MobileBuilder memory(int memory) {
		this.memory = memory;
		return this;
	}
	
	public MobileBuilder front_cam(int front_cam) {
		this.front_cam = front_cam;
		return this;
	}
	
	public MobileBuilder rear_cam(int rear_cam) {
		this.rear_cam = rear_cam;
		return this;
	}
	
	public MobileBuilder price(double price) {
		this.price = price;
		return this;
	}
	
	public MobileBuilder battery(int battery) {
		this.battery = battery;
		return this;
	}
	
	public MobileBuilder color(String color) {
		this.color = color;
		return this;
	}
	
	public MobileBuilder processor(double processor) {
		this.processor = processor;
		return this;
	}
	
	public Mobile getMobile() {
		Mobile mobile = new Mobile(this.brand, this.model, 
				this.ram, this.memory, this.front_cam, 
				this.rear_cam, this.price, this.battery, 
				this.color, this.processor);
		return mobile;
	}
}

package com.skilldistillery.jet;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	private String type;
	

	public Jet() {
	}
	public Jet(String model, double speed, int range, long price, String type) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.type = type;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getSpeed() {
		return speed;
	}
	@Override
	public String toString() {
		return "model: " + model + ", speed: " + speed + "MPH, range: " + range + ", price: " + price
				+ ",  type: "+type;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
//	public double getMach(double mach) {
//		mach = speed/761;
//		return mach;
//	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	
	
	

}

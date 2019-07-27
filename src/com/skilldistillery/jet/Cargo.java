package com.skilldistillery.jet;

import java.util.Scanner;

public class Cargo extends Jet implements TrashHauler {

//	

	public Cargo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cargo(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
		// TODO Auto-generated constructor stub
	}

	public Cargo(double mach) {
		super(mach);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadCargo() {
		System.out.println("You gonna stand there with your hands\n"
				+ "in your pockets or do something?");
	}

	@Override
	public void tieDown() {
		System.out.println("You're sure everythings strapped down?");

	}

	@Override
	public void jump() {
		System.out.println("Jumpers hit it... Airborne!");
	}

}


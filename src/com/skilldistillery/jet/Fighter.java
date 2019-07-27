package com.skilldistillery.jet;

public class Fighter extends Jet implements Combat {

	public Fighter() {}

	public Fighter(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fight() {
		System.out.println("Gun primed, missles armed, checking six.");
		
	}

	@Override
	public void maneuver() {
		System.out.println("Buzzing tower.");
		
	}
	
	
}

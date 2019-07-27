package com.skilldistillery.jet;

import java.util.*;
import java.io.*;

public class Airfield {

	String file = "jets.txt";
	List<Jet> allJets;

	public Airfield() {
		allJets = new ArrayList<Jet>();
		getJets(file);
	} 

	private List<Jet> getJets(String file) {
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				Jet currentJet = null;
				String[] jetList = line.split(", ");
				String model = jetList[0];
				double speed = Double.parseDouble(jetList[1]);
//				double mach = Double.parseDouble(jetList[2]);
				int range = Integer.parseInt(jetList[2]);
				long price = Long.parseLong(jetList[3]);
				String type = jetList[4];
				if (type.equalsIgnoreCase("cargo")) {
					currentJet = new Cargo(model, speed, range, price, type);
				}
				if (type.equalsIgnoreCase("fighter")) {
					currentJet = new Fighter(model, speed, range, price, type);
				}
				if (type.equalsIgnoreCase("civilian")) {
					currentJet = new Civilian(model, speed, range, price, type);
				}
				allJets.add(currentJet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	} // LIST GETJETS

	public void printAllJets() {
		for (Jet jet : allJets) {
			System.out.println(jet);
		}
	}

	public void airTime() {
		double airtime;
		for (Jet jet : allJets) {
			String model = jet.getModel();
			double speed = jet.getSpeed();
			int range = jet.getRange();
			airtime = range/speed;
			System.out.print(model + ": ");
			System.out.printf("%.2f" , airtime);
			System.out.println(" hours");
		}
		System.out.println();
	} //AIRTIME

	public void whosFastest() {
		Jet fastJ = null;
		double fastest = 0;
		for (Jet jet : allJets) {
			if (fastest < jet.getSpeed()) {
				fastest = jet.getSpeed();
				fastJ = jet;
			}
		}
		// fix getMach
		System.out.println(fastJ.getModel() + " is the fastest at " + fastest + "mph");
	} //FASTEST

	public void whosLongest() {
		Jet longRangeJet = null;
		int range = 0;

		for (Jet jet : allJets) {
			if (range < jet.getRange()) {
				range = jet.getRange();
				longRangeJet = jet;
			}
		}
		System.out.println(longRangeJet.getModel()+" has the greatest range at "+range+"miles.\n");
	} //LONGEST
	
	public void loadCargo() {
		for (Jet jet : allJets) {
			String type = jet.getType();
			if(type.equalsIgnoreCase("cargo")) {
				System.out.println(jet.getModel()+": ");
			} if (jet instanceof TrashHauler) {
				((TrashHauler) jet).loadCargo();
				((TrashHauler) jet).tieDown();
			}
		}
	} //LOADCARGO
	public void dogFight() {
		for (Jet jet : allJets) {
			String type = jet.getType();
			if(type.equalsIgnoreCase("fighter")) {
				System.out.println(jet.getModel()+": ");
			}
			if (jet instanceof Fighter) {
				((Fighter) jet).fight();
				((Fighter) jet).maneuver();
			}
		}
	}// DOGFIGHT
	
	public void addJet (Scanner kb) {
		Jet newJ = null;
		System.out.println("\nEnter the aircraft you would like to add: ");
		String model = kb.next();
		System.out.println("Speed (no units): ");
		double speed = kb.nextDouble();
		System.out.println("Range (no decimals or units): ");
		int range = kb.nextInt();
		System.out.println("Price in USD: $");
		long price = kb.nextLong();
		System.out.println("Enter type \"cargo\" \"fighter\" or \"jet\" ");
		String type = kb.next();
		newJ = new JetImpl(model, speed, range, price, type);
		allJets.add(newJ);
		System.out.println("New fleet: ");
		printAllJets();
	}
	public void retireJet(Scanner kb) {
		System.out.println("Select an aircraft to retire, notice\n"
				+ "you cannot remove aircraft from an empty\n"
				+ "inventory. Select a number: ");
		for (int index = 0; index < allJets.size(); index++ ) {
			System.out.println((index + 1) + " "+ allJets.get(index).getModel());
		}
		int choice = kb.nextInt();
		allJets.remove(choice - 1);
		System.out.println("New fleet status: ");
		printAllJets();
		
	}
} // CLASS

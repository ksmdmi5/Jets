package com.skilldistillery.jet;

import java.util.*;
import java.io.*;

public class Airfield {

	String file = "jets.txt";
	List<Jet> allJets;
	Scanner kb = new Scanner(System.in);
	

	public Airfield() {
		allJets = new ArrayList<Jet>();
		getJets(file);
	}

	public void fly() throws InterruptedException {
		boolean menu = true;
		int choice = 0;
		System.out.println("Airfield Main Menu");
		while (menu = true) {
			Thread.sleep(500);
			System.out.println("1: List Fleet");
			Thread.sleep(500);
			System.out.println("2: Fly All Jets");
			Thread.sleep(500);
			System.out.println("3: View Fastest Jet");
			Thread.sleep(500);
			System.out.println("4: Jet with Looooong Range");
			Thread.sleep(500);
			System.out.println("5: Load All Cargo JetsS");
			Thread.sleep(500);
			System.out.println("6: Dogfight");
			Thread.sleep(500);
			System.out.println("7: Add to Fleet");
			Thread.sleep(500);
			System.out.println("8: Retire from Fleet");
			Thread.sleep(500);
			System.out.println("9: Quit");
			Thread.sleep(500);
			System.out.println("Select an option: ");
			choice = kb.nextInt();

			switch (choice) {
			case 1:
				printAllJets();
				System.out.println();
				break;
			case 2:
				System.out.println("\nInto the Wild Blue Yonder.");
				airTime();
				break;
			case 3:
				whosFastest();
				break;
			case 4:
				whosLongest();
				break;
			case 5:
				loadCargo();
				break;
			case 6:
				dogFight();
				break;
			case 7:
				addJet(kb);
				break;
			case 8:
				retireJet(kb);
				break;
			case 9:
				System.out.println("Goodbye.");
				menu = false;
				kb.close();
				break;
//				System.exit(0);
			default:
				System.out.println("Sure hope you fly better\n" + "than you type.");
			}
			break;
		}
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

	public void printAllJets() throws InterruptedException {
		for (Jet jet : allJets) {
			System.out.println(jet);
			Thread.sleep(500);
		}
		System.out.println("Continue (Y/N)?");
		String cont = kb.next();
		if (cont.equalsIgnoreCase("y")) {
			printAllJets();
		} else if (cont.equalsIgnoreCase("n")) {
			fly();
		}
	}

	public void airTime() throws InterruptedException {
		double airtime;
		for (Jet jet : allJets) {
			String model = jet.getModel();
			double speed = jet.getSpeed();
			int range = jet.getRange();
			airtime = range / speed;
			Thread.sleep(500);
			System.out.print(model + ": ");
			System.out.printf("%.2f", airtime);
			System.out.println(" hours");
		}
		System.out.println("Continue (Y/N)");
		String cont = kb.next();
		if (cont.equalsIgnoreCase("y")) {
			airTime();
		} else if (cont.equalsIgnoreCase("n")) {
			fly();
		}
		System.out.println();
	} // AIRTIME

	public void whosFastest() throws InterruptedException {
		Jet fastJ = null;
		double fastest = 0;
		for (Jet jet : allJets) {
			if (fastest < jet.getSpeed()) {
				fastest = jet.getSpeed();
				fastJ = jet;
			}
		}
		System.out.println(fastJ.getModel() + " is the fastest at " + fastest + "mph");
		System.out.println("Continue (Y/N)");
		String cont = kb.next();
		if (cont.equalsIgnoreCase("y")) {
			whosFastest();
		} else if (cont.equalsIgnoreCase("n")) {
			fly();
		}
	} // FASTEST

	public void whosLongest() throws InterruptedException {
		Jet longRangeJet = null;
		int range = 0;

		for (Jet jet : allJets) {
			if (range < jet.getRange()) {
				range = jet.getRange();
				longRangeJet = jet;
			}
		}
		System.out.println(longRangeJet.getModel() + " has the greatest range at " + range + "miles.\n");
		System.out.println("Continue (Y/N)");
		String cont = kb.next();
		if (cont.equalsIgnoreCase("y")) {
			whosLongest();
		} else if (cont.equalsIgnoreCase("n")) {
			fly();
		}
	} // LONGEST

	public void loadCargo() throws InterruptedException {
		for (Jet jet : allJets) {
			String type = jet.getType();
			if(type.equalsIgnoreCase("cargo")) {
				System.out.println(jet.getModel()+": ");
			} if (jet instanceof TrashHauler) {
				((TrashHauler) jet).loadCargo();
				((TrashHauler) jet).tieDown();
			}
		} fly();
	} //LOADCARGO
	public void dogFight() throws InterruptedException {
		for (Jet jet : allJets) {
			String type = jet.getType();
			if(type.equalsIgnoreCase("fighter")) {
				System.out.println(jet.getModel()+": ");
			}
			if (jet instanceof Fighter) {
				((Fighter) jet).fight();
				((Fighter) jet).maneuver();
				System.out.println();
			}
		} fly();
	}// DOGFIGHT

	public void addJet(Scanner kb) throws InterruptedException {
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

	public void retireJet(Scanner kb) throws InterruptedException {
		System.out.println("Select an aircraft to retire, notice\n" + "you cannot remove aircraft from an empty\n"
				+ "inventory. Select a number: ");
		for (int index = 0; index < allJets.size(); index++) {
			System.out.println((index + 1) + " " + allJets.get(index).getModel());
		}
		int choice = kb.nextInt();
		allJets.remove(choice - 1);
		System.out.println("New fleet status: ");
		printAllJets();

	}
} // CLASS

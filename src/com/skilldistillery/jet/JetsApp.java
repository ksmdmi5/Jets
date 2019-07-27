package com.skilldistillery.jet;

import java.util.Scanner;

public class JetsApp {

	Scanner kb = new Scanner(System.in);
	Airfield af = new Airfield();
	public static void main(String[] args) {
		JetsApp jApp = new JetsApp();
		jApp.fly();
	}

	public void fly() {
		displayMenu();
	}

	private void displayMenu() {
		boolean menu = true;
		int choice = 0;

		System.out.println("Airfield Main Menu");
		while (menu = true) {
			System.out.println("1: List Fleet\n" + "2: Fly All Jets\n" + "3: View Fastest Jet\n"
					+ "4: Jet with Looooong Range\n" + "5: Load All Cargo Jets\n" + "6: Dogfight\n"
					+ "7: Add to Fleet\n" + "8: Retire from Fleet\n" + "9: Quit\n" + "Select an option: ");
			choice = kb.nextInt();

			switch (choice) {
			case 1:
				af.printAllJets();
				System.out.println();
				break;
			case 2:
//				af.printAllJets();
				System.out.println("\nTo the Wild Blue Yonder.");
				af.airTime();
				break;
			case 3:
				af.whosFastest();
				break;
			case 4:
				af.whosLongest();
				break;
			case 5:
				af.loadCargo();
				break;
			case 6:
				af.dogFight();
				break;
			case 7:
				af.addJet(kb);
				break;
			case 8:
				af.retireJet(kb);
				break;
			case 9:
				menu = false;
				System.out.println("Goodbye.");
				kb.close();
				break;
			default:
				System.out.println("Sure hope you fly better\n" + "than you type.");
			}
			break;
		}

	}

}

package main;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import models.Artifacts;
import models.GoldenArtifacts;
import models.PurpleArtifacts;

public class Main {
Scanner scan = new Scanner (System.in);
Vector <Artifacts> artifacts = new Vector<>();
Random rand = new Random();

	public Main() {
		System.out.println("Key Domain");
		System.out.println("==================");
		int choose = -1;
		do {
		System.out.println("1. Insert artifacts");
		System.out.println("2. View obtainable artifacts");
		System.out.println("3. Grind for artifact");
		System.out.println("4. Exit");
		System.out.print(">>");
		choose = scan.nextInt();
		
		
		switch (choose) {
		case 1:
			insertArtifacts();
			break;
			
		case 2:
			viewArtifacts();
			break;
			
		case 3:
			grindArtifacts();
			break;
			
		default:
			break;
		}
		
		}while (choose != 4);
	}

private void insertArtifacts() {
	int choose;
		do {
		System.out.println("Which Artifact you want to add");
		System.out.println("1. Purple Artifact");
		System.out.println("2. Golden Artifact");
		System.out.print(">>");
		choose = scan.nextInt();
		
		switch (choose) {
		case 1 :
		purpleArt();
			break;

		case 2:
		goldenArt();
			break;
		}
		
		} while (choose <1 || choose > 2);
		
	}

private void purpleArt() {
	String name,type,bonus;
	int attack = 0;
	System.out.println("Add new artifacts!");
	System.out.println("=======================");

	do {
		System.out.print("Input name [5-25] characters] : ");
		name = scan.nextLine();
	} while (name.length() < 5 || name.length() > 25);

	do {
	System.out.print("Input type [Flower | Plume | Sands | Goblet | Circlet] [case sensitive]");
	type = scan.nextLine();
	} while (!type.equals("Flower") && !type.equals("Flume") && !type.equals("Sands") && !type.equals("Goblet") && !type.equals("Circlet") );
	
	if (type.equals("Flower") || type.equals("Plume")) {
		do {
			System.out.print("Input base attack [Flower/Plume = 90-100 | Sands/Goblet/Circlet = 101 - 110] : ");
			attack = scan.nextInt();scan.nextLine();
		} while ((!(attack >90)) || (!(attack < 100)));
	
	}
	
	else if (type.equals("Sands") && type.equals("Goblet") && type.equals("Circlet"))
		do {
			System.out.print("Input base attack [Flower/Plume = 90-100 | Sands/Goblet/Circlet = 101 - 110] : ");
			attack = scan.nextInt();scan.nextLine();
		} while ((!(attack>101)) || (!(attack < 110)));
	
	do {
	System.out.print("Input bonus status [Anemo | Pyro | Hydro | Electro | Cryo][case sensitive] :  ");
	bonus = scan.nextLine();
	} while (!bonus.equals("Anemo") && !bonus.equals("Pyro") && !bonus.equals("Hydro") && !bonus.equals("Electro") && !bonus.equals("Cyro"));
	
	System.out.println("susccesfully inserted !");
	System.out.println("Press enter to continue....");
	
	
	PurpleArtifacts pArt = new PurpleArtifacts(name, type, attack,bonus);
	artifacts.add(pArt);
}


private void goldenArt() {
	String name,type;
	int attack = 0;
	double multiplier;
	System.out.println("Add new artifacts!");
	System.out.println("=======================");
	do {
	System.out.print("Input name [5-25] characters] : ");
	name = scan.nextLine();
	} while (name.length() < 5 || name.length() > 25);
	
	do {
	System.out.print("Input type [Flower | Plume | Sands | Goblet | Circlet] [case sensitive]");
	type = scan.nextLine();
	} while (!type.equals("Flower") && !type.equals("Flume") && !type.equals("Sands") && !type.equals("Goblet") && !type.equals("Circlet") );
	
	if (type.equals("Flower") || type.equals("Plume")) {
		do {
			System.out.print("Input base attack [Flower/Plume = 90-100 | Sands/Goblet/Circlet = 101 - 110] : ");
			attack = scan.nextInt();scan.nextLine();
		} while ((!(attack >90)) || (!(attack < 100)));
	
	}
	
	else if (type.equals("Sands") && type.equals("Goblet") && type.equals("Circlet"))
		do {
			System.out.print("Input base attack [Flower/Plume = 90-100 | Sands/Goblet/Circlet = 101 - 110] : ");
			attack = scan.nextInt();scan.nextLine();
		} while ((!(attack>101)) || (!(attack < 110)));
	
	do {
		System.out.print("Input Multiplier [1.5x - 2.0x] :  ");
		multiplier = scan.nextDouble();scan.nextLine();
	} while (multiplier < 1.5 || multiplier > 2.0);
	
	System.out.println("sucessfully inserted!");
	System.out.println("Press enter to continue....");
	
	GoldenArtifacts gArt = new GoldenArtifacts(name,type,attack,multiplier);
	artifacts.add(gArt);	
}

private void viewArtifacts() {
	if (artifacts.isEmpty()) {
		System.out.println(" No Obtainable artifacts!");
		System.out.println("Press kntl to kontinue");
	}
	else {

		for (int i = 0; i < artifacts.size(); i++) {
			if (artifacts.get(i) instanceof PurpleArtifacts) {
				PurpleArtifacts pArt = (PurpleArtifacts) artifacts.get(i);
				System.out.println("Name :" + pArt.getTitle());
				System.out.println("Type :" + pArt.getType());
				System.out.println("Base Atk :" + pArt.getAttack());
				System.out.println("Bonus Stat :" + pArt.getBonusStatus());
				System.out.println("Multiplier : - ");
				
			} else {
				GoldenArtifacts gArt = (GoldenArtifacts) artifacts.get(i);
					System.out.println("Name :" + gArt.getTitle());
					System.out.println("Type :" + gArt.getType());
					System.out.println("Base Atk :" + gArt.getAttack());
					System.out.println("Bonus Stat : - ");
					System.out.println("Multiplier : " + gArt.getMultiplier());
			}
		}
		
	}
}
private void grindArtifacts() {
	String name;
		if (artifacts.isEmpty()) {
			System.out.println(" No Obtainable artifacts!");
			System.out.println("Press kntl to kontinue");
		}
		
		else {
			System.out.println("List Char");
			System.out.println("Diluc - Xiao - Keqing");
			do {
				System.out.print("Input Choosen Char [Case insensitive]");
				name = scan.nextLine();
			} while (!name.equalsIgnoreCase("Diluc") && !name.equalsIgnoreCase("Xiao") && !name.equalsIgnoreCase("Keqing"));
			
			int random = rand.nextInt(artifacts.size() - 1) + 1 ;
			if (artifacts.get(random - 1 ) instanceof PurpleArtifacts) {
				PurpleArtifacts pArt = (PurpleArtifacts) artifacts.get(random - 1);
				
				System.out.println(name + "Came back and got you a new artifact!");
				System.out.println("Name : " + pArt.getTitle());
				System.out.println("Type : " + pArt.getType());
				System.out.println("Base atk :" + pArt.getAttack());
				System.out.println("Damage" + pArt.damage(pArt.getAttack()));
				System.out.println("Bonus Stat: " + pArt.getBonusStatus());
				artifacts.remove(random - 1);
			}
			
			else {
				GoldenArtifacts gArt = (GoldenArtifacts) artifacts.get(random - 1);
				System.out.println(name + "Came back and got you a new artifact!");
				System.out.println("Name : " + gArt.getTitle());
				System.out.println("Type : " + gArt.getType());
				System.out.println("Base atk :" + gArt.getAttack());
				System.out.println("Damage : " + gArt.damage(gArt.getAttack()) );
				artifacts.remove(random - 1);
			}
		
		
		}
		
	}

public static void main(String[] args) {
	new Main();
}
}


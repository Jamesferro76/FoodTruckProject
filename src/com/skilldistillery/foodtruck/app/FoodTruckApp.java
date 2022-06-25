package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	private FoodTruck[] fleetOfFoodTrucks= new FoodTruck[5];

	public static void main(String[] args) {

		FoodTruckApp app = new FoodTruckApp();
		app.run();

	}

	public void run() {
		Scanner sc = new Scanner(System.in);

		userInput(sc);

		menu(sc);

	}

	public void userInput(Scanner sc) {
		String ftName, ftFood;
		double ftRating;
		boolean trigger = true;
		int FtCounter=1;

		for (int i = 0; i < 5; i++) {

			System.out.println("What is the name for food truck number: "+ (FtCounter++) +"?");
			ftName = sc.nextLine();
			if (ftName.equals("Quit") || ftName.equals("quit")) {
				break;
			}

			System.out.println("What type of food do they sell?");
			ftFood = sc.nextLine();

			do {
				System.out.println("What would you rate them 1-5?");
				ftRating = sc.nextDouble();
				sc.nextLine();
				
				if (ftRating >= 1 && ftRating <= 5) {
					trigger = false;
				} else {
					System.out.println("That was not a readable response");
				}

			} while (trigger);

//			System.out.println(ftName);
//			System.out.println(ftFood);
//			System.out.println(ftRating);
//			System.out.println(i);
//			

			FoodTruck ft = new FoodTruck(ftName, ftFood, ftRating, i);

			fleetOfFoodTrucks[i] = ft;

		}
	}

	public void menu(Scanner sc) {
		boolean trigger = true;

		while (trigger) {
			printMenu();
			int userMenu = sc.nextInt();

			switch (userMenu) {

			case 1:
				display();
				break;
			case 2:
				averageRating();
				break;

			case 3:
				highestRated();
				break;

			case 4:
				System.out.println("Goodbye");
				trigger = false;
				break;
			default:
				System.out.println("That was not a readable response");

			}

		}

	}

	public void printMenu() {
		System.out.println("****************");
		System.out.println("1) List all existing Food Trucks");
		System.out.println("2) See average rating of Food Trucks");
		System.out.println("3) Display the highest rated Food Truck");
		System.out.println("4) Quit");
		System.out.println("****************");

	}

	public void display() {
		for (int i = 0; i < fleetOfFoodTrucks.length; i++) {
			
			if(fleetOfFoodTrucks[i]==null) {
				break;
			}
			String display = fleetOfFoodTrucks[i].toString();
			System.out.println(display);

		}

	}

	public void averageRating() {
		double average = 0;
		int counter=0;
		for (int i = 0; i < fleetOfFoodTrucks.length; i++) {
			if(fleetOfFoodTrucks[i]==null) {
				break;
			}
			average += fleetOfFoodTrucks[i].getFtRating();
			counter++;

		}
		average /= counter;
		System.out.println("The average food truck rating is: " + average);
	}

	public void highestRated() {
		double rating = 0.0;
		String highestFT = "None";
		int counter=0;

		for (int i = 0; i < fleetOfFoodTrucks.length; i++) {
			if(fleetOfFoodTrucks[i]==null) {
				break;
			}
			if (rating < fleetOfFoodTrucks[i].getFtRating()) {
				highestFT = fleetOfFoodTrucks[i].getFtName();
				rating = fleetOfFoodTrucks[i].getFtRating();
				counter=i;
			}else if(rating==fleetOfFoodTrucks[i].getFtRating()) {
				highestFT= highestFT+ " and " + fleetOfFoodTrucks[i].getFtName();
			}
			
		}
		System.out.println("The highest rated Food Truck is: " + highestFT + " with a rating of: " + rating);
		System.out.println(fleetOfFoodTrucks[counter].toString());
	}

}

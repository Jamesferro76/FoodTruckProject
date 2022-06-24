package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	private FoodTruck[] fleetOfFoodTrucks;


	public static void main(String[] args) {
		
		FoodTruckApp app= new FoodTruckApp();
		app.run();

	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		
		userInput(sc);
		
		

	}

	public void userInput(Scanner sc) {
		String ftName, ftFood;
		double ftRating;

		for (int i = 0; i < 5; i++) {

			System.out.println("What is the first foodtruck's name?");
			ftName = sc.nextLine();
			if (ftName.equals("Quit")) {
				break;
			}

			System.out.println("What type of food do they sell?");
			ftFood = sc.nextLine();

			System.out.println("What would you rate them 1-5?");
			ftRating = sc.nextDouble();
			
			sc.nextLine();
			
			FoodTruck ft= new FoodTruck(ftName, ftFood, ftRating,i);
			
			fleetOfFoodTrucks[i]=ft;

		}
	}

}

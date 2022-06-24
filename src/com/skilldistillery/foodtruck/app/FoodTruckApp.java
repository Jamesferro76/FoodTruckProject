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
		
		menu(sc);
		
		

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
	
	public void menu(Scanner sc) {
		boolean trigger=true;
		
		while(trigger) {
		printMenu();
		int userMenu=sc.nextInt();
		
		switch(userMenu) {
		
		case 1:
			display();
			break;
		case 2:
			averageRating();
			break;
			
		case 3:
			highestRated();
			
		case 4:
			System.out.println("Goodbye");
			trigger=false;
		default:
			
		
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
		for(int i=0; i<fleetOfFoodTrucks.length; i++) {
			String display=fleetOfFoodTrucks[i].toString();
			System.out.println(display);
			
		}
		
		
	}
	public void averageRating() {
		double average=0;
		for(int i=0; i<fleetOfFoodTrucks.length; i++) {
			average+=fleetOfFoodTrucks[i].getFtRating();
			
		}
		average/=fleetOfFoodTrucks.length;
		System.out.println("The average food truck rating is: "+average);
	}
	public void highestRated() {
		double rating=0.0;
		String highestFT="None";
		
		for(int i=0; i<fleetOfFoodTrucks.length; i++) {
			if(rating<fleetOfFoodTrucks[i].getFtRating()) {
				highestFT=fleetOfFoodTrucks[i].getFtName();
				rating=fleetOfFoodTrucks[i].getFtRating();
			}
			System.out.println("The highest rated Food Truck is: "+highestFT+ 
					" with a rating of: "+rating);
		}
		
	}
	

}

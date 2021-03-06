package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

//	unique numeric id,
//	a name ("TacoRific", "Mediterranean Medic", etc.),
//	food type ("Tacos", "Falafel", etc.), and a numeric rating.
	
	private String ftName;
	private String ftFood;
	private double ftRating;
	private int id;
	private static int COUNT=0;
	
	public FoodTruck(String ftName, String ftFood, double ftRating) {
//		super();
		this.ftName = ftName;
		this.ftFood = ftFood;
		this.ftRating = ftRating;
		this.COUNT++;
		this.id=COUNT;
	}
	

	public FoodTruck() {
		super();
	}

	public String getFtName() {
		return ftName;
	}

	public void setFtName(String ftName) {
		this.ftName = ftName;
	}

	public String getFtFood() {
		return ftFood;
	}

	public void setFtFood(String ftFood) {
		this.ftFood = ftFood;
	}

	public double getFtRating() {
		return ftRating;
	}

	public void setFtRating(double ftRating) {
		this.ftRating = ftRating;
	}

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}


	@Override
	public String toString() {
//		return "FoodTruck [ftName= " + ftName + ", ftFood= " + ftFood + ", ftRating= " + ftRating + "]";
		return "FoodTruck [ftName= " + ftName + ", ftFood= " + ftFood + ", ftRating= " + ftRating + ", ID= " + id + " ]";
	}
	
	
	
	

}

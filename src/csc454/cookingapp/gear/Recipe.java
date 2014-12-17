package csc454.cookingapp.gear;

import java.sql.Time;

public class Recipe {
	private String name;
	private Ingredient ingreds[];
	private Step steps[];
	private double servings;
	private CookingTimer timer;
	private String notes;
	private Time elapsedTime;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ingredient[] getIngreds() {
		return ingreds;
	}

	public void setIngreds(Ingredient[] ingreds) {
		this.ingreds = ingreds;
	}

	public Step[] getSteps() {
		return steps;
	}

	public void setSteps(Step[] steps) {
		this.steps = steps;
	}

	public double getServings() {
		return servings;
	}

	public void setServings(double servings) {
		this.servings = servings;
	}

	public CookingTimer getTimer() {
		return timer;
	}

	public void setTimer(CookingTimer timer) {
		this.timer = timer;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public void setElapsedTime(Time time) {
		elapsedTime = time;
	}
	
	public Time getElapsedTime() {
		return elapsedTime;
	}
	

}

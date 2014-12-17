package csc454.cookingapp.mechanism;

import java.util.ArrayList;

import csc454.cookingapp.gear.Recipe;
import csc454.cookingapp.geartrain.RecipeDB;
import csc454.cookingapp.indicator.dialog.AlertDialog;

public class RecipeAction {
	
	//public static RecipeDB allRecipes = new RecipeDB();
	public static ArrayList<Recipe> recipeDB = new ArrayList<Recipe>();
	
	public static boolean createRecipe(String name) {
		AlertDialog.displayAlert("Creating recipe: "+name);
		System.out.println("creating recipe: "+name);
		return false;
		
	}
	
	public static boolean deleteRecipe(int id) {
		return false;
	}
	
	public static boolean addRecipe(Recipe newRecipe) {
		recipeDB.add(newRecipe);
		return true;
	}
	
	public static boolean updateRecipe(int id, Recipe newRecipe) {
		return false;
	}
	
	public static String getRecipe(Recipe r) {
		return r.getName();
	}
	
	public static ArrayList<Recipe> getAllRecipes() {
		return recipeDB;
	}
}

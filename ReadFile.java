package Recipe.utils;
import Recipe.classes.*;
import Recipe.main.Main;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFile
{
    private static final String recipeFileName = "recipes.txt";
    private static final String userFileName = "users.txt";

    public static void ReadRecipeFile()
    {
        List<Recipe> recipes = new ArrayList<>();

        String name;
        int numDiners;
        String preparation;
        List<Ingredient> ingredients;
        float calories;
        char difficultyLevel;
        SpecialDiets specialDiet;
        LocalDate publicationDate;
        int preparationTime;
        User author;
        char dishType;

        try (BufferedReader inputFile = new BufferedReader(new FileReader(new File(recipeFileName))))
        {
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] recipeData = line.split(";");

                name = recipeData[0];
                numDiners = Integer.parseInt(recipeData[1]);
                preparation = recipeData[2];
                ingredients = List.of(new Ingredient(recipeData[3], Integer.parseInt(recipeData[4]), recipeData[5]));
                calories = Float.parseFloat(recipeData[6]);
                difficultyLevel = recipeData[7].charAt(0);
                specialDiet = SpecialDiets.valueOf(recipeData[8]);
                publicationDate = LocalDate.parse(recipeData[9]);
                preparationTime = Integer.parseInt(recipeData[10]);
                author = new Author(recipeData[11], Integer.parseInt(recipeData[12]), recipeData[13]);
                dishType = recipeData[14].charAt(0);

                if (dishType == 'A') {
                    Appetizer appetizer;
                    int servingTemperature = Integer.parseInt(recipeData[15]);
                    String culturalOrigin = recipeData[16];
                    appetizer = new Appetizer(name, numDiners, preparation, ingredients, calories,
                            difficultyLevel, specialDiet, publicationDate, preparationTime,
                            author, servingTemperature, culturalOrigin, dishType);
                    recipes.add(appetizer);
                }
                else if(dishType == 'C') {
                    Cocktail cocktail;
                    boolean containAlcohol = Boolean.parseBoolean(recipeData[15]);
                    float alcoholContent = Float.parseFloat(recipeData[16]);
                    boolean flambe = Boolean.parseBoolean(recipeData[17]);
                    cocktail = new Cocktail(name, numDiners, preparation, ingredients, calories,
                            difficultyLevel, specialDiet, publicationDate, preparationTime,
                            author, containAlcohol, alcoholContent, flambe, dishType);
                    recipes.add(cocktail);
                }
                else if(dishType == 'M') {
                    MainCourse mainCourse;
                    String celebrationDish = recipeData[15];
                    String sideDish = recipeData[16];
                    mainCourse = new MainCourse(name, numDiners, preparation, ingredients, calories,
                            difficultyLevel, specialDiet, publicationDate, preparationTime,
                            author, celebrationDish, sideDish, dishType);
                    recipes.add(mainCourse);
                }
                else if(dishType == 'D') {
                    Dessert dessert;
                    boolean baked = Boolean.parseBoolean(recipeData[15]);
                    int restingTime = Integer.parseInt(recipeData[16]);
                    int bakingTime = Integer.parseInt(recipeData[17]);
                    int servingTemperature = Integer.parseInt(recipeData[18]);
                    dessert = new Dessert(name, numDiners, preparation, ingredients, calories,
                            difficultyLevel, specialDiet, publicationDate, preparationTime,
                            author, baked, restingTime, bakingTime, servingTemperature, dishType);

                    recipes.add(dessert);
                }
            }

        } catch (IOException fileError) {
            System.err.println("Error reading file: " + fileError.getMessage());
        }

        System.out.println("Recetas leídas:");
        for (Recipe r : recipes) {
            System.out.println(r.toString());
        }
    }

    public static void ReadUsersFile()
    {
        String name;
        int numRecipes;
        String password;

        try (BufferedReader inputFile = new BufferedReader(new FileReader(new File(userFileName)))) {
            String line;
            while ((line = inputFile.readLine()) != null)
            {
                String[] userData = line.split(";");
                Guest guest;
                name = userData[0];
                guest = new Guest(name);
                if(userData.length == 3)
                {
                    Author author;
                    numRecipes = Integer.parseInt(userData[1]);
                    password = userData[2];

                    author = new Author(name,numRecipes,password);
                }
            }
        } catch (IOException fileError) {
            System.err.println("Error reading file: " + fileError.getMessage());
        }
    }
}

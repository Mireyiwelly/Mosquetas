package Recipe.utils;
import Recipe.classes.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to read recipe and user data from files.
 * It contains methods to read recipes and users from text files.
 */
public class ReadFile
{
    private static final String RECIPEFILENAME = "recipes.txt";
    private static final String USERFILENAME = "users.txt";

    /**
     * Reads the recipe data from a file and returns a list of Recipe objects.
     * @return List of Recipe objects
     */
    public static List<Recipe> ReadRecipeFile() 
    {
        List<Recipe> recipes = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();

        try (BufferedReader inputFile = new BufferedReader(new FileReader(new File(RECIPEFILENAME))))
        {
            String line;
            while ((line = inputFile.readLine()) != null)
            {
                String[] recipeData = line.split(";");

                char dishType = recipeData[0].charAt(0);
                String name = recipeData[1];
                int numDiners = Integer.parseInt(recipeData[2]);
                String preparation = recipeData[3];
                ingredients.add(new Ingredient(recipeData[4], Integer.parseInt(recipeData[5]), recipeData[6]));
                float calories = Float.parseFloat(recipeData[7]);
                char difficultyLevel = recipeData[8].charAt(0);
                SpecialDiets specialDiet = SpecialDiets.valueOf(recipeData[9]);
                LocalDate publicationDate = LocalDate.parse(recipeData[10]);
                int preparationTime = Integer.parseInt(recipeData[11]);
                User author = new Author(recipeData[12], Integer.parseInt(recipeData[13]), recipeData[14]);

                switch (dishType) {
                    case 'A':
                        int servingTemperature = Integer.parseInt(recipeData[15]);
                        String culturalOrigin = recipeData[16];

                        recipes.add(new Appetizer(name, numDiners, preparation, ingredients, calories,
                                difficultyLevel, specialDiet, publicationDate, preparationTime,
                                author, servingTemperature, culturalOrigin, dishType));
                        break;

                    case 'C':
                        boolean containAlcohol = Boolean.parseBoolean(recipeData[15]);
                        float alcoholContent = Float.parseFloat(recipeData[16]);
                        boolean flambe = Boolean.parseBoolean(recipeData[17]);

                        recipes.add(new Cocktail(name, numDiners, preparation, ingredients, calories,
                                difficultyLevel, specialDiet, publicationDate, preparationTime,
                                author, containAlcohol, alcoholContent, flambe, dishType));
                        break;

                    case 'M':
                        String celebrationDish = recipeData[15];
                        String sideDish = recipeData[16];

                        recipes.add(new MainCourse(name, numDiners, preparation, ingredients, calories,
                                difficultyLevel, specialDiet, publicationDate, preparationTime,
                                author, celebrationDish, sideDish, dishType));
                        break;

                    case 'D':
                        boolean baked = Boolean.parseBoolean(recipeData[15]);
                        int restingTime = Integer.parseInt(recipeData[16]);
                        int bakingTime = Integer.parseInt(recipeData[17]);
                        servingTemperature = Integer.parseInt(recipeData[18]);

                        recipes.add(new Dessert(name, numDiners, preparation, ingredients, calories,
                                difficultyLevel, specialDiet, publicationDate, preparationTime,
                                author, baked, restingTime, bakingTime, servingTemperature, dishType));
                        break;

                    default:
                        System.err.println("Unknown dish: " + dishType);
                        break;
                }

            }
        }
        catch (IOException fileError)
        {
            System.err.println("Error reading file: " + fileError.getMessage());
        }

        return recipes;
    }

    public static List<User> ReadUserFile()
    {
        List<User> users = new ArrayList<>();

        try (BufferedReader inputFile = new BufferedReader(new FileReader(new File(USERFILENAME))))
        {
            String line;
            while ((line = inputFile.readLine()) != null)
            {
                String[] userData = line.split(";");

                String name;
                int numRecipes;
                String password;

                char userType = userData[0].charAt(0);;
                name = userData[1];
                switch (userType)
                {
                    case 'A' :
                    {
                        password = userData[2];

                        users.add(new Admin(name, password));
                        break;
                    }
                    case 'G' :
                    {
                        users.add(new Guest(name));
                        break;
                    }
                    case 'T' :
                    {
                        numRecipes = Integer.parseInt(userData[2]);
                        password = userData[3];

                        users.add(new Author(name, numRecipes,password));
                        break;
                    }
                    default:
                        System.err.println("Unknown user: " + userType);
                        break;
                }
            }
        }
        catch (IOException fileError)
        {
            System.err.println("Error reading file: " + fileError.getMessage());
        }
        return users;
    }
}

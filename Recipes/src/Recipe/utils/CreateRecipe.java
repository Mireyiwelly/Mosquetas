package Recipe.utils;
import Recipe.classes.*;
import Recipe.utils.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for creating recipes and adding ingredients.
 */
public class CreateRecipe
{
    /**
     * Adds an ingredient to the recipe.
     *
     * @return the created Ingredient object
     */
    public static Ingredient addIngredient() {
        Scanner sc = new Scanner(System.in);
        String name, unit;
        int quantity;

        /**
         * Ask the user for ingredient details until valid input is provided.
         */
        // Ask the user for the name of the ingredient until valid input is provided.
        System.out.println(" --- INGREDIENTS --- ");
        do
        {
            System.out.println("Enter the name of the ingredient:");
            name = sc.nextLine();
            if(FieldsValidator.isEmpty(name))
            {
                System.out.println("Name cannot be empty");
            }
        }
        while(FieldsValidator.isEmpty(name));
        // Ask the user for the unit of the ingredient until valid input is provided.
        do
        {
            System.out.println("Enter the unit of the ingredient(g - l - ml - kg, cl, pcs):");
            unit = sc.nextLine();
            if(FieldsValidator.isEmpty(unit))
            {
                System.out.println("Unit cannot be empty");
            }
            if(!FieldsValidator.isValidUnit(unit))
            {
                System.out.println("The unit must be g, l, ml, kg, cl, pcs");
            }
        }
        while (FieldsValidator.isEmpty(unit) || !FieldsValidator.isValidUnit(unit));
        // Ask the user for the quantity of the ingredient until valid input is provided.
        do
        {
            System.out.println("Enter the quantity of the ingredient:");

            while(!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Ingredients Quantity has to be a number:");
            }
            quantity = sc.nextInt();

            if(!FieldsValidator.isPositive(quantity))
            {
                System.out.println("Quantity cannot be negative");
            }
        }
        while(!FieldsValidator.isPositive(quantity));

        return new Ingredient(name, quantity, unit);
    }

    /**
     * Creates an appetizer and adds it to the list of recipes.
     *
     * @param recipes the list of recipes
     * @param author the user who created the recipe
     * @param name the name of the recipe
     * @param numDiners the number of diners
     * @param preparation the preparation description
     * @param ingredients the list of ingredients
     * @param calories the number of calories
     * @param difficultyLevel the difficulty level
     * @param specialDiets the special diets
     * @param publicationDate the publication date
     * @param preparationTime the preparation time
     */
    public static void createAppetizer(List<Recipe> recipes, User author, String name, int numDiners,
                                       String preparation, List<Ingredient> ingredients, float calories,
                                       char difficultyLevel, SpecialDiets specialDiets, LocalDate publicationDate, int preparationTime)
    {
        int servingTemperature;
        String culturalOrigin;
        Scanner sc = new Scanner(System.in);
        // Ask the user for the serving temperature until valid input is provided.
        do
        {
            System.out.println("Enter the serving temperature: ");

            while (!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Serving Temperature has to be a number:");
            }
            servingTemperature = sc.nextInt();

            if (!FieldsValidator.isPositive(servingTemperature))
            {
                System.out.println("The serving temperature must be positive.");
            }
        }
        while (!FieldsValidator.isPositive(servingTemperature));
        // Ask the user for the cultural origin until valid input is provided.
        do {
            System.out.print("Enter the cultural origin: ");
            culturalOrigin = sc.nextLine();

            if(FieldsValidator.isEmpty(culturalOrigin)) {
                System.out.println("The cultural origin cannot be empty.");
            }
        }
        while (FieldsValidator.isEmpty(culturalOrigin));
        // Create the Appetizer object and add it to the list of recipes.
        recipes.add(new Appetizer(name, numDiners, preparation, ingredients, calories,
                difficultyLevel, specialDiets, publicationDate, preparationTime,
                author, servingTemperature, culturalOrigin, 'A'));

    }
    /**
     * Creates a cocktail and adds it to the list of recipes.
     *
     * @param recipes the list of recipes
     * @param author the user who created the recipe
     * @param name the name of the recipe
     * @param numDiners the number of diners
     * @param preparation the preparation description
     * @param ingredients the list of ingredients
     * @param calories the number of calories
     * @param difficultyLevel the difficulty level
     * @param specialDiets the special diets
     * @param publicationDate the publication date
     * @param preparationTime the preparation time
     */
    public static void createCocktail(List<Recipe> recipes, User author, String name, int numDiners,
                                      String preparation, List<Ingredient> ingredients, float calories,
                                      char difficultyLevel, SpecialDiets specialDiets, LocalDate publicationDate, int preparationTime)
    {
        Scanner sc = new Scanner(System.in);
        String containAlcoholInput, flambeInput;
        float alcoholContent;
        boolean flambe = false;
        boolean containAlcohol = false;
        // Ask the user for the alcohol content until valid input is provided.
        do
        {
            System.out.print("Does it contain alcohol? Y/N: ");
            containAlcoholInput = sc.nextLine();

            if(FieldsValidator.isEmpty(containAlcoholInput)) {
                System.out.println("The contain alcohol field cannot be empty.");
            }
            if(FieldsValidator.isValidYesNo(containAlcoholInput))
            {
                containAlcohol = containAlcoholInput.equalsIgnoreCase("Y");
            }
            if(!FieldsValidator.isValidYesNo(containAlcoholInput))
            {
                System.out.println("The contain alcohol field must be Y or N.");
            }
        }
        while (FieldsValidator.isEmpty(containAlcoholInput) ||
                !FieldsValidator.isValidYesNo(containAlcoholInput));
        // Ask the user for the alcohol content until valid input is provided.
        do
        {
            System.out.print("Enter the alcohol content: ");
            alcoholContent = sc.nextFloat();

        }
        while(!FieldsValidator.isPositive(alcoholContent));
        // Ask the user for the flambe option until valid input is provided.
        do {
            System.out.print("Is it flambe? Y/N: ");
            flambeInput = sc.nextLine();
            if(FieldsValidator.isEmpty(flambeInput))
            {
                System.out.println("The flambe field cannot be empty.");
            }
            if(FieldsValidator.isValidYesNo(flambeInput))
            {
                flambe = flambeInput.equalsIgnoreCase("Y");
            }
            if (!FieldsValidator.isValidYesNo(flambeInput))
            {
                System.out.println("The flambe field must be Y or N.");
            }
        }
        while(FieldsValidator.isEmpty(flambeInput));

        recipes.add(new Cocktail(name, numDiners, preparation, ingredients, calories,
                difficultyLevel, specialDiets, publicationDate, preparationTime,
                author, containAlcohol, alcoholContent, flambe, 'C'));

    }

    /**
     * Creates a dessert and adds it to the list of recipes.
     *
     * @param recipes the list of recipes
     * @param author the user who created the recipe
     * @param name the name of the recipe
     * @param numDiners the number of diners
     * @param preparation the preparation description
     * @param ingredients the list of ingredients
     * @param calories the number of calories
     * @param difficultyLevel the difficulty level
     * @param specialDiets the special diets
     * @param publicationDate the publication date
     * @param preparationTime the preparation time
     */
    public static void createDessert(List<Recipe> recipes, User author, String name, int numDiners,
                                      String preparation, List<Ingredient> ingredients, float calories,
                                      char difficultyLevel, SpecialDiets specialDiets, LocalDate publicationDate, int preparationTime)
    {
        Scanner sc = new Scanner(System.in);
        String bakedInput;
        boolean baked = false;
        int restingTime;
        int bakingTime;
        int servingTemperature;
        // Ask the user for the baked option until valid input is provided.
        do
        {
            System.out.print("Is it baked? Y/N: ");
            bakedInput = sc.nextLine();
            if(FieldsValidator.isEmpty(bakedInput))
            {
                System.out.println("The baked field cannot be empty.");
            }
            if(FieldsValidator.isValidYesNo(bakedInput))
            {
                baked = bakedInput.equalsIgnoreCase("Y");
            }
            if(!FieldsValidator.isValidYesNo(bakedInput))
            {
                System.out.println("The baked field must be Y or N.");
            }
        }
        while(FieldsValidator.isEmpty(bakedInput) ||
                !FieldsValidator.isValidYesNo(bakedInput));
        // Ask the user for the resting time until valid input is provided.
        do {
            System.out.print("Enter the resting time: ");
            while(!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Resting Time has to be a number:");
            }
            restingTime = sc.nextInt();


            if(!FieldsValidator.isPositive(restingTime))
            {
                System.out.println("The resting time must be a positive number.");
            }
        }
        while(!FieldsValidator.isPositive(restingTime));
        // Ask the user for the baking time until valid input is provided.
        do {
            System.out.print("Enter the baking time: ");
            while(!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Baking Time has to be a number:");
            }
            bakingTime = sc.nextInt();


            if(!FieldsValidator.isPositive(bakingTime))
            {
                System.out.println("The baking time must be a positive number.");
            }
        }
        while(!FieldsValidator.isPositive(bakingTime));
        // Ask the user for the serving temperature until valid input is provided.
        do
        {
            System.out.print("Enter the serving temperature: ");
            while(!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Serving Temperature has to be a number:");
            }
            servingTemperature = sc.nextInt();


            if(!FieldsValidator.isPositive(servingTemperature))
            {
                System.out.println("The serving temperature must be a positive number.");
            }
        }
        while(!FieldsValidator.isPositive(servingTemperature));

        recipes.add(new Dessert(name, numDiners, preparation, ingredients, calories,
                difficultyLevel, specialDiets, publicationDate, preparationTime,
                author, baked, restingTime, bakingTime, servingTemperature, 'D'));
    }
    /**
     * Creates a main course and adds it to the list of recipes.
     *
     * @param recipes the list of recipes
     * @param author the user who created the recipe
     * @param name the name of the recipe
     * @param numDiners the number of diners
     * @param preparation the preparation description
     * @param ingredients the list of ingredients
     * @param calories the number of calories
     * @param difficultyLevel the difficulty level
     * @param specialDiets the special diets
     * @param publicationDate the publication date
     * @param preparationTime the preparation time
     */
    public static void createMainCourse(List<Recipe> recipes, User author, String name, int numDiners,
                                        String preparation, List<Ingredient> ingredients, float calories,
                                        char difficultyLevel, SpecialDiets specialDiets, LocalDate publicationDate, int preparationTime)
    {
        Scanner sc = new Scanner(System.in);
        String celebrationDish;
        String sideDish;
        // Ask the user for the celebration dish until valid input is provided.
        do
        {
            System.out.print("Enter the celebration dish: ");
            celebrationDish = sc.nextLine();
            if(FieldsValidator.isEmpty(celebrationDish))
            {
                System.out.println("The celebration dish cannot be empty.");
            }
        }
        while(FieldsValidator.isEmpty(celebrationDish));
        // Ask the user for the side dish until valid input is provided.
        do
        {
            System.out.print("Enter the side dish: ");
            sideDish = sc.nextLine();

            if(FieldsValidator.isEmpty(sideDish))
            {
                System.out.println("The side dish cannot be empty.");
            }
        }
        while(FieldsValidator.isEmpty(sideDish));

        recipes.add(new MainCourse(name, numDiners, preparation, ingredients, calories,
                difficultyLevel, specialDiets, publicationDate, preparationTime,
                author, celebrationDish, sideDish, 'M'));
    }
    /**
     * Creates a recipe and adds it to the list of recipes.
     *
     * @param recipes the list of recipes
     * @param user the user who created the recipe
     */
    public static void createRecipe(List<Recipe> recipes, User user)
    {
        Scanner sc = new Scanner(System.in);

        String name, preparation;
        int numDiners, preparationTime, recipeType;
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        float calories;
        char difficultyLevel;
        String specialDietInput;
        SpecialDiets specialDiets = null;
        LocalDate publicationDate = LocalDate.now();
        User author;
        int numIngredients;

        // Ask the user for recipe details until valid input is provided.
        System.out.println(" --- CREATE NEW RECIPE --- ");
        // Ask the user for the name of the recipe until valid input is provided.
        do
        {
            System.out.println("Enter the name of the recipe:");
            name = sc.nextLine();
            if (FieldsValidator.isEmpty(name))
            {
                System.out.println("The name cannot be empty.");
            }
        }
        while (FieldsValidator.isEmpty(name));
        // Ask the user for the number of diners until valid input is provided.
        do
        {
            System.out.println("Enter the number of diners:");
            while (!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Numbers of diners has to be a number:");
            }
            numDiners = sc.nextInt();

            if (!FieldsValidator.isPositive(numDiners))
            {
                System.out.println("The number of diners must be positive.");
            }

        }
        while (!FieldsValidator.isPositive(numDiners));
        // Ask the user for the number of calories until valid input is provided.
        do
        {
            System.out.println("Enter the number of calories: ");
            while(!sc.hasNextFloat())
            {
                sc.next();
                System.out.println("Calories has to be a number:");
            }
            calories = sc.nextFloat();


            if(!FieldsValidator.isPositive(calories))
            {
                System.out.println("The number of calories must be positive.");
            }
        } while(!FieldsValidator.isPositive(calories));
        // Ask the user for the difficulty level until valid input is provided.
        do
        {
            System.out.println("Enter the difficulty level: ");
            System.out.println("E - Easy");
            System.out.println("M - Medium");
            System.out.println("H - Hard");
            difficultyLevel = sc.next().charAt(0);

            if(!FieldsValidator.isValidDifficultyLevel(difficultyLevel))
            {
                System.out.println("The difficulty level must be between E-M-H.");
            }
        } while(!FieldsValidator.isValidDifficultyLevel(difficultyLevel));
        sc.nextLine();
        // Ask the user for the special diet until valid input is provided.
        do
        {
            System.out.println("SPECIAL DIETS:");
            System.out.println("VEGAN");
            System.out.println("VEGETARIAN");
            System.out.println("LACTOSE_FREE");
            System.out.println("PALEO");
            System.out.println("KETO");
            System.out.println("NONE");
            System.out.println("Enter the special diet: ");
            specialDietInput = sc.nextLine().toUpperCase();

            if(!FieldsValidator.isValidSpecialDiet(specialDietInput))
            {
                System.out.println("The special diet must be vegan, vegetarian," +
                        " lactose_free, paleo, keto or none.");
            }
            else
            {
                specialDiets = SpecialDiets.valueOf(specialDietInput);
            }
        } while(!FieldsValidator.isValidSpecialDiet(specialDietInput));

        // Ask the user for the preparation time until valid input is provided.
        do
        {
            System.out.println("Enter the preparation time (minutes): ");
            while (!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Preparation time has to be a number");
            }
            preparationTime = sc.nextInt();

            if (!FieldsValidator.isPositive(preparationTime))
            {
                System.out.println("The preparation time must be positive.");
            }
        }
        while (!FieldsValidator.isPositive(preparationTime));
        // Ask the user for the preparation description until valid input is provided.
        do
        {
            System.out.println("Enter the preparation description: ");
            sc.nextLine();
            preparation = sc.nextLine();

            if (FieldsValidator.isEmpty(preparation))
            {
                System.out.println("The preparation description cannot be empty.");
            }
        }
        while (FieldsValidator.isEmpty(preparation));
        // Ask the user for the number of ingredients until valid input is provided.
        do
        {
            System.out.println("How many ingredients have: ");

            while(!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Number of ingredients has to be a number:");
            }
            numIngredients = sc.nextInt();

            if(!FieldsValidator.isPositive(numIngredients))
            {
                System.out.println("The number of ingredients must be positive.");
            }
            if(numIngredients == 0)
            {
                System.out.println("The number of ingredients cannot be 0.");
            }
        }
        while (!FieldsValidator.isPositive(numIngredients) || numIngredients == 0);
        // Create the list of ingredients by calling the addIngredient method.
        for (int i = 0; i < numIngredients; i++)
        {
            ingredients.add(addIngredient());
        }

        author = user;
        // Ask the user for the recipe type until valid input is provided.
        do
        {
            System.out.println("Dish Type: ");
            System.out.println("1. Appetizer");
            System.out.println("2. Cocktail");
            System.out.println("3. Main Course");
            System.out.println("4. Dessert");
            System.out.print("Enter the type: ");

            if (!sc.hasNextInt())
            {
                sc.next();
                System.out.println("Has to be a number:");
            }
            recipeType = sc.nextInt();

            if (recipeType < 1 || recipeType > 4)
            {
                System.out.println("The recipe type must be between 1 and 4.");
            }
        }
        while (recipeType < 1 || recipeType > 4);
        // Create the recipe based on the selected type.
        switch (recipeType)
        {
            case 1:
                System.out.println("Appetizer selected.");
                createAppetizer(recipes, author, name, numDiners, preparation, ingredients, calories,
                        difficultyLevel, specialDiets, publicationDate, preparationTime);
                System.out.println("--- RECIPE APPETIZER CREATED ---");
                break;
            case 2:
                System.out.println("Cocktail selected.");
                createCocktail(recipes, author, name, numDiners, preparation, ingredients, calories,
                        difficultyLevel, specialDiets, publicationDate, preparationTime);
                System.out.println("--- RECIPE COCKTAIL CREATED ---");
                break;
            case 3:
                System.out.println("Main Course selected.");
                createMainCourse(recipes, author, name, numDiners, preparation, ingredients, calories,
                        difficultyLevel, specialDiets, publicationDate, preparationTime);
                System.out.println("--- RECIPE MAIN COURSE CREATED ---");
                break;
            case 4:
                System.out.println("Dessert selected.");
                createDessert(recipes, author, name, numDiners, preparation, ingredients, calories,
                        difficultyLevel, specialDiets, publicationDate, preparationTime);
                System.out.println("--- RECIPE DESSERT CREATED ---");
                break;
        }
    }
}
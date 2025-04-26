package Recipe.utils;
import Recipe.classes.*;

import java.io.IOException;
import java.util.Scanner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*Not finished yet*/

public class CreateRecipe
{
    private static User currentUser;

    /**
     * Set the current user
     * @param user the user to set as current
     */
    // We need to set the current user when the user logs in
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static Ingredient addIngredient() {
        Scanner sc = new Scanner(System.in);

        System.out.println(" --- INGREDIENTS --- ");
        System.out.println("Enter the name of the ingredient:");
        String name = sc.nextLine();
        System.out.println("Enter the unit of the ingredient:");
        String unit = sc.nextLine();
        System.out.println("Enter the quantity of the ingredient:");
        int number = sc.nextInt();
        sc.nextLine();

        return new Ingredient(name, number, unit);
    }

    // Make checks
    public static List<Recipe> createRecipe()
    {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Scanner sc = new Scanner(System.in);

        String name, preparation = "";
        int numDiners, preparationTime, recipeType;
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        float calories;
        char difficultyLevel;
        SpecialDiets specialDiet;
        LocalDate publicationDate;
        User author;

        System.out.println(" --- RECIPE --- ");
        System.out.println("Enter the name of the recipe:");
        name = sc.nextLine();
        System.out.println("Enter the number of diners:");
        numDiners = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of calories: ");
        calories = sc.nextFloat();
        System.out.println("Enter the difficulty level: ");
        difficultyLevel = sc.next().charAt(0);
        sc.nextLine();
        System.out.println("Enter the special diet: ");
        specialDiet = SpecialDiets.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Enter the publication date: ");
        publicationDate = LocalDate.parse(sc.nextLine());
        System.out.println("Enter the preparation time: ");
        preparationTime = sc.nextInt();
        sc.nextLine();

        System.out.println("How many ingredients have: ");
        int numIngredients = sc.nextInt();

        for (int i = 0; i < numIngredients; i++)
        {
            ingredients.add(addIngredient());
        }

        author = currentUser;

        do
        {
            System.out.println("Dish Type: ");
            System.out.println("1. Appetizer");
            System.out.println("2. Cocktail");
            System.out.println("3. Main Course");
            System.out.println("4. Dessert");
            System.out.print("Enter the type: ");


            recipeType = sc.nextInt();
            sc.nextLine();
        }
        while (recipeType < 1 || recipeType > 4);

        if (recipeType == 1)
        {
            int servingTemperature;
            String culturalOrigin;

            System.out.print("Enter the serving temperature:");
            servingTemperature = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the cultural origin: ");
            culturalOrigin = sc.nextLine();

            recipes.add(new Appetizer(name, numDiners, preparation, ingredients, calories,
                    difficultyLevel, specialDiet, publicationDate, preparationTime,
                    author, servingTemperature, culturalOrigin, 'A'));
        } else if (recipeType == 2)
        {
            boolean containAlcohol;
            float alcoholContent;
            boolean flambe;

            System.out.print("Does it contain alcohol? Y/N: ");
            containAlcohol = sc.next().charAt(0) == 'Y' || sc.next().charAt(0) == 'y';
            System.out.print("Enter the alcohol content: ");
            alcoholContent = sc.nextFloat();
            System.out.print("Is it flambe? Y/N: ");
            flambe = sc.next().charAt(0) == 'Y' || sc.next().charAt(0) == 'y';

            recipes.add(new Cocktail(name, numDiners, preparation, ingredients, calories,
                    difficultyLevel, specialDiet, publicationDate, preparationTime,
                    author, containAlcohol, alcoholContent, flambe, 'C'));

        } else if (recipeType == 3)
        {
            String celebrationDish;
            String sideDish;

            System.out.print("Enter the celebration dish: ");
            celebrationDish = sc.nextLine();
            System.out.print("Enter the side dish: ");
            sideDish = sc.nextLine();

            recipes.add(new MainCourse(name, numDiners, preparation, ingredients, calories,
                    difficultyLevel, specialDiet, publicationDate, preparationTime,
                    author, celebrationDish, sideDish, 'M'));
        } else
        {
            boolean baked;
            int restingTime;
            int bakingTime;
            int servingTemperature;
            System.out.print("Is it baked? Y/N: ");
            baked = sc.next().charAt(0) == 'Y' || sc.next().charAt(0) == 'y';
            System.out.print("Enter the resting time: ");
            restingTime = sc.nextInt();
            System.out.print("Enter the baking time: ");
            bakingTime = sc.nextInt();
            System.out.print("Enter the serving temperature: ");
            servingTemperature = sc.nextInt();
            sc.nextLine();

            recipes.add(new Dessert(name, numDiners, preparation, ingredients, calories,
                    difficultyLevel, specialDiet, publicationDate, preparationTime,
                    author, baked, restingTime, bakingTime, servingTemperature, 'D'));
        }
        return recipes;
    }
}

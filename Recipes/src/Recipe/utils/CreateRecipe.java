package Recipe.utils;
import Recipe.classes.*;
import java.util.Scanner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*Not finished yet*/

public class CreateRecipe
{
    private static User currentUser;

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static List<Ingredient> addIngredients() {
        Scanner sc = new Scanner(System.in);

        String name, unit;
        int number;
        List<Ingredient> ingredients = new ArrayList<Ingredient>();

        System.out.println(" --- INGREDIENTS --- ");
        System.out.println("Enter the name of ingredients:");
        name = sc.nextLine();
        System.out.println("Enter the unit of ingredients:");
        unit = sc.nextLine();
        System.out.println("Enter the number of ingredients:");
        number = sc.nextInt();
        sc.nextLine(); // Consume newline left-over

        ingredients.add(new Ingredient(name, number, unit));

        return ingredients;
    }
    public static List<Recipe> createRecipe()
    {
        List<Recipe> recipes = new ArrayList<Recipe>();
        Scanner sc = new Scanner(System.in);

        String name, preparation = "";
        int numDiners, preparationTime, recipeType;
        List<Ingredient> ingredients;
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

        ingredients = addIngredients();
        author = currentUser;

        System.out.println("Enter the type: ");
        System.out.println("1. Dessert");
        System.out.println("2. Cocktail");
        System.out.println("3. Appetizer");
        System.out.println("4. Main Course");
        recipeType = sc.nextInt();
        sc.nextLine();








    }
}

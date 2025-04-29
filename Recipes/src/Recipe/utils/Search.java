package Recipe.utils;
import Recipe.classes.*;
import java.util.*;
import java.time.LocalDate;

public class Search
{
    static Scanner sc = new Scanner(System.in);

    public static void SearchByPublicationDate(List<Recipe> recipes)
    {
        LocalDate searchDate = null;

        System.out.print("Enter the publication date to search (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();

        try
        {
            searchDate = LocalDate.parse(inputDate);
        }
        catch (Exception e)
        {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }

        boolean found = false;
        for (Recipe r : recipes)
        {
            if (r.getPublicationDate().equals(searchDate))
            {
                System.out.println(r);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recipes found for the given publication date.");
        }
    }

    public static void SearchByNumberOfDiners(List<Recipe> recipes)
    {
        System.out.print("Enter the number of diners to search for: ");
        int numDiners = 0;

        try {
            numDiners = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer number.");
            sc.nextLine();
        }

        boolean found = false;
        for (Recipe recipe : recipes) {
            if (recipe.getNumDiners() == numDiners) {
                System.out.println("---------------------------------");
                System.out.println(recipe);
                System.out.println("---------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recipes found for " + numDiners + " diners.");
        }
    }

    public static void SearchByDishType(List<Recipe> recipes)
    {
        System.out.println("Select the type of dish to search:");
        System.out.println("1. Appetizer");
        System.out.println("2. Cocktail");
        System.out.println("3. Main Course");
        System.out.println("4. Dessert");
        System.out.print("Enter the option: ");

        int option;
        try {
            option = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.nextLine();
            return;
        }

        String typeToSearch = "";
        switch (option) {
            case 1:
                typeToSearch = "A";
                break;
            case 2:
                typeToSearch = "C";
                break;
            case 3:
                typeToSearch = "M";
                break;
            case 4:
                typeToSearch = "D";
                break;
            default:
                System.out.println("Invalid option selected.");
                break;
        }

        boolean found = false;
        for (Recipe recipe : recipes) {
            if (String.valueOf(recipe.getDishType()).equalsIgnoreCase(typeToSearch)) {
                System.out.println("---------------------------------");
                System.out.println(recipe);
                System.out.println("---------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recipes found for the selected dish type.");
        }
    }

    public static void SearchByName(List<Recipe> recipes)
    {
        System.out.print("Enter the recipe name: ");
        String name;

        name = sc.nextLine();

        boolean found = false;
        for (Recipe r : recipes)
        {
            if (r.getName() == name)
            {
                System.out.println(r);
                found = true;
            }
        }

        if (!found)
        {
            System.out.println("No recipes found for " + name + ".");
        }
    }


    public static void SearchByDifficulty(List<Recipe> recipes)
    {
        String difficulty;
        char search = ' ';
        boolean found = false;
        do {
            if(search != 'E' && search != 'M' && search != 'H')
            {
                System.out.println("Enter the difficulty");
                difficulty = sc.nextLine().toUpperCase();
                search = difficulty.charAt(0);
            }
        }
        while(search != 'E' && search != 'M' && search != 'H');

        for(Recipe r : recipes)
        {
            if(r.getDifficultyLevel()== search)
                System.out.println(r);
            found = true;
        }
         if (!found)
         {
        System.out.println("No recipes found for this difficulty " + search);
        }

    }

    public static void SearchByPreparationTime(List<Recipe> recipes)
    {
        System.out.print("Enter the preparation time: ");
        int preparationTime = 0;

        try
        {
            preparationTime = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("Invalid input. Please enter a valid integer number.");
            sc.nextLine();
        }

        boolean found = false;
        for (Recipe r : recipes)
        {
            if (r.getPreparationTime() == preparationTime)

            {
                System.out.println(r);
                found = true;
            }
        }
        if (!found)
        {
            System.out.println("No recipes found for this preparation time.");
        }
    }

    public static void SearchByDiet(List<Recipe> recipes)
    {
        int diet;
        boolean found = false;
        SpecialDiets choosen = null;

        System.out.println("Select a diet: ");
        System.out.println("1.VEGAN,\n" +
                "    2.VEGETARIAN,\n" +
                "    3.CELIAC,\n" +
                "    4.KETO,\n" +
                "    5.PALEO,\n" +
                "    6.LACTOSE_FREE");

        try {
            diet = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.nextLine();
            return;
        }
        switch (diet)
        {
            case 1:
                choosen = SpecialDiets.VEGAN;
                break;
            case 2:
                choosen = SpecialDiets.VEGETARIAN;
                break;
            case 3:
                choosen = SpecialDiets.CELIAC;
                break;
            case 4:
                choosen = SpecialDiets.KETO;
                break;
            case 5:
                choosen = SpecialDiets.PALEO;
                break;
            case 6:
                choosen = SpecialDiets.LACTOSE_FREE;
                break;
            default:
                System.out.println("Invalid option selected.");
                break;
        }

        for(Recipe r : recipes)
        {
            if(r.getSpecialDiet().equals(choosen))
            {
                found = true;
                System.out.println(r);
                System.out.println();
            }
        }
        if (!found)
        {
            System.out.println("No recipes found");
        }
    }

    public static void SearchByIngredients(List<Recipe> recipes)
    {
        String ingredients;
        boolean foundIngredients = true, foundRecipes = false;

        System.out.println("Introduce all the ingredients separated by a ';'");
        ingredients = sc.nextLine();

        String[] userIngredients = ingredients.toLowerCase().split(";");
        Arrays.sort(userIngredients);

        for(Recipe r: recipes)
        {
            List<Ingredient> recipeIngredients = r.getIngredients();
            String[] recipeIngredientName = new String[recipeIngredients.size()];
            for (int i = 0; i < recipeIngredients.size(); i++) {
                recipeIngredientName[i] = recipeIngredients.get(i).getName().toLowerCase();
            }
            if(userIngredients.length >= recipeIngredients.size())
            {
                for (int i = 0; i < userIngredients.length; i++) {
                    for (int j = 0; j < recipeIngredientName.length; j++) {
                        if (!userIngredients[i].equals(recipeIngredientName[j])) {
                            foundIngredients = false;
                        }
                    }
                }
                if (foundIngredients)
                {
                    System.out.println(r);
                    foundRecipes = true;
                }
            }
        }
        if (!foundRecipes) {
            System.out.println("No recipes found that can be made with the given ingredients.");
        }
    }
  
    public static void ShowUsers(List<Author> users)
    {
        boolean found = false;


        System.out.println("All users");
        for(Author u: users)
        {
            System.out.println(u.getName());
            System.out.println(u.getNumRecipes());
            System.out.println();
            found = true;
        }

        if(!found)
        {
            System.out.println("No users found");
        }
    }

    public static void ShowRecipe(List<Recipe> recipes)
    {
        System.out.println("--ALL RECIPES--");

        boolean found = false;
        for(Recipe r: recipes)
        {
                System.out.println("Author: " + r.getAuthor().getName() + ", Name: " + r.getName());
                found = true;
        }
        if(!found)
        {
            System.out.println("No recipes found");
        }
    }
}

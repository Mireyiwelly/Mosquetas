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
            System.out.println("No recipes found for this difficulty " + search);
        }

        if (!found)
        {
            System.out.println("No recipes found for this preparation time.");
        }
    }
}

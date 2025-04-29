package Recipe.utils;
import java.util.Scanner;

public class Menu
{
    /**
     * This method displays the login menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static LoginOptions MenuLogIn()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      RECIPE MANAGEMENT SYSTEM    ║");
        System.out.println("╚══════════════════════════════════╝");

        System.out.println("Welcome to the Recipe Management System");
        System.out.println("1. Login as Author");
        System.out.println("2. Login as Guest");
        System.out.println("3. Create New Author Account");
        System.out.println("4. Exit");

        System.out.println("Please select an option: ");
        String input = sc.nextLine();

        // If the user inputs "admin1234", log in as an admin
        if (input.equals("admin1234"))
        {
            return LoginOptions.ADMIN;
        }

        int option = Integer.parseInt(input);

        return LoginOptions.values()[option - 1];
    }

    /**
     * This method displays the Author menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static AppMenuOptions AppOptions()
    {
        Scanner sc = new Scanner(System.in);

        AppMenuOptions appOption;
        // These are the Author options
        System.out.println("Welcome back");
        System.out.println("1. Add Recipe");
        System.out.println("2. Modify Recipe");
        System.out.println("3. Delete Recipe");
        System.out.println("4. Search Recipe");
        System.out.println("5. Log Out");

        System.out.println("Please select an option:");
        appOption = AppMenuOptions.values()[sc.nextInt() - 1];

        return appOption;
    }

    /**
     * This method displays the search menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static SearchOptions SearchMenu()
    {
        Scanner sc = new Scanner(System.in);

        SearchOptions searchOption;
        // These are the search options that the user can choose from
        System.out.println("1. Number of diners");
        System.out.println("2. Publication date");
        System.out.println("3. Dish type");
        System.out.println("4. Special diet");
        System.out.println("5. Difficulty level");
        System.out.println("6. Preparation time");
        System.out.println("7. Name of recipe");
        System.out.println("8. Ingredients");
        System.out.println("9. Back to Main Menu");
        System.out.println("Please select an option:");
        searchOption = SearchOptions.values()[sc.nextInt() - 1];

        return searchOption;
    }

    /**
     * This method displays the delete menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static DeleteOptions DeleteMenu()
    {
        Scanner sc = new Scanner(System.in);

        DeleteOptions deleteOption;
        // These are the delete options that the user can choose from
        System.out.println("1. Delete by recipe name");
        System.out.println("2. Delete by recipe ID");
        System.out.println("3. Back to Main Menu");
        System.out.println("Please select an option:");
        deleteOption = DeleteOptions.values()[sc.nextInt() - 1];

        return deleteOption;
    }

    /**
     * This method displays the admin menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static AdminOptions AdminMenu()
    {
        Scanner sc = new Scanner(System.in);

        AdminOptions adminOption;
        // These are the admin options that the user can choose from
        System.out.println("Welcome back Admin");
        System.out.println("1. Delete User");
        System.out.println("2. Delete Recipes");
        System.out.println("3. Show Users");
        System.out.println("4. Show Recipes");
        System.out.println("5. Log Out");

        System.out.println("Please select an option:");
        adminOption = AdminOptions.values()[sc.nextInt() - 1];

        return adminOption;

    }
}
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
        int option = -1;

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      RECIPE MANAGEMENT SYSTEM    ║");
        System.out.println("╚══════════════════════════════════╝");

        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║      Welcome to the Recipe Management System       ║");
        System.out.println("╠════════════════════════════════════════════════════╣");
        System.out.println("║ 1. Login as Author                                 ║");
        System.out.println("║ 2. Login as Guest                                  ║");
        System.out.println("║ 3. Create New Author Account                       ║");
        System.out.println("║ 4. Exit                                            ║");
        System.out.println("╚════════════════════════════════════════════════════╝");


        while(option < 1 || option > 4)
        {
            System.out.println("Please select an option: ");
            String input = sc.nextLine();
            // If the user inputs "admin1234", log in as an admin
            if (input.equals("admin1234"))
            {
                return LoginOptions.ADMIN;
            }

            try
            {
                option = Integer.parseInt(input);
                if (option < 1 || option > 4)
                {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return LoginOptions.values()[option - 1];
    }

    /**
     * This method displays the Author menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static AppMenuOptions AppOptions()
    {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        AppMenuOptions appOption;

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║           Welcome !          ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. Add Recipe                ║");
        System.out.println("║ 2. Modify Recipe             ║");
        System.out.println("║ 3. Delete Recipe             ║");
        System.out.println("║ 4. Search Recipe             ║");
        System.out.println("║ 5. Log Out                   ║");
        System.out.println("╚══════════════════════════════╝");

        while(option < 1 || option > 5)
        {
            System.out.println("Please select an option:");

            try
            {
                String input = sc.nextLine();
                option = Integer.parseInt(input);
                if (option < 1 || option > 5)
                {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        appOption = AppMenuOptions.values()[option - 1];
        return appOption;
    }

    /**
     * This method displays the search menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static SearchOptions SearchMenu()
    {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        SearchOptions searchOption;

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         Recipe Filter Options        ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║ 1. Number of diners                  ║");
        System.out.println("║ 2. Publication date                  ║");
        System.out.println("║ 3. Dish type                         ║");
        System.out.println("║ 4. Special diet                      ║");
        System.out.println("║ 5. Difficulty level                  ║");
        System.out.println("║ 6. Preparation time                  ║");
        System.out.println("║ 7. Name of recipe                    ║");
        System.out.println("║ 8. Ingredients                       ║");
        System.out.println("║ 9. Back to Main Menu                 ║");
        System.out.println("╚══════════════════════════════════════╝");

        while(option < 1 || option > 9)
        {
            System.out.println("Please select an option:");

            try
            {
                String input = sc.nextLine();
                option = Integer.parseInt(input);
                if (option < 1 || option > 9)
                {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        searchOption = SearchOptions.values()[option - 1];
        return searchOption;
    }

    /**
     * This method displays the delete menu and returns the selected option.
     * @return The selected option as an enum value.
     */

    public static DeleteOptions DeleteMenu()
    {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        DeleteOptions deleteOption;

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║         Delete Recipe Options              ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ 1. Delete by recipe name                   ║");
        System.out.println("║ 2. Delete by dish type                     ║");
        System.out.println("║ 3. Back to Main Menu                       ║");
        System.out.println("╚════════════════════════════════════════════╝");

        while(option < 1 || option > 3)
        {
            System.out.println("Please select an option:");

            try
            {
                String input = sc.nextLine();
                option = Integer.parseInt(input);
                if (option < 1 || option > 3)
                {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        deleteOption = DeleteOptions.values()[option - 1];
        return deleteOption;
    }

    /**
     * This method displays the admin menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static AdminOptions AdminMenu()
    {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        AdminOptions adminOption;

        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║       Welcome Admin           ║");
        System.out.println("╠═══════════════════════════════╣");
        System.out.println("║ 1. Delete User                ║");
        System.out.println("║ 2. Delete Recipes             ║");
        System.out.println("║ 3. Show Users                 ║");
        System.out.println("║ 4. Show Recipes               ║");
        System.out.println("║ 5. Log Out                    ║");
        System.out.println("╚═══════════════════════════════╝");

        while(option < 1 || option > 5)
        {
            System.out.println("Please select an option:");

            try
            {
                String input = sc.nextLine();
                option = Integer.parseInt(input);
                if (option < 1 || option > 5)
                {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        adminOption = AdminOptions.values()[option - 1];
        return adminOption;
    }


    /**
     * This method displays the guest menu and returns the selected option.
     * @return The selected option as an enum value.
     */
    public static GuestOptions GuestMenu()
    {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        GuestOptions guestOption;

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║       Welcome Guest          ║");
        System.out.println("╠══════════════════════════════╣");
        System.out.println("║ 1. Search Recipe             ║");
        System.out.println("║ 2. Log Out                   ║");
        System.out.println("╚══════════════════════════════╝");

        while(option < 1 || option > 2)
        {
            System.out.println("Please select an option:");

            try
            {
                String input = sc.nextLine();
                option = Integer.parseInt(input);
                if (option < 1 || option > 2)
                {
                    System.out.println("Invalid option. Please try again.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        guestOption = GuestOptions.values()[option - 1];
        return guestOption;
    }
}
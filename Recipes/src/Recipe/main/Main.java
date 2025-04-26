package Recipe.main;
import Recipe.classes.Recipe;
import Recipe.classes.User;
import Recipe.utils.*;

import java.util.List;

public class Main
{
    static List<Recipe> recipes;
    static List<User> users;

    public static void main(String[] args)
    {
        users = ReadFile.ReadUserFile();
        LoginOptions optionUser;
        AppMenuOptions appOption;
        AdminOptions adminOption;
        DeleteOptions deleteOption;
        SearchOptions searchOption;
        GuestOptions guestOption;

        do
        {
            optionUser = Menu.MenuLogIn();
            switch (optionUser)
            {
                case AUTHOR:
                    System.out.println("Author login selected.");
                    // Implement author login functionality here
                    appOption = Menu.AppOptions();
                    switch (appOption)
                    {
                        case ADD_RECIPE:
                            System.out.println("Add recipe selected.");
                            recipes = CreateRecipe.createRecipe();
                            break;
                        case MODIFY_RECIPE:
                            System.out.println("Modify recipe selected.");
                            // Implement modify recipe functionality here
                            break;
                        case DELETE_RECIPE:
                            System.out.println("Delete recipe selected.");
                            deleteOption = Menu.DeleteMenu();
                            break;
                        case SEARCH_RECIPE:
                            System.out.println("Search recipe selected.");
                            searchOption = Menu.SearchMenu();
                            break;
                        default:
                            System.out.println("Invalid option selected.");
                    }
                    break;
                case GUEST:
                    System.out.println("Guest login selected.");
                    guestOption = Menu.GuestMenu();
                    break;
                case NEW_AUTHOR:
                    System.out.println("New author account creation selected.");
                    // Implement new author account creation functionality here
                    break;
                case ADMIN:
                    System.out.println("Admin login successful!");
                    adminOption = Menu.AdminMenu();
                    break;
                case EXIT:
                    System.out.println("Exiting the application.");
                    WriteFile.writeUsers(users);
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        } while(optionUser != LoginOptions.EXIT);
    }
}
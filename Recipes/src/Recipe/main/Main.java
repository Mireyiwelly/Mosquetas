package Recipe.main;
import Recipe.classes.Author;
import Recipe.classes.Recipe;
import Recipe.classes.User;
import Recipe.utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    static List<Recipe> recipes;
    static List<User> users;
    static Author currentUser = null;
    /**
     * Main method to start the application.
     * Reads users and recipes from files, and manages user login options.
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        users = ReadFile.ReadUserFile();
        recipes = ReadFile.ReadRecipeFile();
        LoginOptions optionUser;
        List<Author> authors;
        authors = new ArrayList<>();
        // Iterate through the list of users and add authors to the authors list
        for(User user : users)
        {
            if(user instanceof Author)
            {
                authors.add((Author) user);
            }
        }

        do
        {
            optionUser = Menu.MenuLogIn();
            switch (optionUser)
            {
                case AUTHOR:
                    System.out.println("Author login selected.");
                    RecipeManagment.ManageAuthor(recipes, users);
                    break;
                case GUEST:
                    System.out.println("Guest login selected.");
                    RecipeManagment.ManageGuest(recipes);
                    break;
                case NEW_AUTHOR:
                    System.out.println("New author account creation selected.");
                    Login.SignInAuthor(users, sc);
                    break;
                case ADMIN:
                    System.out.println("Admin login successful!");
                    RecipeManagment.ManageAdmin(authors, recipes);
                    break;
                case EXIT:
                    System.out.println("Exiting the application.");
                    WriteFile.saveUsers(users);
                    WriteFile.saveRecipes(recipes);
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        } while(optionUser != LoginOptions.EXIT);
    }
}
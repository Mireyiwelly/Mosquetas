package Recipe.main;
import Recipe.classes.Author;
import Recipe.classes.Recipe;
import Recipe.classes.User;
import Recipe.utils.*;

import java.util.List;

public class Main
{
    static List<Recipe> recipes;
    static List<User> users;
    static Author currentUser = null;

    public static void main(String[] args)
    {
        users = ReadFile.ReadUserFile();
        recipes = ReadFile.ReadRecipeFile();
        LoginOptions optionUser;

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
                    Login.SingInAutor(users);
                    break;
                case ADMIN:
                    System.out.println("Admin login successful!");
                    RecipeManagment.ManageAdmin(users, recipes);
                    break;
                case EXIT:
                    System.out.println("Exiting the application.");
                    WriteFile.writeUsers(users);
                    WriteFile.saveRecipes(recipes);
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        } while(optionUser != LoginOptions.EXIT);
    }
}
package Recipe.utils;

import Recipe.classes.Author;
import Recipe.classes.Recipe;
import Recipe.classes.User;

import java.util.List;

public class RecipeManagment
{
    public static void ManageAuthor(List<Recipe> recipes, List<User> users)
    {
        Author currentUser = Login.LoginAutor(users);
        if(currentUser == null)
        {
            return;
        }

        AppMenuOptions option;
        do
        {
            option = Menu.AppOptions();
            switch (option)
            {
                case ADD_RECIPE:
                    System.out.println("Add recipe selected.");
                    CreateRecipe.createRecipe(recipes, currentUser);
                    break;
                case MODIFY_RECIPE:
                    System.out.println("Modify recipe selected.");
                    Modify.UpdateRecipe(recipes, currentUser);
                    break;
                case DELETE_RECIPE:
                    System.out.println("Delete recipe selected.");
                    Delete.ManageDelete(recipes, currentUser);
                    break;
                case SEARCH_RECIPE:
                    System.out.println("Search recipe selected.");
                    Search.ManageSearch(recipes);
                case LOGOUT:
                    System.out.println("Logout selected.");
                    currentUser = null;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        while (option != AppMenuOptions.LOGOUT);
    }

    public static void ManageGuest(List<Recipe> recipes)
    {
        GuestOptions option;
        do
        {
            option = Menu.GuestMenu();
            switch (option)
            {
                case SEARCH:
                    System.out.println("Search recipe selected.");
                    Search.ManageSearch(recipes);
                    break;
                case LOGOUT:
                    System.out.println("Logout selected.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        while(option != GuestOptions.LOGOUT);
    }

    public static void ManageAdmin(List<User> users, List<Recipe> recipes)
    {
        AdminOptions option;
        do
        {
            option = Menu.AdminMenu();
            switch (option)
            {
                case DELETE_USER:
                    System.out.println("Delete user selected.");
                    Delete.DeleteUser(users);
                    break;
                case DELETE_RECIPE:
                    System.out.println("Delete recipe selected.");
                    Delete.DeleteByNameAndUser(recipes);
                    break;
                case SHOW_USERS:
                    System.out.println("Show users selected.");
                    Search.ShowUsers(users);
                    break;
                case SHOW_RECIPES:
                    System.out.println("Show recipes selected.");
                    Search.ShowRecipe(recipes);
                    break;
                case LOGOUT:
                    System.out.println("Logout selected.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        while(option != AdminOptions.LOGOUT);
    }
}

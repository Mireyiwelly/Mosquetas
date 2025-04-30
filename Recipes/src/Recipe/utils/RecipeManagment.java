package Recipe.utils;

import Recipe.classes.Author;
import Recipe.classes.Recipe;
import Recipe.classes.User;

import java.util.Collections;
import java.util.List;

public class RecipeManagment
{
    /**
     * Manages the author options for creating, modifying, and deleting recipes.
     * @param recipes receives the list of recipes
     * @param users receives the list of users
     */
    public static void ManageAuthor(List<Recipe> recipes, List<User> users)
    {
        Author currentUser = Login.LoginAuthor(users);
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
                    Collections.sort(recipes);
                    Search.ShowRecipe(recipes);
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

    /**
     * Manages the guest options for searching recipes.
     * @param recipes receives the list of recipes
     */
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

    /**
     * Manages the admin options for deleting users and recipes.
     * @param users receives the list of users
     * @param recipes receives the list of recipes
     */
    public static void ManageAdmin(List<Author> users, List<Recipe> recipes)
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

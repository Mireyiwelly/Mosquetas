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
                    Login.LoginAutor(users);
                    appOption = Menu.AppOptions();
                    switch (appOption)
                    {
                        case ADD_RECIPE:
                            System.out.println("Add recipe selected.");
                            recipes = CreateRecipe.createRecipe();
                            break;
                        case MODIFY_RECIPE:
                            System.out.println("Modify recipe selected.");
                            Modify.UpdateRecipe(recipes,currentUser);
                            break;
                        case DELETE_RECIPE:
                            System.out.println("Delete recipe selected.");
                            deleteOption = Menu.DeleteMenu();
                            break;
                        case SEARCH_RECIPE:
                            System.out.println("Search recipe selected.");
                            searchOption = Menu.SearchMenu();
                            switch(searchOption)
                            {
                                case DATE:
                                    System.out.println("Search recipe by date selected.");
                                    Search.SearchByPublicationDate(recipes);
                                    break;
                                case DINERS:
                                    System.out.println("Search recipe by diners selected.");
                                    Search.SearchByNumberOfDiners(recipes);
                                    break;
                                case DIET:
                                    System.out.println("Search recipe by diet selected.");
                                    Search.SearchByDiet(recipes);
                                    break;
                                case DISH:
                                    System.out.println("Search recipe by dish selected.");
                                    Search.SearchByDishType(recipes);
                                    break;
                                case NAME:
                                    System.out.println("Search recipe by name selected.");
                                    Search.SearchByName(recipes);
                                    break;
                                case DIFFICULTY:
                                    System.out.println("Search recipe by difficulty selected.");
                                    Search.SearchByDifficulty(recipes);
                                    break;
                                case INGREDIENTS:
                                    System.out.println("Search recipe by ingredients selected.");
                                    Search.SearchByIngredients(recipes);
                                    break;
                                case PREPARATION_TIME:
                                    System.out.println("Search recipe by preparation time selected.");
                                    //Implement search by preparation time method here
                                    break;
                                case EXIT:
                                    System.out.println("Exiting search by.");
                                    break;
                                default:
                                    System.out.println("Invalid option selected.");
                            }
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
                    Login.SingInAutor(users);
                    break;
                case ADMIN:
                    System.out.println("Admin login successful!");
                    adminOption = Menu.AdminMenu();
                    switch (adminOption)
                    {
                        case DELETE_RECIPE:
                            System.out.println("Delete recipe selected");
                            Delete.DeleteByNameAndUser(recipes);
                            break;
                        case DELETE_USER:
                            System.out.println("Delete user selected");
                            Delete.DeleteUser(users);
                            break;
                        case SHOW_USERS:
                            //
                            break;
                        case SHOW_RECIPES:
                            //
                            break;
                        case LOGOUT:
                            //
                            break;
                        default:
                            System.out.println("Invalid option selected.");
                    }
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
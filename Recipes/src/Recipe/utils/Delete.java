package Recipe.utils;

import Recipe.classes.Author;
import Recipe.classes.Recipe;
import Recipe.classes.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Delete
{
    static Scanner sc = new Scanner(System.in);

    public static void ManageDelete(List<Recipe> recipes, Author currentUser)
    {
        DeleteOptions option;
        do
        {
            option = Menu.DeleteMenu();
            switch (option)
            {
                case NAME:
                    System.out.println("Delete by name selected.");
                    DeleteByName(recipes, currentUser);
                    break;
                case DISH_TYPE:
                    System.out.println("Delete by dish type selected.");
                    DeleteRecipeByDishType(recipes, currentUser);
                    break;
                case EXIT:
                    System.out.println("Back to main menu selected.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
        while (option != DeleteOptions.EXIT);
    }
    /**
     * Deletes a recipe from the list of recipes based on the dish type.
     *
     * @param recipes the list of recipes
     */
    public static void DeleteRecipeByDishType(List<Recipe> recipes, Author userLogged)
    {
        char recipeType;
        List<Recipe> userRecipes = userLogged.getCreatedRecipes();
        List<Recipe> filteredRecipes = new ArrayList<Recipe>();

        do {
            System.out.println("Enter the dish type to delete: ");
            System.out.println("1. Appetizer");
            System.out.println("2. Cocktail");
            System.out.println("3. Main Course");
            System.out.println("4. Dessert");
            System.out.print("Enter the type (A - C - M - D: ");

            recipeType = Character.toUpperCase(sc.next().charAt(0));
            sc.nextLine();
        }
        while(recipeType != 'A' && recipeType != 'C' && recipeType != 'M' &&
                recipeType != 'D');


        for(Recipe r : userRecipes)
        {
            if(r.getDishType() == recipeType)
            {
                filteredRecipes.add(r);
            }
        }
        if(filteredRecipes.isEmpty())
        {
            System.out.println("You have no recipes of this type.");
        }
        else
        {
            System.out.println("You have " + filteredRecipes.size() + " recipes of this type.");
            for(Recipe r : filteredRecipes)
            {
                System.out.println(r);
            }
            DeleteByName(recipes, userLogged);
        }
    }

    public static void DeleteByName(List<Recipe> recipes, Author userLogged)
    {
        String deleteRecipe;
        boolean found = false;
        Recipe recipeToDelete = null;

        System.out.println("Enter the name of the recipe to delete: ");
        deleteRecipe = sc.nextLine();

        for (Recipe r : recipes)
        {
            if (!found && r.getName().equalsIgnoreCase(deleteRecipe) &&
                    r.getAuthor() != null &&
                    r.getAuthor().getName().equalsIgnoreCase(userLogged.getName()))
            {
                recipeToDelete = r;
                found = true;
            }
        }

        if(found)
        {
            String confirmation = "";
            do
            {
                if(!confirmation.equalsIgnoreCase("Y") &&
                        !confirmation.equalsIgnoreCase("N"))
                {
                    System.out.println("Do you want to delete this recipe? (Y/N)");
                    confirmation = sc.nextLine();
                }
            }
            while(!confirmation.equalsIgnoreCase("Y") &&
                    !confirmation.equalsIgnoreCase("N"));
            if(confirmation.equalsIgnoreCase("Y"))
            {
                recipes.remove(recipeToDelete);
                System.out.println("Recipe deleted.");
            }
            else
            {
                System.out.println("Operation aborted.");
            }
        }
        else
        {
            System.out.println("Recipe not found");
        }
    }

    public static void DeleteByNameAndUser(List<Recipe> recipes)
    {
        String user, name;
        boolean found = false;
        int delete;
        String confirmation = "";

        System.out.println("User: ");
        user = sc.nextLine();

        System.out.println("Introduce recipe name: ");
        name = sc.nextLine();

        for(int i = 0; i < recipes.size(); i++)
        {
            Recipe r = recipes.get(i);
            if(r.getName().equalsIgnoreCase(name) && r.getAuthor().getName().equalsIgnoreCase(user))
            {
                found = true;
                System.out.println(i + ". " + r.getName());

                do {
                    if(!confirmation.equalsIgnoreCase("Y") &&
                            !confirmation.equalsIgnoreCase("N"))
                    {
                        System.out.println("Do you want to delete this recipe? (Y/N)");
                        confirmation = sc.nextLine();
                    }
                }
                while(!confirmation.equalsIgnoreCase("Y") &&
                        !confirmation.equalsIgnoreCase("N"));
                if(confirmation.equalsIgnoreCase("Y"))
                {
                    recipes.remove(i);
                    System.out.println("Recipe deleted.");
                    i--;
                    //Le restamos una a la i porque el size de la lista varia y puedes saltarte recetas
                }
            }
        }
        if(!found)
        {
            System.out.println("No recipes found");
        }
    }

    public static void DeleteUser(List<User> users) {
        String userName;
        boolean found = false;
        String confirmation = "";

        System.out.println("Enter user name: ");
        userName = sc.nextLine();

        if (userName.equalsIgnoreCase("anonimo")) {
            System.out.println("You can't delete this author. Sorry");
        } else {
            for (int i = 0; i < users.size(); i++) {
                User u = users.get(i);
                if (u.getName().equalsIgnoreCase(userName)) {
                    found = true;
                    do {
                        if (!confirmation.equalsIgnoreCase("Y") &&
                                !confirmation.equalsIgnoreCase("N")) {
                            System.out.println("Do you want to delete this user? (Y/N)");
                            confirmation = sc.nextLine();
                        }
                    }
                    while (!confirmation.equalsIgnoreCase("Y") &&
                            !confirmation.equalsIgnoreCase("N"));
                    if (confirmation.equalsIgnoreCase("Y")) {
                        users.remove(i);
                        System.out.println("User deleted.");
                        i--;
                    }
                }
            }
            if (!found) {
                System.out.println("No user found");
            }
        }
    }
}


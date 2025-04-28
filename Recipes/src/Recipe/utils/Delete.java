package Recipe.utils;

import Recipe.classes.Author;
import Recipe.classes.Recipe;
import Recipe.classes.User;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Delete
{

    static Scanner sc = new Scanner(System.in);

    /**
     * Deletes a recipe from the list of recipes based on the dish type.
     *
     * @param recipes the list of recipes
     */
    public static void DeleteRecipeByDishType(List<Recipe> recipes)
    {

    }

    public static void DeleteByName(List<Recipe> recipes, Author userlogged)
    {
        String deleteRecipe;
        boolean found;
        System.out.println("Enter the name of the recipe to delete: ");
        deleteRecipe = sc.nextLine();

        found = false;
        //Iterator te permite eliminar elementos mientras la recorre
        Iterator<Recipe> deletedRecipes = recipes.iterator();

        //hasnext devuelve true si aun hay elementos sin procesar
        while (deletedRecipes.hasNext() && !found)
        {
            Recipe recipe = deletedRecipes.next();
            //no sé si está condición está bien, busca el nombre de la receta, que el autor no sea nul(creo que no hace falta) y el nombre del autor de la receta(un poco invent)
            if (recipe.getName().equalsIgnoreCase(deleteRecipe) &&
                    recipe.getAuthor() != null &&
                    recipe.getAuthor().getName().equalsIgnoreCase(userlogged.getName()))
            {
                deletedRecipes.remove();
                found = true;
                System.out.println("Delete recipe");
            }
        }
        if(!found)
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


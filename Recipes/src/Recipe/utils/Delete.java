package Recipe.utils;

import Recipe.classes.Recipe;

import java.util.Iterator;
import java.util.List;

public class Delete
{
    /**
     * Deletes a recipe from the list of recipes based on the dish type.
     *
     * @param recipes the list of recipes
     */
    public static void DeleteRecipeByDishType(List<Recipe> recipes)
    {

    }

    public static void DeleteByName(List<Recipe> recipes, String nameToDelete, String nameUser)
    {
        //Iterator te permite eliminar elementos mientras la recorre
        Iterator<Recipe> deletedRecipes = recipes.iterator();
        //este while te elimina todos los nombres que coincidan (No deberia de haber dos recetas con el mismo nombre)
        while (deletedRecipes.hasNext())
        {
            Recipe recipe = deletedRecipes.next();
            //no sé si está condición está bien, busca el nombre de la receta, que el autor no sea nul(creo que no hace falta) y el nombre del autor de la receta(un poco invent)
            if (recipe.getName().equalsIgnoreCase(nameToDelete) &&
                    recipe.getAuthor() != null &&
                    recipe.getAuthor().getName().equalsIgnoreCase(nameUser))
            {
                deletedRecipes.remove();
            }
        }
    }


}

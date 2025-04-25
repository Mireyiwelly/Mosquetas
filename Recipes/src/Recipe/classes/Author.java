package Recipe.classes;
import Recipe.classes.User;

public class Author extends User
{
    public Author(String name, String password, int numRecipes, List<Recipe> createdRecipes)
    {
        super(name, password, numRecipes, createdRecipes);
    }
}

package Recipe.classes;
import java.util.List;

/**
 * Represents an author in the recipe management system.
 * Inherits from the User class and adds a password attribute.
 */
public class Author extends User
{
    protected int numRecipes;
    protected List<Recipe> createdRecipes;

    /**
     * Constructor for Author class.
     * @param name the name of the author
     * @param numRecipes the number of recipes created by the author

     * @param password the password of the author
     */
    public Author(String name, int numRecipes,
                  String password)
    {
        super(name);
        this.numRecipes = numRecipes;
        this.password = EncryptPassword(password);

    }

    public void increaseNumRecipes()
    {
        this.numRecipes++;
    }

    public void decreaseNumRecipes()
    {
        this.numRecipes--;
    }

    public int getNumRecipes()
    {
        return numRecipes;
    }

    /**
     * Sets the number of recipes created by the user.
     * @param numRecipes the new number of recipes
     */

    public void setNumRecipes(int numRecipes)
    {
        this.numRecipes = numRecipes;
    }

    /**
     * Gets the list of recipes created by the user.
     * @return the list of recipes
     */
    public List<Recipe> getCreatedRecipes()
    {
        return createdRecipes;
    }

    /**
     * Sets the list of recipes created by the user.
     * @param createdRecipes the new list of recipes
     */
    public void setCreatedRecipes(List<Recipe> createdRecipes)
    {
        this.createdRecipes = createdRecipes;
    }

    @Override
    public String toFile()
    {
        return super.toFile() + numRecipes + ";" + password;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n" +
                "Password: " + password + "\n" +
                "Number of Recipes: " + numRecipes + "\n" +
                "Created Recipes: " + createdRecipes;
    }
}
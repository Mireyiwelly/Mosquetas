package Recipe.classes;
import Recipe.classes.User;
import Recipe.classes.*;
import java.util.List;

/**
 * Represents an author in the recipe management system.
 * Inherits from the User class and adds a password attribute.
 */
public class Author extends User
{
    protected String password;
    protected int numRecipes;

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
        this.password = password;
    }

    /**
     * Gets the password of the author.
     * @return the password of the author
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets the password of the author.
     * @param password the new password of the author
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Gets the number of recipes created by the user.
     * @return the number of recipes
     */
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

    @Override
    public String toFile()
    {
        return super.toFile() + ";" + password + ";" + numRecipes;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n" +
                "Password: " + password + "\n" +
                "Number of Recipes: " + numRecipes;
    }
}
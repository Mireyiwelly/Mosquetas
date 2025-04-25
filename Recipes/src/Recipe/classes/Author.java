package Recipe.classes;
import Recipe.classes.*;
import java.util.List;

/**
 * Represents an author in the recipe management system.
 * Inherits from the User class and adds a password attribute.
 */
public class Author extends User
{
    protected String password;

    /**
     * Constructor for Author class.
     * @param name the name of the author
     * @param numRecipes the number of recipes created by the author
     * @param createdRecipes the list of recipes created by the author
     * @param password the password of the author
     */
    public Author(String name, int numRecipes, List<Recipe> createdRecipes,
                  String password)
    {
        super(name, numRecipes, createdRecipes);
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
}

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
    protected int numRecipes;
    protected List<Recipe> createdRecipes;

    /**
     * Constructor for Author class.
     * @param name the name of the author
     * @param numRecipes the number of recipes created by the author
     * @param createdRecipes the list of recipes created by the author
     * @param password the password of the author
     * @throws IllegalArgumentException if the password is null or empty
     */
    public Author(String name, int numRecipes, List<Recipe> createdRecipes,
                  String password)
    {
        super(name);
        if(password == null || password.isEmpty())
        {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = password;
        this.numRecipes = numRecipes;
        this.createdRecipes = createdRecipes;
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

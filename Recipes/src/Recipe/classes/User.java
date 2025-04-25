package Recipe.classes;

import java.util.List;

/**
 * Abstract class User that represents a user in the recipe management system.
 * It contains common attributes and methods for all types of users.
 */
abstract public class User
{
    protected String name;
    protected int numRecipes;
    protected List<Recipe> createdRecipes;

    /**
     * Constructor for User class.
     * @param name the name of the user
     */
    public User(String name)
    {
        this.name = name;

    }

    /**
     * Gets the name of the user.
     * @return the name of the user
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name the new name of the user
     */
    public void setName(String name)
    {
        this.name = name;
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
}

package Recipe.classes;
import Recipe.classes.*;
import java.util.List;
/**
 * Represents a guest user in the recipe management system.
 * Inherits from the User class and does not have a password.
 */
public class Guest extends User
{
    /**
     * Constructor for User class.
     *
     * @param name the name of the user
     */
    public Guest(String name)
    {
        super(name);
    }
    /**
     * Gets the name of the user.
     *
     * @return the name of the user
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the user.
     *
     * @param name the new name of the user
     */
    public void setName(String name)
    {
        this.name = name;
    }
}

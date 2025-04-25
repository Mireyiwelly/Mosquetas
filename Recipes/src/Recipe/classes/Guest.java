package Recipe.classes;
import Recipe.classes.*;

import java.util.List;

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
}

package Recipe.classes;
import Recipe.classes.*;
/**
 * Represents an admin user in the recipe management system.
 * Inherits from the User class and adds a password attribute.
 */
public class Admin extends User
{
    protected String password;
    /**
     * Constructor for Admin class.
     * @param name the name of the admin
     * @param password the password of the admin
     */
    public Admin(String name, String password)
    {
        super(name);
        this.password = password;
    }
    /**
     * Gets the password of the admin.
     * @return the password of the admin
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets the password of the admin.
     * @param password the new password of the admin
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toFile()
    {
        return super.toFile() + ";" + password;
    }
}

package Recipe.classes;

/**
 * Represents an admin user in the recipe management system.
 * Inherits from the User class and adds a password attribute.
 */
public class Admin extends User
{

    /**
     * Constructor for Admin class.
     * @param name the name of the admin
     * @param password the password of the admin
     */
    public Admin(String name, String password)
    {
        super(name);
        this.password = EncryptPassword(password);
    }
}

package Recipe.classes;

/**
 * Abstract class User that represents a user in the recipe management system.
 * It contains common attributes and methods for all types of users.
 */
abstract public class User
{
    protected String name;

    protected String password;

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


    public String toFile()
    {
        return  name + ";";
    }




    public String EncryptPassword(String password)
    {
        StringBuilder encriptedpassword = new StringBuilder();
        char c;

        for(int i= 0; i < password.length(); i++)
        {
            c = password.charAt(i);
            if(c != 58) // el : equivale a 58 en ascii, si se ecripta, sería 59 que es ; y da problemas en ficheros
                c++;
            encriptedpassword.append(c);
        }

        return encriptedpassword.toString();
    }
    

    @Override
    public String toString()
    {
        return "Name: " + name;
    }
}

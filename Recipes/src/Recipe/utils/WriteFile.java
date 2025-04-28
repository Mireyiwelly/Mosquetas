package Recipe.utils;
import java.io.*;
import java.util.List;
import Recipe.classes.*;


public class WriteFile
{
    private static final String USERFILENAME = "users.txt";
    private static final String RECIPEFILENAME = "recipes.txt";

    /** Method for writing a list of users in the users.txt @param users to write users */
    public static void writeUsers(List<User> users)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERFILENAME)))
        {
            for (User user : users)
            {
                if (user instanceof Admin)
                {
                    Admin admin = (Admin) user;
                    writer.write("A;" + admin.getName() + ";" + admin.getPassword());
                }
                else if (user instanceof Author)
                {
                    Author author = (Author) user;
                    writer.write("T;" + author.getName() + ";" + author.getNumRecipes() + ";" +
                            author.getPassword());
                }
                else if (user instanceof Guest)
                {
                    Guest guest = (Guest) user;
                    writer.write("G;" + guest.getName());
                }
                writer.newLine();
            }
            System.out.println("Correctly: " + USERFILENAME);
        }
        catch (IOException e)
        {
            System.out.println("Error typing file: " + USERFILENAME);
            e.printStackTrace();
        }
    }

    public static void saveRecipes(List<Recipe> recipesList)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECIPEFILENAME)))
        {
            for(Recipe recipe : recipesList)
            {
                writer.write(recipe.toFile());
            }
            System.out.println("Correctly: " + RECIPEFILENAME);
        }
        catch (IOException e)
        {
            System.out.println("Error typing file: " + RECIPEFILENAME);
            e.printStackTrace();
        }
    }

}

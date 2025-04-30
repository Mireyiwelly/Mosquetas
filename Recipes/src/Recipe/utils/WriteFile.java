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
                writer.write(user.toFile());
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
                writer.write(recipe.toFile() + "\n");
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

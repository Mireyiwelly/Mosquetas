package Recipe.utils;
import Recipe.classes.*;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

/*Not finished yet*/
public class ReadFile
{
    private static final String recipeFileName = "recipes.txt";
    private static final String userFileName = "users.txt";

    public static void ReadRecipeFile()
    {
        String name;
        int numDiners;
        String preparation;
        List<Ingredient> ingredients;
        float calories;
        char difficultyLevel;
        SpecialDiets specialDiet;
        LocalDate publicationDate;
        int preparationTime;
        User author;
        try (BufferedReader inputFile = new BufferedReader(new FileReader(new File(recipeFileName)))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                String[] recipeData = line.split(";");
                name = recipeData[0];
                numDiners = Integer.parseInt(recipeData[1]);
                preparation = recipeData[2];
                ingredients = List.of(new Ingredient(recipeData[3],
                        Integer.parseInt(recipeData[4]), recipeData[5]));
                calories = Float.parseFloat(recipeData[6]);
                difficultyLevel = recipeData[7].charAt(0);
                specialDiet = SpecialDiets.valueOf(recipeData[8]);
                publicationDate = LocalDate.parse(recipeData[9]);
                preparationTime = Integer.parseInt(recipeData[10]);
                author = new Author(recipeData[11], Integer.parseInt(recipeData[12]), recipeData[14]);

                if(recipeData.length == 16) {
                    Appetizer appetizer;

                    int servingTemperature = recipeData[15].charAt(0);
                    String culturalOrigin = recipeData[16];

                    appetizer = new Appetizer(name, numDiners, preparation, ingredients, calories,
                            difficultyLevel, specialDiet, publicationDate, preparationTime,
                            author, servingTemperature, culturalOrigin);
                }


            }
        } catch (IOException fileError) {
            System.err.println("Error reading file: " + fileError.getMessage());
        }
    }

    public static void ReadUsersFile()
    {

        try (BufferedReader inputFile = new BufferedReader(new FileReader(new File(userFileName)))) {
            String line;
            while ((line = inputFile.readLine()) != null)
            {
                String[] userData = line.split(";");
                //aqui va el invitado
                if(userData.length == 4)
                {
                    //aqui va el autor y el admin
                }


            }
        } catch (IOException fileError) {
            System.err.println("Error reading file: " + fileError.getMessage());
        }
    }
}

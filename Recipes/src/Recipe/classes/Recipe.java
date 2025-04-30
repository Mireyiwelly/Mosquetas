package Recipe.classes;

import java.time.LocalDate;
import java.util.List;


abstract public class Recipe implements Comparable<Recipe>
{
    protected String name;
    protected int numDiners;
    protected String preparation;
    protected List<Ingredient> ingredients;
    protected float calories;
    protected char difficultyLevel; // 'E' for easy, 'M' for medium, 'H' for hard
    protected SpecialDiets specialDiet;
    protected LocalDate publicationDate;
    protected int preparationTime;
    protected User author;
    protected char dishType; // 'A' for Appetizer, 'M' for Main Course, 'D' for Dessert, 'C' for Cocktail

    public Recipe(String name, int numDiners, String preparation, List<Ingredient> ingredients, float calories,
                  char difficultyLevel, SpecialDiets specialDiet, LocalDate publicationDate,
                  int preparationTime, User author, char dishType)
    {
        this.name = name;
        this.numDiners = numDiners;
        this.preparation = preparation;
        this.ingredients = ingredients;
        this.calories = calories;
        this.difficultyLevel = difficultyLevel;
        this.specialDiet = specialDiet;
        this.publicationDate = publicationDate;
        this.preparationTime = preparationTime;
        this.author = author;
        this.dishType = dishType;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getNumDiners()
    {
        return numDiners;
    }

    public void setNumDiners(int numDiners)
    {
        this.numDiners = numDiners;
    }

    public String getPreparation()
    {
        return preparation;
    }

    public void setPreparation(String preparation)
    {
        this.preparation = preparation;
    }

    public float getCalories()
    {
        return calories;
    }

    public void setCalories(float calories)
    {
        this.calories = calories;
    }

    public List<Ingredient> getIngredients()
    {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients)
    {
        this.ingredients = ingredients;
    }

    public char getDifficultyLevel()
    {
        return difficultyLevel;
    }

    public void setDifficultyLevel(char difficultyLevel)
    {
        this.difficultyLevel = difficultyLevel;
    }

    public SpecialDiets getSpecialDiet()
    {
        return specialDiet;
    }

    public void setSpecialDiet(SpecialDiets specialDiet)
    {
        this.specialDiet = specialDiet;
    }

    public LocalDate getPublicationDate()
    {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    public int getPreparationTime()
    {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime)
    {
        this.preparationTime = preparationTime;
    }

    public User getAuthor()
    {
        return author;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }


    public String toFile()
    {
        Author author = (Author) this.author;
        //Aquí junto todos los elementos de los ingredientes ya que no se puede acceder a la clase directamente como tal
        StringBuilder ingredientsInfo = new StringBuilder();
        for (Ingredient ingredient : ingredients)
        {
            ingredientsInfo.append(ingredient.getName()).append(";").append(ingredient.getNumber()).append(";")
                    .append(ingredient.getUnit());
        }
        return dishType + ";" + name + ";" + numDiners + ";" + preparation + ";" + ingredientsInfo + ";" + calories +
                ";" + difficultyLevel + ";" + specialDiet + ";" + publicationDate + ";" + preparationTime + ";" + author.getName() + ";" + author.getNumRecipes() + ";" + author.getPassword();
    }

    public char getDishType()
    {
        return dishType;

    }

    @Override
    public int compareTo(Recipe other)
    {
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString()
    {
        return "Name: " + name + "\n" +
                "Number of diners: " + numDiners + "\n" +
                "Preparation: " + preparation + "\n" +
                "Ingredients: " + ingredients + "\n" +
                "Calories: " + calories + "\n" +
                "Difficulty Level: " + difficultyLevel + "\n" +
                "Special Diet: " + specialDiet + "\n" +
                "Publication Date: " + publicationDate + "\n" +
                "Preparation Time: " + preparationTime + "\n";
    }
}

package Recipe.classes;

import java.time.LocalDate;
import java.util.List;

public class Appetizer extends Recipe
{
    private int servingtemperature;
    private String culturalOrigin;

    public Appetizer(String name, int numDiners, String preparation, List<Ingredient> ingredients, float calories,
                     char difficultyLevel, SpecialDiets specialDiet, LocalDate publicationDate, int preparationTime,
                     User author, int servingtemperature, String culturalOrigin, char dishType)
    {
        super(name, numDiners, preparation, ingredients, calories, difficultyLevel, specialDiet, publicationDate,
                preparationTime, author, dishType);
        this.servingtemperature = servingtemperature;
        this.culturalOrigin = culturalOrigin;
    }

    public int getServingtemperature() {
        return servingtemperature;
    }

    public void setServingtemperature(int servingtemperature) {
        this.servingtemperature = servingtemperature;
    }

    public String getCulturalOrigin() {
        return culturalOrigin;
    }

    public void setCulturalOrigin(String culturalOrigin) {
        this.culturalOrigin = culturalOrigin;
    }
}

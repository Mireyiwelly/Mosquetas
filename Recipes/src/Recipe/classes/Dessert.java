package Recipe.classes;

import java.time.LocalDate;
import java.util.List;

public class Dessert extends Recipe
{
    private boolean baked;
    private int restingTime;
    private int bakingTime;
    private int servingTemperature;


    public Dessert(String name, int numDiners, String preparation, List<Ingredient> ingredients, float calories,
                   char difficultyLevel, SpecialDiets specialDiet, LocalDate publicationDate, int preparationTime,
                   User author, boolean baked, int restingTime, int bakingTime, int servingTemperature, char dishType)
    {
        super(name, numDiners, preparation, ingredients, calories, difficultyLevel,
                specialDiet, publicationDate, preparationTime, author, dishType);
        this.baked = baked;
        this.restingTime = restingTime;
        this.bakingTime = bakingTime;
        this.servingTemperature = servingTemperature;

    }

    public boolean isBaked() {
        return baked;
    }

    public void setBaked(boolean baked) {
        this.baked = baked;
    }

    public int getRestingTime() {
        return restingTime;
    }

    public void setRestingTime(int restingTime) {
        this.restingTime = restingTime;
    }

    public int getBakingTime() {
        return bakingTime;
    }

    public void setBakingTime(int bakingTime) {
        this.bakingTime = bakingTime;
    }

    public int getServingTemperature() {
        return servingTemperature;
    }

    public void setServingTemperature(int servingTemperature) {
        this.servingTemperature = servingTemperature;
    }

}

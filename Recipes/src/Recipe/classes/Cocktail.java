package Recipe.classes;

import java.time.LocalDate;
import java.util.List;

public class Cocktail extends Recipe
{
    private boolean containAlcohol;
    private float alcoholContent;
    private boolean flambe;

    public Cocktail(String name, int numDiners, String preparation, List<Ingredient> ingredients, float calories,
                    char difficultyLevel, SpecialDiets specialDiet, LocalDate publicationDate, int preparationTime,
                    User author, boolean containAlcohol, float alcoholContent, boolean flambe, char dyshType)
    {
        super(name, numDiners, preparation, ingredients, calories, difficultyLevel, specialDiet,
                publicationDate, preparationTime, author, dyshType);
        this.containAlcohol = containAlcohol;
        this.alcoholContent = alcoholContent;
        this.flambe = flambe;
    }

    public boolean isContainAlcohol() {
        return containAlcohol;
    }

    public void setContainAlcohol(boolean containAlcohol) {
        this.containAlcohol = containAlcohol;
    }

    public float getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(float alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public boolean isFlambe() {
        return flambe;
    }

    public void setFlambe(boolean flambe) {
        this.flambe = flambe;
    }

    @Override
    public String toFile()
    {
        return super.toFile() + ";" + containAlcohol + ";" + alcoholContent + ";" + flambe;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n" +
                "Contains Alcohol: " + containAlcohol + "\n" +
                "Alcohol Content: " + alcoholContent + "\n" +
                "Flambe: " + flambe + "\n";
    }
}

package Recipe.classes;

import java.time.LocalDate;
import java.util.List;

public class MainCourse extends Recipe
{
    private String celebrationDish;
    //no se si la guarnicion es un string o que
    private String sideDish;

    public MainCourse(String name, int numDiners, String preparation, List<Ingredient> ingredients, float calories,
                      char difficultyLevel, SpecialDiets specialDiet, LocalDate publicationDate, int preparationTime,
                      User author, String celebrationDish, String sideDish, char dishType)
    {
        super(name, numDiners, preparation, ingredients, calories, difficultyLevel, specialDiet, publicationDate,
                preparationTime, author, dishType);
        this.celebrationDish = celebrationDish;
        this.sideDish = sideDish;
    }

    public String getCelebrationDish() {
        return celebrationDish;
    }

    public void setCelebrationDish(String celebrationDish) {
        this.celebrationDish = celebrationDish;
    }

    public String getSideDish() {
        return sideDish;
    }

    public void setSideDish(String sideDish) {
        this.sideDish = sideDish;
    }

    @Override
    public String toString()
    {
        return super.toString() + "\n" +
                "Celebration Dish: " + celebrationDish + "\n" +
                "Side Dish: " + sideDish + "\n";
    }
}

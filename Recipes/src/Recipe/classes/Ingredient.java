package Recipe.classes;

public class Ingredient
{
    private String name;
    private int number;
    //no se que es lo de unidad
    private String unit;

    public Ingredient(String name, int number, String unit) {
        this.name = name;
        this.number = number;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public int compareTo(Ingredient other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString()
    {
        return "Ingredient: " + name + "\n" +
                "Number: " + number + "\n" +
                "Unit: " + unit + "\n";
    }
}

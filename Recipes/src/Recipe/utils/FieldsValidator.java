package Recipe.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldsValidator
{
    /**
     * Validates if a string is empty or null.
     *
     * @param field the string to validate
     * @return true if the string is empty or null, false otherwise
     */
    public static boolean isEmpty(String field)
    {
        return field == null || field.trim().isEmpty();
    }


    /**
     * Validates if a number is positive.
     *
     * @param number the number to validate
     * @return true if the number is positive, false otherwise
     */
    public static boolean isPositive(Number number)
    {
        return number.doubleValue() > 0;
    }
    /**
     * Validates if a date is in the correct format (DD-MM-YYYY).
     *
     * @param date the date to validate
     * @return true if the date is in the correct format, false otherwise
     */
    public static LocalDate isValidDate(String date)
    {
        if(date == null || date.trim().isEmpty())
        {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try
        {
            return LocalDate.parse(date, formatter);
        }
        catch (Exception e)
        {
            return null;
        }
    }

    /**
     * Validates if a string is a valid unit.
     *
     * @param unit the unitto validate
     * @return true if the unit is valid, false otherwise
     */
    public static boolean isValidUnit(String unit)
    {
        List<String> validUnits = new ArrayList<>();
        validUnits.add("g");
        validUnits.add("l");
        validUnits.add("ml");
        validUnits.add("kg");
        validUnits.add("cl");
        validUnits.add("pcs");

        return validUnits.contains(unit);
    }

    /**
     * Validates if a character is a valid difficulty level.
     *
     * @param difficultyLevel the difficulty level to validate
     * @return true if the difficulty level is valid, false otherwise
     */
    public static boolean isValidDifficultyLevel(char difficultyLevel)
    {
        List<Character> validLevels = new ArrayList<>();
        validLevels.add('E');
        validLevels.add('M');
        validLevels.add('H');
        validLevels.add('e');
        validLevels.add('m');
        validLevels.add('h');

        return validLevels.contains(difficultyLevel);
    }

    /**
     * Validates if a string is a valid special diet.
     *
     * @param diet the special diet to validate
     * @return true if the special diet is valid, false otherwise
     */
    public static boolean isValidSpecialDiet(String diet)
    {
        List<String> validDiets = Arrays.asList("VEGAN", "VEGETARIAN",
                "LACTOSE_FREE", "PALEO", "KETO", "NONE");

        return validDiets.contains(diet.toUpperCase());
    }


    public static boolean isValidYesNo(String input) {
        return input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N");
    }

}

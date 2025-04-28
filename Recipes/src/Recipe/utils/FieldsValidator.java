package Recipe.utils;

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
    public static boolean isPositive(int number)
    {
        return number > 0;
    }
    /**
     * Validates if a date is in the correct format (DD-MM-YYYY).
     *
     * @param date the date to validate
     * @return true if the date is in the correct format, false otherwise
     */
    public static boolean isValidDate(String date)
    {
        String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\d{4}$";
        boolean correct = true;
        if(date.matches(regex))
        {
            String[] dateParts = date.split("-");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            if(month == 2)
            {
                if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                {
                    if(day > 29)
                    {
                        correct = false;
                    }
                }
                else
                {
                    if(day > 28)
                    {
                        correct = false;
                    }
                }
            }
            else if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
            {
                correct = false;
            }
            else if(month > 12 || day > 31)
            {
                correct = false;
            }
        }

        return correct;
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
        diet = diet.toLowerCase();
        List<String> validDiets = Arrays.asList("vegan", "vegetarian",
                "lactose-free", "paleo", "keto");

        return validDiets.contains(diet);
    }

}

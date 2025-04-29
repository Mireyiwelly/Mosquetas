package Recipe.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Recipe.classes.*;

import static Recipe.utils.CreateRecipe.addIngredient;

public class Modify
{
    static Scanner sc = new Scanner(System.in);

    public static void UpdateRecipe(List<Recipe> recipes, Author loggedAuthor )
    {
        System.out.println("Your recipes:");
        boolean hasRecipes = false;
        for (int i = 0; i < recipes.size(); i++) {
            Recipe recipe = recipes.get(i);
            if (recipe.getAuthor().getName().equalsIgnoreCase(loggedAuthor.getName()))
            {
                System.out.println(i + ". " + recipe.getName());
                hasRecipes = true;
            }
        }
        if (!hasRecipes)
        {
            System.out.println("You don't have recipe for modify.");
        }

        System.out.print("Enter the number of the recipe you want to modify: ");
        int number = sc.nextInt();
        sc.nextLine();

        if (number < 0 || number >= recipes.size())
        {
            System.out.println("Invalid recipe number.");
        }

        Recipe selectedRecipe = recipes.get(number);

        boolean continueModifying = true;
        do
        {
            // Mostrar los atributos generales de la receta
            System.out.println("What would you like to update?");
            System.out.println("1. Name");
            System.out.println("2. Preparation");
            System.out.println("3. Number of diners");
            System.out.println("4. Calories");
            System.out.println("5. Difficulty level");
            System.out.println("6. Special diet");
            System.out.println("7. Preparation time");
            System.out.println("8. Ingredients");
            System.out.print("Enter the number of the attribute to modify or 0 to finish: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    // Modificar el nombre de la receta
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    selectedRecipe.setName(newName);
                    break;

                case 2:
                    // Modificar la preparación
                    System.out.print("Enter new preparation: ");
                    String newPreparation = sc.nextLine();
                    selectedRecipe.setPreparation(newPreparation);
                    break;

                case 3:
                    // Modificar el número de comensales
                    System.out.print("Enter new number of diners: ");
                    int newNumDiners = sc.nextInt();
                    sc.nextLine();  //
                    selectedRecipe.setNumDiners(newNumDiners);
                    break;

                case 4:
                    // Modificar las calorías
                    System.out.print("Enter new number of calories: ");
                    float newCalories = sc.nextFloat();
                    sc.nextLine();
                    selectedRecipe.setCalories(newCalories);
                    break;

                case 5:
                    // Modificar el nivel de dificultad
                    System.out.print("Enter new difficulty level: ");
                    char newDifficultyLevel = sc.next().charAt(0);
                    sc.nextLine();  // Limpiar buffer
                    selectedRecipe.setDifficultyLevel(newDifficultyLevel);
                    break;

                case 6:
                    // Modificar la dieta especial
                    System.out.print("Enter new special diet: ");
                    String newSpecialDiet = sc.nextLine();
                    selectedRecipe.setSpecialDiet(SpecialDiets.valueOf(newSpecialDiet.toUpperCase()));
                    break;

                case 7:
                    // Modificar el tiempo de preparación
                    System.out.print("Enter new preparation time: ");
                    int newPreparationTime = sc.nextInt();
                    sc.nextLine();  // Limpiar buffer
                    selectedRecipe.setPreparationTime(newPreparationTime);
                    break;

                case 8:
                    // Modificar los ingredientes
                    System.out.println("To modify ingredients, re-enter them.");
                    List<Ingredient> newIngredients = new ArrayList<>();
                    System.out.print("How many ingredients do you want to add? ");
                    int numIngredients = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer

                    for (int i = 0; i < numIngredients; i++)
                    {
                        newIngredients.add(addIngredient());
                    }

                    selectedRecipe.setIngredients(newIngredients);
                    break;

                case 0:
                    // Finalizar
                    System.out.println("Finished updating the recipe.");
                    continueModifying = false;
                    break;

                default:
                    // Opción no válida
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

            // Dependiendo del tipo de receta, mostrar atributos específicos para modificar
            // Subtipo: Appetizer
            if (selectedRecipe instanceof Appetizer)
            {
                boolean continueSubtypeModifying = true;
                do
                {
                    System.out.println("Would you like to update specific Appetizer attributes?");
                    System.out.println("1. Serving temperature");
                    System.out.println("2. Cultural origin");
                    System.out.print("Enter the number of the attribute to modify or 0 to skip: ");
                    int appChoice = sc.nextInt();
                    sc.nextLine();

                    switch (appChoice)
                    {
                        case 1:
                            System.out.print("Enter new serving temperature: ");
                            int newServingTemperature = sc.nextInt();
                            sc.nextLine();
                            ((Appetizer) selectedRecipe).setServingtemperature(newServingTemperature);
                            break;
                        case 2:
                            System.out.print("Enter new cultural origin: ");
                            String newCulturalOrigin = sc.nextLine();
                            ((Appetizer) selectedRecipe).setCulturalOrigin(newCulturalOrigin);
                            break;
                        case 0:
                            continueSubtypeModifying = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } while (continueSubtypeModifying);
            }

            // Subtipo: Cocktail
            else if (selectedRecipe instanceof Cocktail)
            {
                boolean continueSubtypeModifying = true;
                do
                {
                    System.out.println("Would you like to update specific Cocktail attributes?");
                    System.out.println("1. Alcohol content");
                    System.out.println("2. Flambe");
                    System.out.print("Enter the number of the attribute to modify (or 0 to skip): ");
                    int cocktailChoice = sc.nextInt();
                    sc.nextLine();

                    switch (cocktailChoice) {
                        case 1:
                            System.out.print("Enter new alcohol content: ");
                            float newAlcoholContent = sc.nextFloat();
                            sc.nextLine();
                            ((Cocktail) selectedRecipe).setAlcoholContent(newAlcoholContent);
                            break;
                        case 2:
                            System.out.print("Is it flambe? (Y/N): ");
                            String isFlambeStr = sc.nextLine();
                            boolean isFlambe = isFlambeStr.equalsIgnoreCase("Y");
                            ((Cocktail) selectedRecipe).setFlambe(isFlambe);
                            break;
                        case 0:
                            continueSubtypeModifying = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } while (continueSubtypeModifying);
            }

            // Subtipo: MainCourse
            else if (selectedRecipe instanceof MainCourse)
            {
                boolean continueSubtypeModifying = true;
                do
                {
                    System.out.println("Would you like to update specific Main Course attributes?");
                    System.out.println("1. Celebration dish");
                    System.out.println("2. Side dish");
                    System.out.print("Enter the number of the attribute to modify (or 0 to skip): ");
                    int mainCourseChoice = sc.nextInt();
                    sc.nextLine();

                    switch (mainCourseChoice)
                    {
                        case 1:
                            System.out.print("Enter new celebration dish: ");
                            String newCelebrationDish = sc.nextLine();
                            ((MainCourse) selectedRecipe).setCelebrationDish(newCelebrationDish);
                            break;
                        case 2:
                            System.out.print("Enter new side dish: ");
                            String newSideDish = sc.nextLine();
                            ((MainCourse) selectedRecipe).setSideDish(newSideDish);
                            break;
                        case 0:
                            continueSubtypeModifying = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } while (continueSubtypeModifying);
            }

            // Subtipo: Dessert
            else if (selectedRecipe instanceof Dessert)
            {
                boolean continueSubtypeModifying = true;
                do
                {
                    System.out.println("Would you like to update specific Dessert attributes?");
                    System.out.println("1. Is it baked?");
                    System.out.println("2. Resting time");
                    System.out.println("3. Baking time");
                    System.out.println("4. Serving temperature");
                    System.out.print("Enter the number of the attribute to modify (or 0 to skip): ");
                    int dessertChoice = sc.nextInt();
                    sc.nextLine();

                    switch (dessertChoice)
                    {
                        case 1:
                            System.out.print("Is it baked? (Y/N): ");
                            String isBakedStr = sc.nextLine();
                            boolean isBaked = isBakedStr.equalsIgnoreCase("Y");
                            ((Dessert) selectedRecipe).setBaked(isBaked);
                            break;
                        case 2:
                            System.out.print("Enter new resting time: ");
                            int newRestingTime = sc.nextInt();
                            sc.nextLine();
                            ((Dessert) selectedRecipe).setRestingTime(newRestingTime);
                            break;
                        case 3:
                            System.out.print("Enter new baking time: ");
                            int newBakingTime = sc.nextInt();
                            sc.nextLine();
                            ((Dessert) selectedRecipe).setBakingTime(newBakingTime);
                            break;
                        case 4:
                            System.out.print("Enter new serving temperature: ");
                            int newDessertTemp = sc.nextInt();
                            sc.nextLine();
                            ((Dessert) selectedRecipe).setServingTemperature(newDessertTemp);
                            break;
                        case 0:
                            continueSubtypeModifying = false;
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } while (continueSubtypeModifying);
            }

            // Preguntar si se desea continuar
            System.out.print("Do you want to update another attribute? (Y/N): ");
            String another = sc.nextLine().trim();
            if (another.equalsIgnoreCase("N")) {
                continueModifying = false;
                System.out.println("Finished updating the recipe.");
            }
        } while (continueModifying);
    }
}

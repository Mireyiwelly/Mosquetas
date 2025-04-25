package Recipe.utils;
import java.util.Scanner;

import Recipe.classes.Author;
import Recipe.main.AppMenuOptions;
import Recipe.main.LoginOptions;

public class Menu {
    public static LoginOptions MenuLogIn() {
        Scanner sc = new Scanner(System.in);

        LoginOptions userOption;

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      RECIPE MANAGEMENT SYSTEM    ║");
        System.out.println("╚══════════════════════════════════╝");

        System.out.println("Welcome to the Recipe Management System");
        System.out.println("1. Login as Author");
        System.out.println("2. Login as Guest");
        System.out.println("3. Create New Author Account");
        System.out.println("4. Exit");

        System.out.println("Please select an option:");
        userOption = LoginOptions.values()[sc.nextInt() - 1];

        return userOption;
    }

    public static AppMenuOptions AppOptions()
    {
        Scanner sc = new Scanner(System.in);

        AppMenuOptions appOption;

        System.out.println("Welcome back");
        System.out.println("1. Add Recipe");
        System.out.println("2. Modify Recipe");
        System.out.println("3. Delete Recipe");
        System.out.println("4. Search Recipe");

        System.out.println("Please select an option:");
        appOption = AppMenuOptions.values()[sc.nextInt() - 1];

        return appOption;
    }
}

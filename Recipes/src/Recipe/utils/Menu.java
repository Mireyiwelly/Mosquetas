package Recipe.utils;
import java.util.Scanner;
import Recipe.main.OptionsMenu;

public class Menu {
    public static OptionsMenu MenuLogIn() {
        Scanner sc = new Scanner(System.in);

        OptionsMenu userOption;

        System.out.println("Welcome to the Recipe Management System");
        System.out.println("1. Login as Author");
        System.out.println("2. Login as Guest");
        System.out.println("3. Create New Author Account");
        System.out.println("4. Exit");

        System.out.println("Please select an option:");
        userOption = OptionsMenu.values()[sc.nextInt() - 1];

        return userOption;
    }
}

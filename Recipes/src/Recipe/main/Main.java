package Recipe.main;
import Recipe.utils.Menu;

public class Main
{
    public static void main(String[] args)
    {
        OptionsMenu optionUser;
        do {
            optionUser = Menu.MenuLogIn();
            switch (optionUser)
            {
                case AUTHOR:
                    System.out.println("Author login selected.");
                    // Implement author login functionality here
                    break;
                case GUEST:
                    System.out.println("Guest login selected.");
                    // Implement guest login functionality here
                    break;
                case NEW_AUTHOR:
                    System.out.println("New author account creation selected.");
                    // Implement new author account creation functionality here
                    break;
                case EXIT:
                    System.out.println("Exiting the application.");
                    // Implement exit functionality here
                    break;
                default:
                    System.out.println("Invalid option selected.");
            }
        } while(optionUser != OptionsMenu.EXIT);

    }
}
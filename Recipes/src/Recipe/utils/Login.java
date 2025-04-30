package Recipe.utils;

import Recipe.classes.Admin;
import Recipe.classes.Author;
import Recipe.classes.User;

import java.util.List;
import java.util.Scanner;

public class Login {
    static Scanner sc = new Scanner(System.in);

    public static Author LoginAuthor(List<User> users)
    {
        String name, password;
        Author currentUser = null;
        Boolean correct = false;
        System.out.println("Enter your credentials.");
        name = sc.nextLine();
        System.out.println("Password:");
        password = sc.nextLine();

        if(!name.equals("anonimo"))
        {
            for(User u: users)
            {
                if(u instanceof Author)
                {
                    if(u.getName().equals(name) && u.getPassword().equals(u.EncryptPassword(password)))
                    {
                        currentUser = (Author) u;
                        correct = true;
                    }
                }
            }
            if(!correct)
                System.out.println("Invalid user or password");
        }
        else
            System.out.println("You cannot be anonimo ;)");
        return currentUser;
    }

    public static void SignInAuthor(List<User> users)
    {
        String name = "", password;
        boolean found = false;
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
                /*^               # start-of-string
                (?=.*[0-9])       # a digit must occur at least once
                (?=.*[a-z])       # a lower case letter must occur at least once
                 (?=.*[A-Z])      # an upper case letter must occur at least once
                (?=.*[@#$%^&+=])  # a special character must occur at least once
                (?=\S+$)          # no whitespace allowed in the entire string
                .{8,}             # anything, at least eight places though
                $                 # end-of-string
        *
        */
        
        do {
            System.out.println("Enter your nickname: ");
            name = sc.nextLine();
            found = false;

            if(!name.equalsIgnoreCase("anonimo") && !name.trim().isEmpty())
            {
                for(User u : users)
                {
                    if(u.getName().equalsIgnoreCase(name))
                    {
                        System.out.println("Nickname already on use.");
                        found= true;
                    }
                }
            }
            else
            {
                found = true;
                System.out.println("Can't use this nickname");
            }
        }while(found);
        if(!found)
        {
            do {
                System.out.println("Enter your password: ");
                password = sc.nextLine();

                if(!password.matches(regex))
                    System.out.println("Password must be minimus 8 characters and has to contains at least" +
                            "one upperccase, one lowercase,  one number, one special character and no whitespace");

            }
            while(!password.matches(regex));
            users.add(new Author(name,0 ,password));
            
        }
    }


}

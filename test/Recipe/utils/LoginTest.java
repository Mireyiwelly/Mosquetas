package Recipe.utils;

import Recipe.classes.Author;
import Recipe.classes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class LoginTest {

    /**
     * Test the valid input for signing in an author.
     */
    @Test
    void testSignInAuthorValidInput() {
        List<User> users = new ArrayList<>();

        String input = "NuevoAutor\nPassword1#\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Login.SignInAuthor(users, scanner);

        assertEquals(1, users.size());
        assertTrue(users.getFirst() instanceof Author);
        assertEquals("NuevoAutor", users.getFirst().getName());
    }

    /**
     * Test the name already used for signing in an author.
     */
    @Test
    void testSignInAuthorNameAlreadyUsed() {
        List<User> users = new ArrayList<>();
        users.add(new Author("repited", 0, "Password1#"));


        String input = "repited\nnewAuthor\nPassword1#\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Login.SignInAuthor(users, sc);

        assertEquals(2, users.size());
        assertEquals("newAuthor", users.get(1).getName());
    }

    /**
     * Test the empty name for signing in an author.
     */
    // Volver a probar
    @Test
    void testSignInAuthorEmptyNameValidPassword() {
        List<User> users = new ArrayList<>();

        String input = "\nPassword1#\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Login.SignInAuthor(users, scanner);

        assertEquals(1, users.size());
        assertEquals("", users.getFirst().getName());
    }

    /**
     * Test the empty password for signing in an author.
     */
    @Test
    void testSignInAuthorValidNameInvalidPassword() {
        List<User> users = new ArrayList<>();

        String input = "newAuthor\npassword\nPassword1#\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Login.SignInAuthor(users, scanner);
        assertEquals(1, users.size());
        assertEquals("newAuthor", users.getFirst().getName());
    }
    /**
     * Test the blank name for signing in an author.
     */
    @Test
    void testSignInAuthorBlankName() {
        List<User> users = new ArrayList<>();

        String input = "    \nPassword1#\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Login.SignInAuthor(users, scanner);

        assertEquals(1, users.size());
        assertEquals("    ", users.getFirst().getName());
    }

    @Test
    void testLoginPasswordCorrect()
    {

        Author a = new Author("Mireya", 0, "Password1#");
        List<User> users = new ArrayList<>();
        users.add(a);

        String input = "Lucas\nPassword1#\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Author logged = Login.LoginAuthor(users, sc);

        assertNull(logged, "Login should fail when username is incorrect");
    }

    @Test
    void testLoginUserNameCorrect()
    {
        Author a = new Author("Mireya", 0, "Password1#");
        List<User> users = new ArrayList<>();
        users.add(a);

        String input = "Mireya\nPassword56#\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Author logged = Login.LoginAuthor(users, sc);

        assertNull(logged, "Login should fail when password is incorrect");
    }

    @Test
    void testUserNameAnonimo()
    {
        Author a = new Author("Mireya", 0, "Password1#");
        List<User> users = new ArrayList<>();
        users.add(a);

        String input = "anonimo\nPassword56#\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Author logged = Login.LoginAuthor(users, sc);

        assertNull(logged, "Login should fail when username is anonimo");
    }

    @Test
    void testNullNameNullPassword()
    {
        Author a = new Author("Mireya", 0, "Password1#");
        List<User> users = new ArrayList<>();
        users.add(a);

        String input = "\n\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Author logged = Login.LoginAuthor(users, sc);

        assertNull(logged, "Login should fail when no username or password were written");
    }

    @Test
    void testLoginAllCorrect()
    {
        List<User> users = new ArrayList<>();
        users.add(new Author("Mireya", 0, "Password1#"));


        String input = "Mireya\nPassword1#\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Author logged = Login.LoginAuthor(users, sc);

        assertNotNull(logged, "Login should be correct");
    }

}
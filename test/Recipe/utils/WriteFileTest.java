package Recipe.utils;

import Recipe.classes.Author;
import Recipe.classes.User;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static Recipe.utils.WriteFile.USERFILENAME;
import static Recipe.utils.WriteFile.saveUsers;
import static org.junit.jupiter.api.Assertions.*;

class WriteFileTest {
    @Test
    public void testSaveUsersSuccess() {
        // Preparar: Crear una lista de usuarios
        List<User> users = new ArrayList<>();
        users.add(new Author("Hector",0,"Password123,"));

        // Redirigir la salida estándar a un ByteArrayOutputStream para capturar lo impreso
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        // Redirigir System.out para capturar lo que se imprime
        PrintStream originalOut = System.out;  // Guardar la salida original
        System.setOut(printStream);  // Redirigir la salida a nuestro flujo controlado

        // Ejecutar: Llamar al método que estamos probando
        saveUsers(users);  // Aquí no es necesario pasar un PrintStream, ya que System.out está redirigido

        // Restaurar la salida original
        System.setOut(originalOut);

        // Verificar: Comprobar que el mensaje correcto fue impreso
        String expectedOutput = "Correctly: " + WriteFile.USERFILENAME;
        assertEquals(expectedOutput, byteArrayOutputStream.toString().trim());
    }

    @Test
    public void testSaveUsersEmptyList() {
        // Preparar: Crear una lista vacía de usuarios
        List<User> users = new ArrayList<>();

        // Redirigir la salida estándar a un ByteArrayOutputStream para capturar lo impreso
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        // Redirigir System.out para capturar lo que se imprime
        PrintStream originalOut = System.out;  // Guardar la salida original
        System.setOut(printStream);  // Redirigir la salida

        // Ejecutar: Llamar al método que estamos probando
        saveUsers(users);  // Pasamos una lista vacía

        // Restaurar la salida original
        System.setOut(originalOut);

        // Verificar: Comprobar que la salida es correcta para una lista vacía
        String expectedOutput = "Correctly: " + WriteFile.USERFILENAME;
        assertEquals(expectedOutput, byteArrayOutputStream.toString().trim());
    }

    @Test
    public void testSaveUsersMultipleUsers() {
        // Preparar: Crear una lista de usuarios con varios elementos
        List<User> users = new ArrayList<>();
        users.add(new Author("Mireya",0, "Password123"));
        users.add(new Author("Juan",0, "1234Password"));
        users.add(new Author("Maria",0, "TestPassword"));

        // Redirigir la salida estándar a un ByteArrayOutputStream para capturar lo impreso
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        // Redirigir System.out para capturar lo que se imprime
        PrintStream originalOut = System.out;  // Guardar la salida original
        System.setOut(printStream);  // Redirigir la salida

        // Ejecutar: Llamar al método que estamos probando
        saveUsers(users);  // Pasamos una lista con múltiples usuarios

        // Restaurar la salida original
        System.setOut(originalOut);

        // Verificar: Comprobar que la salida contiene los mensajes esperados
        String expectedOutput = "Correctly: " + WriteFile.USERFILENAME;
        String actualOutput = byteArrayOutputStream.toString().trim();

        // Verifica que al menos el mensaje esperado se haya impreso
        assertTrue(actualOutput.contains("Correctly: " + WriteFile.USERFILENAME));
    }
    @Test
    public void testSaveUsersSpecialCharacters() {
        // Preparar: Crear una lista de usuarios con nombres que contienen caracteres especiales
        List<User> users = new ArrayList<>();
        users.add(new Author("Mireya@123",0, "Password123"));
        users.add(new Author("Juan#123",0, "1234Password"));

        // Redirigir la salida estándar a un ByteArrayOutputStream para capturar lo impreso
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        // Redirigir System.out para capturar lo que se imprime
        PrintStream originalOut = System.out;  // Guardar la salida original
        System.setOut(printStream);  // Redirigir la salida

        // Ejecutar: Llamar al método que estamos probando
        saveUsers(users);  // Pasamos una lista con usuarios con caracteres especiales

        // Restaurar la salida original
        System.setOut(originalOut);

        // Verificar: Comprobar que la salida es correcta y contiene los caracteres especiales
        String expectedOutput = "Correctly: " + WriteFile.USERFILENAME;
        String actualOutput = byteArrayOutputStream.toString().trim();

        assertTrue(actualOutput.contains("Correctly: " + WriteFile.USERFILENAME));
    }
    @Test
    public void testSaveUsersEmptyUsername() {
        // Preparar: Crear una lista de usuarios con un nombre vacío
        List<User> users = new ArrayList<>();
        users.add(new Author("",0, "Password123,"));

        // Redirigir la salida estándar a un ByteArrayOutputStream para capturar lo impreso
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        // Redirigir System.out para capturar lo que se imprime
        PrintStream originalOut = System.out;  // Guardar la salida original
        System.setOut(printStream);  // Redirigir la salida

        // Ejecutar: Llamar al método que estamos probando
        saveUsers(users);  // Pasamos una lista con un nombre de usuario vacío

        // Restaurar la salida original
        System.setOut(originalOut);

        // Verificar: Comprobar que la salida se produce correctamente
        String expectedOutput = "Correctly: " + WriteFile.USERFILENAME;
        assertEquals(expectedOutput, byteArrayOutputStream.toString().trim());
    }
}
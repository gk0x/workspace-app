package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/workspace";
        String user = "root"; // nazwa użytkownika
        String password = ""; // hasło

        try {
            // Połączenie z bazą danych
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Połączenie z bazą danych udane.");

            // Tutaj można wykonywać operacje na bazie danych, np. wykonywać zapytania SQL


            // Zamykanie połączenia
            con.close();
            System.out.println("Połączenie z bazą danych zamknięte.");
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas połączenia z bazą danych: " + e.getMessage());
        }
    }
}

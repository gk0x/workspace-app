package org.example;

import com.mysql.cj.jdbc.DatabaseMetaData;
import org.example.models.DBConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection con = DBConnection.getConnection();
            System.out.println("Połączenie z bazą danych udane.");
            // Tutaj można wykonywać operacje na bazie danych, np. wykonywać zapytania SQL
            con.close();
            System.out.println("Połączenie z bazą danych zamknięte.");
        } catch (SQLException e) {
            System.out.println("Wystąpił błąd podczas połączenia z bazą danych: " + e.getMessage());
        }
    }

}

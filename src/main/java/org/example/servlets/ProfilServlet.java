package org.example.servlets;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;
import org.example.models.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/dodaj-awatar")
@MultipartConfig

    public class ProfilServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Connection conn = null; // deklaracja obiektu połączenia
            try {
                conn = DBConnection.getConnection(); // pobranie połączenia z bazy danych
                Part part = (Part) request.getPart("awatar");
                String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                InputStream fileContent = part.getInputStream();
                // Tu można wywołać operację zapisania pliku na serwerze
                // oraz zaktualizowania rekordu użytkownika w bazie danych
                String filePath = "/avatars/" + fileName; // ścieżka, w której plik zostanie zapisany na serwerze

                // zapis pliku na serwerze
                Files.copy(fileContent, Paths.get(getServletContext().getRealPath(filePath)));

                // zapis ścieżki do pliku w bazie danych
                int userId = (int) request.getSession().getAttribute("user_id");
                String sql = "UPDATE pracownicy SET avatar_path = ? WHERE id = ?";
                try (PreparedStatement statement = conn.prepareStatement(sql)) {
                    statement.setString(1, filePath);
                    statement.setInt(2, userId);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close(); // zwolnienie połączenia z bazą danych
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

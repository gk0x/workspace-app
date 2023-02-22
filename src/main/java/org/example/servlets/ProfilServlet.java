package org.example.servlets;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

@WebServlet("/dodaj-awatar")
@MultipartConfig
public class ProfilServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = (Part) request.getPart("awatar");
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = part.getInputStream();
        // Tu można wywołać operację zapisania pliku na serwerze
        // oraz zaktualizowania rekordu użytkownika w bazie danych
    }
}

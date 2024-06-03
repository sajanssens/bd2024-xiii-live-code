package com.infosupport;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/contacts/42")
public class ContactsResource extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("""
                [
                    {
                      "id": 42,
                      "firstName": "Bram",
                      "surname": "Janssens",
                      "gender": "Male",
                      "email": "test@test.com"
                    }
                  ]
                """);
    }
}

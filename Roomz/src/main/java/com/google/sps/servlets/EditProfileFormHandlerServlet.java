package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-profile-form-handler")
public class EditProfileFormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String firstName = request.getParameter("first-name-input");
    String lastName = request.getParameter("last-name-input");
    String aboutMe = request.getParameter("about-me-input");
    String info = request.getParameter("input");
    String phoneNumber = request.getParameter("phone-number-input");
    String email = request.getParameter("email-input");
    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + firstName);
    System.out.println("You submitted: " + lastName);
    System.out.println("You submitted: " + aboutMe);
    System.out.println("You submitted: " + info);
    System.out.println("You submitted: " + phoneNumber);
    System.out.println("You submitted: " + email);
    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: " + firstName);
    response.getWriter().println("You submitted: " + lastName);
    response.getWriter().println("You submitted: " + aboutMe);
    response.getWriter().println("You submitted: " + info);
    response.getWriter().println("You submitted: " + phoneNumber);
    response.getWriter().println("You submitted: " + email);
    }
}
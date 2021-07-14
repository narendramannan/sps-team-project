package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/edit-listing-form-handler")
public class EditListingFormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String location = request.getParameter("location-input");
    String gallery = request.getParameter("gallery-input");
    String numBedrooms = request.getParameter("num-bedrooms-input");
    String numRoommates = request.getParameter("current-num-roommate-input");
    String vacancies = request.getParameter("vacancies-input");
    String description = request.getParameter("description-input");
    String lease = request.getParameter("lease-term-input");
    String price = request.getParameter("price-input");
    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + location);
    System.out.println("You submitted: " + gallery);
    System.out.println("You submitted: " + numBedrooms);
    System.out.println("You submitted: " + numRoommates);
    System.out.println("You submitted: " + vacancies);
    System.out.println("You submitted: " + description);
    System.out.println("You submitted: " + lease);
    System.out.println("You submitted: $" + price);
    // Write the value to the response so the user can see it.
    response.getWriter().println("You submitted: " + location);
    response.getWriter().println("You submitted: " + gallery);
    response.getWriter().println("You submitted: " + numBedrooms);
    response.getWriter().println("You submitted: " + numRoommates);
    response.getWriter().println("You submitted: " + vacancies);
    response.getWriter().println("You submitted: " + description);
    response.getWriter().println("You submitted: " + lease);
    response.getWriter().println("You submitted: $" + price);
    }
}
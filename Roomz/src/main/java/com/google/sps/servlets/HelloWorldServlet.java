package com.google.sps.servlets;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/quotes")
public class HelloWorldServlet extends HttpServlet {

    

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // response.setContentType("text/html;");
    // response.getWriter().println("Not everything that counts can be counted and, not everything that can be counted counts");
    String [] quotes = {
        "Do what you can\'t",
        "Not everything that counts can be counted and not everything that can be counted counts",
        "What you achieve inwardly will change outer reality",
        "The most important meeting you can have today, is with yourself, dont skip it!"
    };
    String json = convertToJsonUsingGson(quotes);
    response.setContentType("application/json");
    response.getWriter().println(json);

  }

  private String convertToJsonUsingGson(String[] javaObj) {
    Gson gson = new Gson();
    String json = gson.toJson(javaObj);
    return json;
  }
}

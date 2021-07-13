package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/** Servlet responsible for creating new user profile. */
@WebServlet("/new-profile")
public class CreateProfileServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Sanitize user input to remove HTML tags and JavaScript.
    String fullname = Jsoup.clean(request.getParameter("fullname"), Whitelist.none());
    String email = Jsoup.clean(request.getParameter("email"), Whitelist.none());
    String bio = Jsoup.clean(request.getParameter("bio"), Whitelist.none());
    String age = Jsoup.clean(request.getParameter("age"), Whitelist.none());
    String gender = Jsoup.clean(request.getParameter("gender"), Whitelist.none());


    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Users");
    FullEntity userEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("fullname", fullname)
            .set("email", email)
            .set("bio", bio)
            .set("age", age)
            .set("gender", gender)
            .build();
    datastore.put(userEntity);

    response.sendRedirect("/roommates.html");
    
  }
}

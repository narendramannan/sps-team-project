// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.gson.Gson;
import com.google.sps.data.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for loading users. */
@WebServlet("/load-users")
public class LoadUsersServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Users").build();
    QueryResults<Entity> results = datastore.run(query);

    List<User> users = new ArrayList<>();
    while (results.hasNext()) {
      Entity entity = results.next();
    //   long id = entity.getKey().getId();
    String age = entity.getString("age");  
    String fullname = entity.getString("fullname");
      
      String bio = entity.getString("bio");
      String email = entity.getString("email");
      String gender = entity.getString("gender");
    
    //   System.out.println(age);
    //   System.out.println(email);
    //   System.out.println(gender);
    //   System.out.println(bio);
    //   System.out.println(fullname);
      
      User user = new User(fullname, age, bio, email, gender);
      users.add(user);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(users));
  }
}
package servlets;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Role;
import models.User;
import services.RoleService;
import services.UserService;


public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService us = new UserService();

        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
            getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String action = request.getParameter("action");
        if (action != null && action.equals("delete")) {
            String selectedUsername = request.getParameter("email");
            try {
                us.delete(selectedUsername);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action != null && action.equals("edit")) {
            String selectedUsername = request.getParameter("email");
            try {
                User user = us.get(selectedUsername);
                request.setAttribute("user", user);
                getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService us = new UserService();
        RoleService rs = new RoleService();
        String action = request.getParameter("action");

        if (action != null && action.equals("add")) {
            String email = request.getParameter("email");
            String fname = request.getParameter("first_name");
            String lname = request.getParameter("last_name");
            String password = request.getParameter("password");
            String roleId = request.getParameter("roleId");
            String roleName = null;

        try {
            switch (roleId) {
                case "1":
                    roleName = "System admin";
                    break;
                case "2":
                    roleName = "Regular user";
                    break;
                case "3":
                    roleName = "Company admin";
            }
        }catch (Exception e) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("message", "Error adding user");
            }

            Role role = new Role(Integer.parseInt(roleId), roleName);

            try {
                switch (action) {
                    case "add":
                        us.insert(email, true, fname, lname, password, roleName);
                        break;
                    case "edit":
                        us.update(email, true, fname, lname, password, roleName);
                        break;
                        case "delete":
                        us.delete(email);
                }
            } catch (Exception e) {
                    Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, e);
                    request.setAttribute("message", "Error adding user");
            }
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}


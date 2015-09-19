package servlets;

import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();
    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messageMap", messages);

        if (username.isEmpty() || password.isEmpty()) {
            messages.put("fieldIsEmpty", "Fields cannot not be empty");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        user = userService.getUser(username);

        if (user.getPassword().equals(password)) {
            req.setAttribute("name", username);
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            messages.put("noUser", "This user is not registered. Please use link below to register!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}




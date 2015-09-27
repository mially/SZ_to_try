package servlets;

import services.UserService;
import utils.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    Validator validator = new Validator();
    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");

        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messageMap", messages);

        if (username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            messages.put("fieldIsEmpty", "Fields cannot not be empty");
        }

        if (validator.loginValidation(username) && validator.passwordValidation(password)
            && validator.passwordMatch(password, repeatPassword)) {

            req.setAttribute("name", username);
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            userService.createUser(username, password);
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } else {
            if(!validator.loginValidation(username)) {messages.put("usernameErrorMessage", "Username should be 3 and more symbols");}
            if(!validator.passwordValidation(password)) {messages.put("passwordErrorMessage", "Password should be 5 and more symbols and contain at least 1 number");}
            if(!validator.passwordMatch(password, repeatPassword)) {
                messages.put("repeatPasswordErrorMessage", "Passwords do not match");}

            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}




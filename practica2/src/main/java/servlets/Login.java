package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
import models.UserService;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    private final UserService uS = UserService.getInstance();
    
    protected void loginRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            User user = new User(request.getParameter("username"),
                    request.getParameter("password"));
            boolean logged = uS.userLogin(user);
            
            if (!logged) {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
            else {
                HttpSession session = request.getSession();
                user.encryptPassword();
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(3000);
                response.sendRedirect(request.getContextPath() + "/menu.jsp");
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loginRequest(request, response);
    }
}

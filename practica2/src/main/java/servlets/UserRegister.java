package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.UserService;


@WebServlet(name = "UserRegister", urlPatterns = {"/UserRegister"})
public class UserRegister extends HttpServlet {

    private final UserService uS = UserService.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection connection = null;
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            boolean registered = uS.userRegister(username, password);
            if(registered) {
                out.println("<h1>Registrado con éxito</h1>");
                out.println("<p><a href=\"/practica2\">Inicio</a>");
            }
            else {
                RequestDispatcher dispatcher = request.
                getRequestDispatcher("error.jsp");
                
                dispatcher.forward(request, response);
                //response.sendRedirect(request.getContextPath() + "/error.jsp?");
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

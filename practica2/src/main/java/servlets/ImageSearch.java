package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Image;
import models.ImageService;

@WebServlet(name = "ImageSearch", urlPatterns = {"/ImageSearch"})
public class ImageSearch extends HttpServlet {
    
    private final ImageService iS = ImageService.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String title = request.getParameter("title");
            List<Image> result = iS.searchByTitle(title);
            RequestDispatcher dispatcher = null;
            if (result != null) {
                 request.setAttribute("imageList", result);   
                 dispatcher = request.
                     getRequestDispatcher("imageList.jsp");           
                 dispatcher.forward(request, response);
            }   
            else {
                dispatcher = request.
                     getRequestDispatcher("error.jsp");           
                 dispatcher.forward(request, response);
            }
        }
        catch (Exception e) {
                System.err.println(e.getMessage());
                response.sendRedirect(request.getContextPath() + "/error.jsp");
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

}

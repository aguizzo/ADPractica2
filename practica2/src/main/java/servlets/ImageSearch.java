package servlets;

import java.io.IOException;
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
        try {
            String title = request.getParameter("title");
            String keywords = request.getParameter("keywords");
            String author = request.getParameter("author");
            String captureDate = request.getParameter("captureDate");
            
            List<Image> result = iS.
                    searchImages(title, keywords, author, captureDate);
            request.setAttribute("imageList", result);   
            RequestDispatcher dispatcher = request.
                    getRequestDispatcher("imageList.jsp");           
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            response.sendRedirect("Error?code=23");
        } 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

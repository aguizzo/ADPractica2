package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

import models.ImageService;

@WebServlet(name = "ImageModify", urlPatterns = {"/ImageModify"})
public class ImageModify extends HttpServlet {
    
    private final ImageService iS = ImageService.getInstance();

    protected void imageModifyRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {             
            String id = request.getParameter("ID");
            int ID = Integer.parseInt(id);
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            String keywords = request.getParameter("keywords");
            String author = request.getParameter("author");
            String captureDate = request.getParameter("captureDate");
                        
            boolean itworks = iS.modifyImage(ID, title, description, keywords, author, captureDate);
            if (itworks) {
                out.println("<h1>Imagen eliminada con éxito</h1>");
                out.println("<p><a href=\"/practica2/menu.jsp\">Menú</a>");
            }
            else {
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    private String getDate() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        return simpleDate.format(new Date());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        imageModifyRequest(request, response);
    }

}

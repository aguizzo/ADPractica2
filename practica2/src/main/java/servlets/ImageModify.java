package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ImageService;
import models.User;

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
            String uploader = request.getParameter("uploader");
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            if (user.getUsername().equals(uploader)) {    
                boolean modified = iS.modifyImage(ID, title, description,
                    keywords, author, captureDate);
                if (modified) {
                    out.println("<h1>Imagen modficada con éxito</h1>");
                    out.println("<p><a href=\"/practica2/menu.jsp\">Menú</a>");
                }
                else {
                    response.sendRedirect("Error?code=26");
                }
            }
            else {
                response.sendRedirect("Error?code=403");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Error?code=0");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        imageModifyRequest(request, response);
    }

}

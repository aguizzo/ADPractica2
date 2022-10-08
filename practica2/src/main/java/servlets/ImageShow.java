package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Image;
import models.ImageService;


@WebServlet(name = "ImageShow", urlPatterns = {"/ImageShow"})
public class ImageShow extends HttpServlet {
    
    private final ImageService iS = ImageService.getInstance();
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getImageRequest(request, response);
    }
    
    protected void getImageRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = null;
            String idParam = request.getParameter("ID");
            int id  = Integer.parseInt(idParam); 
            Image im = iS.getImage(id);
            if (im != null) {
                 request.setAttribute("image", im);   
                 dispatcher = request.
                     getRequestDispatcher("imageShow.jsp");           
                 dispatcher.forward(request, response);
            }   
            else {
                int errorCode = 20;
                request.setAttribute("code", errorCode);
                response.sendRedirect(request.getContextPath() +
                    "/error.jsp?code=20");
            }
        }
        catch (Exception e) {
                System.err.println(e.getMessage());
                response.sendRedirect(request.getContextPath() + "/error.jsp");
        } 
    }

}

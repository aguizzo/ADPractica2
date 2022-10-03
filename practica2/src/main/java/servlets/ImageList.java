package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Image;
import models.ImageService;

@WebServlet(name = "ImageList", urlPatterns = {"/ImageList"})
public class ImageList extends HttpServlet {
    
    private final ImageService iS = ImageService.getInstance();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String idParam = request.getParameter("ID");
            if (idParam == null)
                getList(request, response);
            else
                out.println(idParam);
               
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
    public String getServletInfo() {
        return "Short description";
    }
    
    private void getList(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        try {
            RequestDispatcher dispatcher = null;
            List<Image> list = iS.getImageList();
            if (list != null) {
                 request.setAttribute("imageList", list);   
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
        } 
    }
      
}

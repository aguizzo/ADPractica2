package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ImageService;
import models.Image;

@WebServlet(name = "ImageDelete", urlPatterns = {"/ImageDelete"})
public class ImageDelete extends HttpServlet {
    
    private final ImageService iS = ImageService.getInstance();
    
    protected void deleteImageRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id = request.getParameter("ID");
            int ID = Integer.parseInt(id);
            Image im = iS.getImage(ID);           
            String fileName = im.getFileName();
            boolean deleted = deleteFile(fileName);
            if(deleted){
                boolean itworks = iS.deleteImage(ID);
                if (itworks) {
                    out.println("<h1>Imagen eliminada con éxito</h1>");
                    out.println("<p><a href=\"/practica2/menu.jsp\">Menú</a>");
                }
                else {
                    response.sendRedirect(request.getContextPath() + "/error.jsp");
                }
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
    
     private boolean deleteFile(String fileName)
            throws IOException {
        boolean deleted = false;
        String path = getPath(fileName);
        File image = new File(path);
        image.delete();
        deleted = true;
        return deleted;
    }
     
    private String getPath(String fileName) {
        String path = getServletContext().getRealPath("");
        path = path.replace("target/practica2-1.0-SNAPSHOT", "");
        String relativePath = "src" + File.separator + "main" + File.separator
            + "webapp" + File.separator + "images" + File.separator + fileName;
        return path + relativePath;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        deleteImageRequest(request, response);
    }

}

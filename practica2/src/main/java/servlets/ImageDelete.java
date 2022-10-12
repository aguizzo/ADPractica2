/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author alumne
 */
@WebServlet(name = "ImageDelete", urlPatterns = {"/ImageDelete"})
public class ImageDelete extends HttpServlet {
    private final ImageService iS = ImageService.getInstance();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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

  
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

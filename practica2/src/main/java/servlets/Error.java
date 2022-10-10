package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Error", urlPatterns = {"/Error"})
public class Error extends HttpServlet {


    protected void errorRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String errorCode = request.getParameter("code");
            String errorMsg = getErrorMessage(errorCode);
            request.setAttribute("Msg", errorMsg);
            
            RequestDispatcher dispatcher = request.
                    getRequestDispatcher("error.jsp");           
            dispatcher.forward(request, response);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        errorRequest(request, response);
    }
    
    private String getErrorMessage(String errorCode) {
        int code;
        String errorMsg;
        
        if (errorCode == null) {
            errorMsg = "no params";
            return errorMsg;
        }
        else {
            code = Integer.parseInt(errorCode);
        }
        switch(code) {
            case 20:
                errorMsg = "La imagen no existe.";
                break;
            default: 
                errorMsg = "Ha ocurrido algo inesperado.";
        }
        return errorMsg;
    }

}

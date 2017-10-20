package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 463849
 */
public class HomeServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("activeUser");
        request.setAttribute("activeUser", user);
        if (user == null)
                {
                   response.sendRedirect("Login"); 
                }
        else{
            
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}

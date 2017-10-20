package servlets;

import business.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import business.UserService;

/**
 *
 * @author 463849
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cookie[] cookies = request.getCookies();
        String cookieName = "userNameCookie";
        HttpSession session = request.getSession();
        
        if(request.getParameter("action") != null)
        {
           
             String inactiveUser = (String) session.getAttribute("activeUser");
             request.setAttribute("loggedOut", inactiveUser + " is not logged in.");
            session.invalidate();
            
             for(Cookie cookie: cookies)
            {
                 if (cookieName.equals(cookie.getName()))
                    request.setAttribute("returningUser",cookie.getValue());
                 
            }
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        } 
        else if(session.getAttribute("activeUser")!= null)
        {
            response.sendRedirect("Home");
        }
        else if(cookies!= null)
        {
            for(Cookie cookie: cookies)
            {
                 if (cookieName.equals(cookie.getName()))
                    request.setAttribute("returningUser",cookie.getValue());
                 getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
       
        }
         else
        {
          getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService userService = new UserService();
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String[] rememberMe = request.getParameterValues("rememberMe");
        
        
        Cookie cookie = new Cookie("userNameCookie",user);
        
        
        if(user == null || user.isEmpty() || password == null || password.isEmpty())
        {
            request.setAttribute("fieldError", "Both fields must be entered.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        if(userService.login(user,password) != null)
        {
            User newUser = new User(user,null);
            HttpSession session = request.getSession();
            session.setAttribute("activeUser",newUser.getUsername());
            
            if(rememberMe != null)
            {
                
                cookie.setMaxAge(60*60*24);
                cookie.setPath("/");
                response.addCookie(cookie);
            
            }
            else
            {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
           
            response.sendRedirect("Home");
            
        }
        else
        {
            request.setAttribute("loginError", "Incorrect Username or Password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
    }
}

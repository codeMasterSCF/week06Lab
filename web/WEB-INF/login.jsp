<%-- 
    Document   : login
    Created on : Oct 9, 2017, 8:49:51 PM
    Author     : 463849
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/header.html" />

        <h1>Login</h1>
        
        <form method="post" action="Login">
            Username: <input type="text" name="user" value=${returningUser}><br><br>
            Password: <input type="text" name="password"><br><br>
            <input type="submit" value="Login"><br><br>
            <input type="checkbox" name ="rememberMe" value=${remberMe}> Remember Me
        </form><br>
            
        ${fieldError}
        ${loginError}
        ${loggedOut}
            
        
<c:import url="/WEB-INF/footer.html" />
   

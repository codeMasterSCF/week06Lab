<%-- 
    Document   : home
    Created on : Oct 9, 2017, 8:58:24 PM
    Author     : 463849
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/header.html" />

        <h1>Home Page</h1>
        
        <p>Hello ${activeUser}!</p><br>
        <p><a href="Login?action=logout">Logout</a></P>
    
<c:import url="/WEB-INF/footer.html" />

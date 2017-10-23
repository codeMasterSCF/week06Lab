<%-- 
    Document   : login
    Created on : Oct 20, 2017, 4:38:03 PM
    Author     : 463849
--%>

<%@tag description="login" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>Remember Me Login Page</h2>

    <form method="post" action="Login">
        Username: <input type="text" name="user" value=${returningUser}><br><br>
        Password: <input type="text" name="password"><br><br>
        <input type="submit" value="Login"><br><br>
        <input type="checkbox" name ="rememberMe" value=${remberMe}> Remember Me
    </form><br>
            
    ${fieldError}
    ${loginError}
    ${loggedOut}
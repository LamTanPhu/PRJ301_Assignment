<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="Login.css">
    </head>
    <body>
        <form action="LoginController" method="POST">
            User ID: <input type="text" name="userId" placeholder="Enter your User ID" required /> 
            <br>
            Password: <input type="password" name="password" placeholder="Enter your password" required />
            <br>
            <input name="action" type="submit" value="Login" /> 
            
            
            <% if (request.getAttribute("message") != null && !request.getAttribute("message").equals("")) { %>
                <p style="background-color:red;color:white;display:inline-block">${message}</p>
            <% } %>
            <%
                String error = (String) request.getAttribute("ERROR");
                if (error == null) {
                    error = "";
                }
            %>
            <%= error%>
            <p>Don't have an account? <a href="signUp.jsp">Sign Up</a></p>
        </form>
    </body>
</html>

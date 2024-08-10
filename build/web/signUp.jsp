<%@page import="dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
        <link rel="stylesheet" type="text/css" href="signup.css">
    </head>
    <body> 
        <form action ="MainController">
            <input type ="text" placeholder="userId" name ="userId" required />
            <input type ="text" placeholder="fullName" name ="fullName" required />
            <input type ="text" placeholder="password" name ="password" required />
            <input type ="hidden" name ="roleID" value="2" />
            <input type ="submit" name ="action" value ="AddUSER" />
        </form>
    </body>
</html>


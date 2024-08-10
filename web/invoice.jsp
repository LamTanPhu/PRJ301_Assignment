<%@page import="dto.Cart"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice Page</title>
        <link rel="stylesheet" type="text/css" href="Invoice.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Invoice for user: <%= request.getSession().getAttribute("userId")%></h1>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Mobile ID</th> 
                </tr>
            </thead>
            <tbody>
                <%
                    int cartCount = 0;
                    List<Cart> carts = (List) request.getAttribute("carts");
                    if (carts != null) {
                        for (Cart i : carts) {
                            cartCount++;
                %>
                <tr>
                    <td><%= cartCount%></td>
                    <td><%= i.getMobileId()%></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <a href="MainController?action=Logout" class="btn btn-primary Logout">Logout</a>
    </body>
</html>
